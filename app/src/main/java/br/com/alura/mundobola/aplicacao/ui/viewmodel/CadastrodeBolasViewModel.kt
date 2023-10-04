package br.com.alura.mundobola.aplicacao.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.mundobola.aplicacao.ui.stateholder.CadastroDeBolasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CadastrodeBolasViewModel @Inject constructor():ViewModel(){
    private val _uiState = MutableStateFlow(CadastroDeBolasUiState())
    val uiState = _uiState.asStateFlow()
    init {
        _uiState.update { cadastroDeBolasUiState ->
            cadastroDeBolasUiState.copy (
                alteracaoDoCampoNome = {
                    _uiState.value = _uiState.value.copy(
                        campoDoNome = it
                    )
                },
                alteracaoDoCampoPreco = {
                    _uiState.value = _uiState.value.copy(
                        campoDoPreco = it
                    )
                },
                alteracaoDoCampoDescricao = {
                    _uiState.value = _uiState.value.copy(
                        campoDaDescricao = it
                    )
                },
            )
        }
    }
}