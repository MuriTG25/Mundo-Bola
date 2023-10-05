package br.com.alura.mundobola.aplicacao.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.alura.mundobola.aplicacao.ui.stateholder.CadastroDeBolasUiState
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.ui.extra.amostraDeListaDeMarcas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CadastrodeBolasViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(CadastroDeBolasUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { cadastroDeBolasUiState ->
            cadastroDeBolasUiState.copy(
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
                alteracaoExpansaoMenuMarca = {
                    _uiState.value = _uiState.value.copy(
                        expandirMenuMarca = it
                    )
                },
                alteracaoDoCampoMarca = {
                    _uiState.value = _uiState.value.copy(
                        campoMarca = it
                    )
                },
                listaDeMarcas = amostraDeListaDeMarcas,
                pegaIdMarca = {
                    _uiState.value = _uiState.value.copy(
                        idMarca = it
                    )
                }
            )
        }
    }

    fun clicarSalvar() {
        with(_uiState.value) {
            val bola = Bola(
                nome = campoDoNome,
                //TODO validação do BigDecimal para não ocorrer exceção
                preco = campoDoPreco.toBigDecimal(),
                marcaId = idMarca,
                descricao = campoDaDescricao,
                dataCriacao = LocalDateTime.now()
            )
            Log.i("CadastrodeBolasViewModel", "Bola Salva: $bola")
        }
    }
}