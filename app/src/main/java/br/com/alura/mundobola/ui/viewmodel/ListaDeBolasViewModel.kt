package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.modelo.view.paraBolaView
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.ListaDeBolasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
            _uiState.update {listaDeBolasUiState->
                listaDeBolasUiState.copy(
                    listaDeBolas = repositorio.listaDeBolas().map {
                        it.paraBolaView()
                    }
                )
            }
        }
    }
}