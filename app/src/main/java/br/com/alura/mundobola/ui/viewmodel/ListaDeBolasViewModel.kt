package br.com.alura.mundobola.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.modelo.dto.paraBolaDTO
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.ListaDeBolasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListaDeBolasViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ListaDeBolasUiState())
    val uiState = _uiState.asStateFlow()
    private val job = viewModelScope

    init {
        job.launch {
            carregaLista()
        }
        _uiState.update { listaDeBolasUiState ->
            listaDeBolasUiState.copy(
                noClicaBusca = {
                    _uiState.value = _uiState.value.copy(
                        mostraTituloBuscaEOrdenaPor = false,
                    )
                },
                noClicaVolta = {
                    _uiState.value = _uiState.value.copy(
                        mostraTituloBuscaEOrdenaPor = true,
                        textoDeBusca = ""
                    )
                },
                naMudancaDaBusca = { texto ->
                    _uiState.value = _uiState.value.copy(
                        textoDeBusca = texto
                    )
                    viewModelScope.launch {
                        realizaABusca(texto)
                    }
                },
                alteracaoDaExpansaoMenu = {
                    _uiState.value = _uiState.value.copy(
                        expandirMenu = it
                    )
                }
            )

        }
    }

    private suspend fun carregaLista() {
        repositorio.listaDeBolas()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
            .collect { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    }
                )
            }
    }

    private fun realizaABusca(textoDeBusca: String) {
        viewModelScope.launch {
            repositorio.buscaBolaPorNome(textoDeBusca)
                .collect { lista ->
                    _uiState.value = _uiState.value.copy(
                        listaDeBusca = lista.map {
                            it.paraBolaDTO()
                        }
                    )
                }
        }
    }
//TODO ainda não consegui implementar a ordenação da lista
    fun ordenaListaPorDesc(property: String) {
        Log.i("ListaDeBolasViewModel", "clica no ordena / $property")
        job.cancel()
        job.launch {
            repositorio.listaDeBolasOrdenadaDesc(property)
                .collect { lista ->
                    Log.i("ListaDeBolasViewModel","tamamnho lista ${lista.size}")
                    _uiState.value = _uiState.value.copy(
                        listaDeBolas = lista.map {
                            it.paraBolaDTO()
                        }
                    )
                }
        }
    }
    //TODO ainda não consegui implementar a ordenação da lista
    fun ordenaListaPorAsc(property: String) {
        Log.i("ListaDeBolasViewModel", "clica no ordena / $property")
        job.launch {
            repositorio.listaDeBolasOrdenadaAsc(property)
                .collect { lista ->
                    Log.i("ListaDeBolasViewModel","tamamnho lista ${lista.size}")
                    _uiState.value = _uiState.value.copy(
                        listaDeBolas = lista.map {
                            it.paraBolaDTO()
                        }
                    )
                }
        }
    }

}