package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.extra.ID_BOLA
import br.com.alura.mundobola.aplicacao.modelo.dto.paraBolaDTO
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.DetalhesDaBolaUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetalhesDaBolaViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
    stateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetalhesDaBolaUiState())
    val uiState = _uiState.asStateFlow()
    private val id = stateHandle.get<String>(ID_BOLA)

    init {
        viewModelScope.launch {
            id?.let {
                buscaPorId(it)
            }
        }
        _uiState.update { detalhesDaBolaUiState ->
            detalhesDaBolaUiState.copy(
                noClickDaImagem = {
                    _uiState.value = _uiState.value.copy(
                        expandirImagem = it
                    )
                },
                noClickDaDescricao = {
                    _uiState.value = _uiState.value.copy(
                        expandirDescricao = it
                    )
                },
                noClickConfirmacaoExclusao = {
                    _uiState.value = _uiState.value.copy(
                        expandirConfirmacaoExclusao = it
                    )
                }
            )

        }
    }

    suspend fun buscaPorId(id: String) {
        repositorio.encontrarBolaPeloId(id).collect { coleta ->
            coleta?.let { bola ->
                with(bola.paraBolaDTO()) {
                    _uiState.value = _uiState.value.copy(
                        bolaId = bolaId,
                        nomeBola = nome,
                        precoDaBola = preco,
                        descricaoDaBola = descricao,
                        imagemDaBola = imagem,
                        dataCriacaoBola = dataCriacao,
                        dataAlteracaoBola = dataAlteracao,
                    )
                }
                bola.marcaId?.let { idDaMarca ->
                    repositorio.encontrarNomeMarcaPeloId(idDaMarca).collect { coletaMarca ->
                        coletaMarca?.let { nome ->
                            _uiState.value = _uiState.value.copy(
                                nomeDaMarca = nome
                            )
                        } ?: marcaNaoEncontrada()
                    }
                } ?: marcaNaoEncontrada()
            } ?: telaDeErro()
        }
    }

    private fun marcaNaoEncontrada() {
        _uiState.update {
            it.copy(
                nomeDaMarca = ""
            )
        }
    }

    private fun telaDeErro() {
        _uiState.update {
            it.copy(
                usuarioEncontrado = false,
            )
        }
    }

    suspend fun deletaBola(id: String) {
        repositorio.deletaBola(id)
        _uiState.update {
            it.copy(
                ativarToast = true,
            )
        }
    }
}