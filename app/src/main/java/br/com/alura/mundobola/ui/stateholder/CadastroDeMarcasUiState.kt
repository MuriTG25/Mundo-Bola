package br.com.alura.mundobola.ui.stateholder

import java.time.LocalDateTime

data class CadastroDeMarcasUiState(
    val marcaId: String = "",
    val campoDoNome: String = "",
    val alteracaoDoCampoNome: (String) -> Unit = {},
    val urlImagem: String = "",
    val alteracaoDoCampouUrlImagem: (String) -> Unit = {},
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val mostrarImagem: Boolean = false,
    val campoNomeObrigatorio: Boolean = false,
    val ehMarcaNova: Boolean = true,
    val mensagemErroCarregamento: Boolean = false,
    val mensagemCadastroConcluido: Boolean = false,
    val mensagemEdicaoConcluido: Boolean = false,
)
