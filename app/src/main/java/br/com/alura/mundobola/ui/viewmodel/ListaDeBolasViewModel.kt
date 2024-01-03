package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.extra.OrdenacaoDaLista
import br.com.alura.mundobola.aplicacao.modelo.dto.paraBolaDTO
import br.com.alura.mundobola.aplicacao.modelo.dto.paraMarcaDTO
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.ListaDeBolasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListaDeBolasViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ListaDeBolasUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
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
                alteracaoDaExpansaoOrdenacao = {
                    _uiState.value = _uiState.value.copy(
                        expandirOrdenacao = it
                    )
                },
            )

        }
    }


    private suspend fun carregaLista() {
        repositorio.listaDeBolas()
            .collect { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                )
                //TODO preciso melhorar a implementação desse collect
                repositorio.listaDeMarcas().first().let { marcas ->
                    _uiState.value = _uiState.value.copy(
                        listaDeMarcas = marcas.map {
                            it.paraMarcaDTO()
                        }
                    )
                }
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
    fun listaDeBolasOrdenada(ordenacaoDaLista: OrdenacaoDaLista){
        viewModelScope.launch {
            repositorio.listaDeBolasOrdenada(ordenacaoDaLista).let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                    expandirOrdenacao = false
                )
            }
        }
    }

}