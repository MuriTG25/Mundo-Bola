package br.com.alura.mundobola.aplicacao.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.dao.BolaDao
import br.com.alura.mundobola.aplicacao.ui.stateholder.ListaDeBolasUiState
import br.com.alura.mundobola.ui.extra.amostraDeListaDeBolas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListaDeBolasViewModel @Inject constructor(
   private val bolaDao: BolaDao
): ViewModel() {
    private val _uiState = MutableStateFlow(ListaDeBolasUiState())
    val uiState = _uiState.asStateFlow()
    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    listaDeBolas = bolaDao.listaDeBolas().value
                )
            }
        }
    }
}