package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.modelo.dto.paraBolaDTO
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.ListaDeBolasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
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

    init {
        viewModelScope.launch {
            carregaLista()
        }
        _uiState.update { listaDeBolasUiState ->
            listaDeBolasUiState.copy(
                noClicaBusca = {
                    _uiState.value = _uiState.value.copy(
                        mostraTituloEIconeBusca = false,
                    )
                },
                noClicaVolta = {
                    _uiState.value = _uiState.value.copy(
                        mostraTituloEIconeBusca = true,
                        textoDeBusca = ""
                    )
                    viewModelScope.launch {
                        carregaLista()
                    }
                },
                naMudancaDaBusca = { texto ->
                    _uiState.value = _uiState.value.copy(
                        textoDeBusca = texto
                    )
                },
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

    fun realizaABusca() {
        viewModelScope.launch {
            repositorio.buscaBolaPorNome(_uiState.value.textoDeBusca)
                .collect { lista ->
                    _uiState.value = _uiState.value.copy(
                        listaDeBolas = lista.map {
                            it.paraBolaDTO()
                        }
                    )

                }
        }
    }

}