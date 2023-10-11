package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.DetalhesDaBolaUiState
import br.com.alura.mundobola.ui.stateholder.ScaffoldUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ScaffoldViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio
):ViewModel() {
    private val _uiState = MutableStateFlow(ScaffoldUiState())
    val uiState = _uiState.asStateFlow()
    suspend fun editaUsuario(id:String){

    }
    suspend fun deletaUsuario(id: String){
        repositorio.deletaBola(id)
    }
}