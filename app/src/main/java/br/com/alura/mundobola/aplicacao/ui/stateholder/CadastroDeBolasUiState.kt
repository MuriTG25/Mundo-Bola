package br.com.alura.mundobola.aplicacao.ui.stateholder

import br.com.alura.mundobola.dominio.Marca

data class CadastroDeBolasUiState(
    val listaDeMarcas: List<Marca> = emptyList(),
    val campoDoNome: String = "",
    val alteracaoDoCampoNome: (String) -> Unit = {},
    val campoDoPreco: String = "",
    val alteracaoDoCampoPreco: (String) -> Unit = {},
    val campoDaDescricao: String = "",
    val alteracaoDoCampoDescricao: (String) -> Unit = {},
) {

}
