package br.com.alura.mundobola.ui.stateholder

import br.com.alura.mundobola.dominio.Marca
import java.time.LocalDateTime

data class CadastroDeBolasUiState(
    val listaDeMarcas: List<Marca> = emptyList(),
    val bolaId: String = "",
    val campoDoNome: String = "",
    val alteracaoDoCampoNome: (String) -> Unit = {},
    val campoDoPreco: String = "",
    val alteracaoDoCampoPreco: (String) -> Unit = {},
    val campoDaDescricao: String = "",
    val alteracaoDoCampoDescricao: (String) -> Unit = {},
    val expandirMenuMarca: Boolean = false,
    val alteracaoExpansaoMenuMarca: (Boolean) -> Unit = {},
    val marcaId: String = "",
    val pegaIdMarca: (String) -> Unit = {},
    val campoMarca: String = "",
    val alteracaoDoCampoMarca: (String) -> Unit = {},
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val mostraDialogImagem: Boolean = false,
    val noClickDaImagem: (Boolean) -> Unit = {},
    val mostraDialogErroPreco: Boolean = false,
    val noCLickDialogErroPreco: (Boolean) -> Unit = {},
    val fotoBola: String = "",
    val alteracaoDaImagemDaBola: (String) -> Unit = {},
    val campoNomeObrigatorio: Boolean = false,
    val campoPrecoObrigatorio: Boolean = false,
    val ehBolaNova: Boolean = true,
)
