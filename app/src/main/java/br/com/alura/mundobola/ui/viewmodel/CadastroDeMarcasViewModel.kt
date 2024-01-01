package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.mundobola.aplicacao.extra.ID_GENERICO
import br.com.alura.mundobola.aplicacao.extra.ID_MARCA
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.CadastroDeMarcasUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CadastroDeMarcasViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
    stateHandle: SavedStateHandle,
):ViewModel(){
    private val _uiState = MutableStateFlow(CadastroDeMarcasUiState())
    val uiState = _uiState.asStateFlow()
    private val marcaId = stateHandle.get<String>(ID_MARCA)
    init {
        viewModelScope.launch {
            if (marcaId != null && marcaId != ID_GENERICO){
                carregaMarca(marcaId)
            }
        }
    }

    private suspend fun carregaMarca(marcaId: String) {
        repositorio.encontrarMarcaPeloId(marcaId).collect{coletaMarca->
            coletaMarca?.let { marca->
                with(marca){
                    _uiState.value = _uiState.value.copy(
                        marcaId = this.marcaId,
                        nome = nome,
                        imagem = imagem ?: "",
                        dataCriacao = dataCriacao
                    )
                }
            }
        }
    }
}