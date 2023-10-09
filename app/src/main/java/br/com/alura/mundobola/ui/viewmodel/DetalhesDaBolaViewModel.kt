package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.DetalhesDaBolaUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetalhesDaBolaViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
): ViewModel(){
    private val _uiState = MutableStateFlow(DetalhesDaBolaUiState())
    val uiState = _uiState.asStateFlow()
    init {

    }
    suspend fun buscaPorId(id: String){

    }
}