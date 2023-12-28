package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.modelo.dto.paraBolaDTO
import br.com.alura.mundobola.aplicacao.modelo.dto.paraMarcaDTO
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.ListaDeBolasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
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

    init {
        viewModelScope.launch {
            carregaLista()
            carregaMarcas()
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

    private suspend fun carregaMarcas() {
        repositorio.listaDeMarcas().collect{marcas ->
            _uiState.value = _uiState.value.copy(
                listaDeMarcas = marcas.map{
                    it.paraMarcaDTO()
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
                    },
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

    fun listaDeBolasPorNomeAsc() {
        viewModelScope.launch {
            repositorio.listaDeBolasPorNomeAsc().let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                    expandirMenu = false
                )
            }
        }
    }

    fun listaDeBolasPorNomeDesc() {
        viewModelScope.launch {
            repositorio.listaDeBolasPorNomeDesc().let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                    expandirMenu = false
                )
            }
        }
    }

    fun listaDeBolasPorPrecoAsc() {
        viewModelScope.launch {
            repositorio.listaDeBolasPorPrecoAsc().let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                    expandirMenu = false
                )
            }
        }
    }

    fun listaDeBolasPorPrecoDesc() {
        viewModelScope.launch {
            repositorio.listaDeBolasPorPrecoDesc().let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                    expandirMenu = false
                )
            }
        }
    }

    fun listaDeBolasPeloMaisNovo() {
        viewModelScope.launch {
            repositorio.listaDeBolasPeloMaisNovo().let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                    expandirMenu = false
                )
            }
        }
    }

    fun listaDeBolasPeloMaisAntigo() {
        viewModelScope.launch {
            repositorio.listaDeBolasPeloMaisAntigo().let { lista ->
                _uiState.value = _uiState.value.copy(
                    listaDeBolas = lista.map {
                        it.paraBolaDTO()
                    },
                    expandirMenu = false
                )
            }
        }
    }

}