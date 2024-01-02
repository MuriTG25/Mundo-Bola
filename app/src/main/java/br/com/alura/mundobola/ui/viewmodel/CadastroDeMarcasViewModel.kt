package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
import br.com.alura.mundobola.aplicacao.extra.ID_MARCA
import br.com.alura.mundobola.aplicacao.extra.estaVazio
import br.com.alura.mundobola.aplicacao.modelo.pojo.MarcaPOJO
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.dominio.Marca
import br.com.alura.mundobola.ui.stateholder.CadastroDeMarcasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CadastroDeMarcasViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
    stateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(CadastroDeMarcasUiState())
    val uiState = _uiState.asStateFlow()
    private val marcaId = stateHandle.get<String>(ID_MARCA)

    init {
        viewModelScope.launch {
            if (marcaId != null && marcaId != ID_GENERICO) {
                carregaMarca(marcaId)
            }
        }
        _uiState.update { cadastroDeMarcasUiState ->
            cadastroDeMarcasUiState.copy(
                alteracaoDoCampoNome = { nome ->
                    _uiState.value = _uiState.value.copy(
                        campoDoNome = nome,
                        campoNomeObrigatorio = false,
                    )
                },
                alteracaoDoCampouUrlImagem = { imagem ->
                    _uiState.value = _uiState.value.copy(
                        urlImagem = imagem
                    )
                },
            )

        }
    }

    private suspend fun carregaMarca(marcaId: String) {
        repositorio.encontrarMarcaPeloId(marcaId).collect { coletaMarca ->
            coletaMarca?.let { marca ->
                with(marca) {
                    _uiState.value = _uiState.value.copy(
                        marcaId = this.marcaId,
                        campoDoNome = nome,
                        urlImagem = imagem ?: "",
                        dataCriacao = dataCriacao,
                        ehMarcaNova = false
                    )
                }
            } ?: mensagemErroCarregamento()
        }
    }

    suspend fun salvarMarca(
        irParaATelaDeLista: () -> Unit = {},
        irParaATelaDeDetalhesDaMarca: (String) -> Unit = {},
    ) {
        with(_uiState.value) {
            if (campoDoNome.isNullOrBlank()) {
                _uiState.value = _uiState.value.copy(
                    campoNomeObrigatorio = true,
                )
            } else {
                if (ehMarcaNova){
                    val marca = Marca(
                        nome = campoDoNome,
                        imagem = urlImagem.estaVazio(),
                        dataCriacao = LocalDateTime.now()
                    )
                    repositorio.adicionarMarca(marca)
                    mensagemCadastroSucesso()
                    viewModelScope.launch (Dispatchers.Main){
                        irParaATelaDeLista()
                    }
                } else {
                    val marca = MarcaPOJO(
                        marcaId = marcaId,
                        nome = campoDoNome,
                        imagem = urlImagem.estaVazio(),
                        dataAlteracao = LocalDateTime.now(),
                    )
                    repositorio.editaMarca(marca)
                    mensagemEdicaoSucesso()
                    viewModelScope.launch (Dispatchers.Main){
                        irParaATelaDeDetalhesDaMarca(marcaId)
                    }
                }
            }
        }
    }
    private fun mensagemCadastroSucesso() {
        _uiState.update { cadastroDecadastroDeMarcasUiState ->
            cadastroDecadastroDeMarcasUiState.copy(
                mensagemCadastroConcluido = true
            )
        }
    }
    private fun mensagemEdicaoSucesso() {
        _uiState.update { cadastroDeMarcasUiState ->
            cadastroDeMarcasUiState.copy(
                mensagemEdicaoConcluido = true
            )
        }
    }
    private fun mensagemErroCarregamento() {
        _uiState.update { cadastroDeMarcasUiState ->
            cadastroDeMarcasUiState.copy(
                mensagemErroCarregamento = true
            )
        }
    }
}