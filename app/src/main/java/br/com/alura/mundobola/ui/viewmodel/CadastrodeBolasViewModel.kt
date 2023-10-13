package br.com.alura.mundobola.ui.viewmodel

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.extra.ID_BOLA
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
import br.com.alura.mundobola.aplicacao.extra.estaVazio
import br.com.alura.mundobola.aplicacao.extra.paraBigDecimal
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.ui.extra.mensagemDeAviso
import br.com.alura.mundobola.ui.stateholder.CadastroDeBolasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CadastrodeBolasViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
    stateHandle: SavedStateHandle,
    private val application: Application,
) : ViewModel() {
    private val _uiState = MutableStateFlow(CadastroDeBolasUiState())
    val uiState = _uiState.asStateFlow()
    private val bolaId = stateHandle.get<String>(ID_BOLA)

    init {
        viewModelScope.launch {
            if (bolaId != null && bolaId != ID_GENERICO){
                carregaBola(bolaId)
            }
        }
        _uiState.update { cadastroDeBolasUiState ->
            cadastroDeBolasUiState.copy(
                alteracaoDoCampoNome = {
                    _uiState.value = _uiState.value.copy(
                        campoDoNome = it,
                        campoNomeObrigatorio = false
                    )
                },
                alteracaoDoCampoPreco = {
                    _uiState.value = _uiState.value.copy(
                        campoDoPreco = it,
                        campoPrecoObrigatorio = false
                    )
                },
                alteracaoDoCampoDescricao = {
                    _uiState.value = _uiState.value.copy(
                        campoDaDescricao = it
                    )
                },
                alteracaoExpansaoMenuMarca = {
                    _uiState.value = _uiState.value.copy(
                        expandirMenuMarca = it
                    )
                },
                alteracaoDoCampoMarca = {
                    _uiState.value = _uiState.value.copy(
                        campoMarca = it
                    )
                },
                pegaIdMarca = {
                    _uiState.value = _uiState.value.copy(
                        marcaId = it
                    )
                },
                noClickDaImagem = {
                    _uiState.value = _uiState.value.copy(
                        mostraDialogImagem = it
                    )
                },
                alteracaoDaImagemDaBola = {
                    _uiState.value = _uiState.value.copy(
                        fotoBola = it
                    )
                },
                noCLickDialogErroPreco = {
                    _uiState.value = _uiState.value.copy(
                        mostraDialogErroPreco = false
                    )
                }
            )
        }
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    listaDeMarcas = repositorio.listaDeMarcas()
                )
            }
        }
    }

    suspend fun carregaBola(id: String) {
        repositorio.encontrarBolaPeloId(id).collect {
            it?.let { bola ->
                with(bola) {
                    _uiState.value = _uiState.value.copy(
                        bolaId = bolaId,
                        campoDoNome = nome,
                        campoDoPreco = preco.toPlainString(),
                        dataCriacao = dataCriacao,
                        ehBolaNova = false,
                    )
                    descricao?.let {
                        _uiState.value = _uiState.value.copy(
                            campoDaDescricao = it
                        )
                    }
                    imagem?.let {
                        _uiState.value = _uiState.value.copy(
                            fotoBola = it
                        )
                    }
                    marcaId?.let {
                        _uiState.value = _uiState.value.copy(
                            marcaId = marcaId
                        )
                        repositorio.encontrarNomeMarcaPeloId(it)?.let { nomeMarca ->
                            _uiState.value = _uiState.value.copy(
                                campoMarca = nomeMarca
                            )
                        }
                    }
                }
            }?: application.applicationContext.mensagemDeAviso("Bola não encontrada")
        }
    }

    suspend fun clicarSalvar(
        irParaTelaPrincipal: () -> Unit = {},
        irParaATelaDeDetalhes: (String) -> Unit = {},
    ) {
        with(_uiState.value) {
            if (campoDoNome.isNullOrBlank() || campoDoPreco.isNullOrBlank()) {
                _uiState.value = _uiState.value.copy(
                    campoNomeObrigatorio = true,
                    campoPrecoObrigatorio = true,
                )
            } else {
                campoDoPreco.paraBigDecimal()?.let {
                    if (_uiState.value.ehBolaNova) {
                        val bola = Bola(
                            nome = campoDoNome,
                            preco = it,
                            marcaId = marcaId.estaVazio(),
                            descricao = campoDaDescricao.estaVazio(),
                            imagem = fotoBola.estaVazio(),
                            dataCriacao = LocalDateTime.now()
                        )
                        repositorio.adicionarBola(bola)
                        application.applicationContext.mensagemDeAviso("Bola cadastrada com sucesso")
                        irParaTelaPrincipal()
                    } else {
                        val bola = Bola(
                            bolaId = bolaId,
                            nome = campoDoNome,
                            preco = it,
                            marcaId = marcaId.estaVazio(),
                            descricao = campoDaDescricao.estaVazio(),
                            imagem = fotoBola.estaVazio(),
                            dataCriacao = dataCriacao,
                            dataAlteracao = LocalDateTime.now()
                        )
                        repositorio.editaBola(bola)
                        //TODO preciso implementar edição de bola
                        application.applicationContext.mensagemDeAviso("Bola editada com sucesso")
                        irParaATelaDeDetalhes(bolaId)
                    }
                } ?: mensagemDeErroNoPreco()
            }
        }
    }

    private fun mensagemDeErroNoPreco() {
        _uiState.value = _uiState.value.copy(
            mostraDialogErroPreco = true,
        )
    }

    fun carregarImagem(linkImagem: String) {
        _uiState.value = _uiState.value.copy(
            fotoBola = linkImagem,
            mostraDialogImagem = false,
        )
    }
}