package br.com.alura.mundobola.auxiliardoteste

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.aplicacao.extra.paraMoedaBrasileira
import java.time.LocalDateTime

const val tituloTelaLista = "Mundo Bola"
const val tituloTelaCadastroBola = "Cadastrar Bola"
const val tituloTelaEdicaoBola = "Editar Bola"
const val tituloTelaDetalhesBola = "Detalhes da Bola"
const val tituloTelaCadastroMarca = "Cadastrar Marca"
const val tituloTelaEdicaoMarca = "Editar Marca"
const val tituloTelaDetalhesMarca = "Detalhes da Marca"


const val descricaoCampoBusca = "Campo de texto de busca de bola"
const val iconeBuscaPesquisaDescricao =  "Buscar o produto pelo nome"
const val iconeVoltaPesquisaDescricao = "Fecha a aba de pesquisa"
const val iconeBuscaDescricao = "Buscar produto pelo nome"
const val iconeEdicaoDescricao = "Editar bola"
const val iconeDeletarDescricao = "Deletar bola"
const val iconeVoltarDescricao = "Voltar para a tela anterior"
const val iconeFABDescricao = "Adicionar Produto"
const val iconeOrdenacaoDescricao = "Ordenar a lista por:"
const val iconeMenuDescricao = "Abrir a aba lateral de Menu"

const val textoOrdenacaoNomeAsc =  "Nome Asc"
const val textoOrdenacaoNomeDesc = "Nome Desc"
const val textoOrdenacaoPrecoAsc = "Preço Asc"
const val textoOrdenacaoPrecoDesc = "Preço Desc"
const val textoOrdenacaoMaisNovo = "Mais Novo"
const val textoOrdenacaoMaisAntigo = "Mais Antigo"

const val labelCampoPesquisa = "Buscar bola"
const val placeholderCampoPesquisa = "Digite o nome da bola desejada"

const val textoTituloNavigationDrawer = "Marcas"
const val textoCadastroNavigationDrawer = "Cadastrar Marca"

const val textoNomeCadastroTela = "Nome"
const val textoPrecoCadastroTela = "Preço"
const val textoMarcaCadastroTela = "Marca"
const val textoDescricaoCadastroTela = "Descrição"
const val textoSalvarCadastroTela = "Salvar"
const val descricaoImagemCadastroTela = "imagem da bola"

val mensagemToastCadastroSucesso = "Bola cadastrada com sucesso"
val textoToastEdicaoSucesso = "Bola editada com sucesso"
val textoToastCarregamentoFalha = "Bola não encontrada"

const val placeholderNomeCadastroTela = "Insira o nome da Bola"
const val placeholderPrecoCadastroTela = "Insira o preço da bola"
const val placeholderDescricaoCadastroTela = "Insira uma descrição com mais detalhes sobre o produto"

const val textoNomeObrigatorioCadastroTela = "*Campo de Nome é obrigatório"
const val textoPrecoObrigatorioCadastroTela = "*Campo de Preço é obrigatório"


const val descricaoImagemScaffoldCadastroTela = "imagem da bola"
const val textoUrlScaffoldCadastroTela = "Url da Imagem"
const val dicaUrlScaffoldCadastroTela = "Insira o link contendo a imagem da bola"
const val textoCancelarScaffoldCadastroTela = "Cancelar"
const val textoConfirmarScaffoldCadastroTela = "Confirmar"

const val descricaoCardBola = "Card do produto"

const val textoPerguntaScaffoldDetalhesTela = "Deseja mesmo excluir essa bola?"
val textoCancelarScaffoldDetalhesTela = "Cancelar"
const val textoConfirmarScaffoldDetalhesTela = "Confirmar"


const val textoDescricaoProdutoTelaDetalhes = "Sobre o produto:"
const val textoMarcaTelaDetalhes = "Marca: "
const val textoDataCriacaoTelaDetalhes = "Criado em: "
const val textoDataAlteracaoTelaDetalhes = "Alterado em: "

const val nomeBolaTeste = "Mercurial"
const val precoBolaLimpoTeste = "19.90"
const val precoBolaComVirgula = "19,90"
val precoBolaEditadoTeste = "19.90".toBigDecimal().paraMoedaBrasileira()
const val urlBolaTeste = "https://images.tcdn.com.br/img/img_prod/728938/bola_futebol_de_campo_nike_mercurial_fade_13461_1_e9fb3615f52f43fc6d3e89b43f565731.png"
val descricaoBolaTeste = LoremIpsum(10).values.first()

const val marcaNikeTexto = "Nike"
const val marcaAdidasTexto = "Adidas"
const val marcaPenaltyTexto = "Penalty"

val nomeBolaExistente1 = bola1.nome
const val nomeBolaExistente2 = "Bola Nike Premier League Academy"
const val nomeBolaExistente3 = "Jabulani"
const val nomeBolaExtra1 = "Penalty Lider Campo"
const val nomeBolaExtra2 = "Bola Society Penalty Se7e R2 Ko X"
const val nomeBolaExtra3 = "Bola Al Rihla Pro"
val precoBolaExistenteEditado = "99.90".toBigDecimal().paraMoedaBrasileira()
const val precoBolaExistenteOriginal = "99.9"
val dataCriacaoBolaExistente: String =  bola1.dataCriacao.dataFormatada()
val dataCriacaoBolaNova = LocalDateTime.now().dataFormatada()
val descricaoBolaExistente = LoremIpsum(10).values.first()
const val imagemBolaExistente = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg"

const val mensagemDeErroPreco = "Utilize \",\" ou \".\" apenas para separar o real do centavos:\n ex: \"200,00 ou 200.00\"\n E não utilize outros símbolos, como \"-\", \"/\" para o preço"
const val precoComSimboloInvalido = "19/90"
const val precoComPontoEVirgula = "1.019,90"
const val precoCom2Pontos = "1.019.90"
const val precoCom2Virgulas = "1.019,90"
const val precoComSimboloNegativo = "-19.90"