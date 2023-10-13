package br.com.alura.mundobola.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.mundobola.aplicacao.modelo.view.paraBolaView
import br.com.alura.mundobola.aplicacao.modelo.view.paraMarcaView
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.ui.stateholder.DetalhesDaBolaUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetalhesDaBolaViewModel @Inject constructor(
    private val repositorio: MundoBolaRepositorio,
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetalhesDaBolaUiState())
    val uiState = _uiState.asStateFlow()
    suspend fun buscaPorId(id: String) {
        repositorio.encontrarBolaPeloId(id).collect {
            it?.let { bola ->
                with(bola.paraBolaView()) {
                    _uiState.value = _uiState.value.copy(
                        bolaId = bolaId,
                        nomeBola = nome,
                        precoDaBola = preco,
                        descricaoDaBola = descricao,
                        imagemDaBola = imagem,
                        dataCriacaoBola = dataCriacao,
                        dataAlteracaoBola = dataAlteracao,
                    )
                }
                bola.marcaId?.let {
                    repositorio.encontrarNomeMarcaPeloId(it)?.let { nome ->
                        _uiState.value = _uiState.value.copy(
                            nomeDaMarca = nome
                        )
                    } ?: marcaNaoEncontrada()
                } ?: marcaNaoEncontrada()
            } ?: telaDeErro()
        }
    }

    private fun marcaNaoEncontrada() {
        _uiState.update {
            it.copy(
                nomeDaMarca = "Marca não encontrada"
            )
        }
    }

    private fun telaDeErro() {
        _uiState.update {
            it.copy(
                usuarioEncontrado = false,
            )
        }
    }
}