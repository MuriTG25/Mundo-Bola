package br.com.alura.mundobola.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.extra.estaVazio
import br.com.alura.mundobola.aplicacao.extra.paraBigDecimal
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.CadastroDeBolasUiState
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.ui.extra.mensagemDeAviso
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
    private val application: Application,
) : ViewModel() {
    private val _uiState = MutableStateFlow(CadastroDeBolasUiState())
    val uiState = _uiState.asStateFlow()

    init {
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
                        idMarca = it
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

    suspend fun clicarSalvar(irParaTelaPrincipal: ()-> Unit = {}) {
        with(_uiState.value) {
            if (campoDoNome.isNullOrBlank() || campoDoPreco.isNullOrBlank()){
                _uiState.value = _uiState.value.copy(
                    campoNomeObrigatorio = true,
                    campoPrecoObrigatorio = true,
                )
            }
            else{
                campoDoPreco.paraBigDecimal()?.let {
                    val bola = Bola(
                        nome = campoDoNome,
                        preco = it,
                        marcaId = idMarca.estaVazio(),
                        descricao = campoDaDescricao.estaVazio(),
                        imagem = fotoBola.estaVazio(),
                        dataCriacao = LocalDateTime.now()
                    )
                    repositorio.adicionarBola(bola)
                    application.applicationContext.mensagemDeAviso("Bola cadastrada com sucesso")
                    irParaTelaPrincipal()
                    //TODO trocar toast por Alert Dialog
                } ?: application.applicationContext.mensagemDeAviso("Formato de preço invalido")
            }
        }
    }

    fun carregarImagem(linkImagem: String) {
        _uiState.value = _uiState.value.copy(
            fotoBola = linkImagem,
            mostraDialogImagem = false,
        )
    }
}