package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.extra.ID_MARCA
import br.com.alura.mundobola.aplicacao.modelo.dto.paraBolaDTO
import br.com.alura.mundobola.aplicacao.modelo.dto.paraMarcaDTO
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.DetalhesDaMarcaUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetalhesDaMarcaViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
    stateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetalhesDaMarcaUiState())
    val uiState = _uiState.asStateFlow()
    private val id = stateHandle.get<String>(ID_MARCA)

    init {
        viewModelScope.launch {
            id?.let {
                buscaMarca(it)
            }
        }
        _uiState.update {detalhesDaMarcaUiState ->
            detalhesDaMarcaUiState.copy(
                noClickDaExpansaoDaImagem = {
                    _uiState.value = _uiState.value.copy(
                        expandirImagem = it
                    )
                },
                noClickDaExpansaoDaListaDeBolas = {
                    _uiState.value = _uiState.value.copy(
                        expandirListaDeBolas = it
                    )
                }
            )

        }
    }

    private suspend fun buscaMarca(it: String) {
        repositorio.encontrarMarcaPeloId(it).collect { marca ->
            marca?.let {
                with(it.paraMarcaDTO()) {
                    _uiState.value = _uiState.value.copy(
                        marcaId = marcaId,
                        nome = nome,
                        imagem = imagem,
                        dataCriacao = dataCriacao,
                        dataAlteracao = dataAlteracao
                    )
                }
            } ?: telaDeErro()
        }
    }
    fun listaDeBolasPorMarca(marcaId: String) {
        viewModelScope.launch {
            repositorio.listaDeBolasPorMarca(marcaId).let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolasDaMarca = lista.map {
                        it.paraBolaDTO()
                    }
                )
            }
        }
    }

    private fun telaDeErro() {
        _uiState.update {
            it.copy(
                marcaEncontrada = false
            )
        }
    }

    fun deletaMarca(id: String) {

    }
}