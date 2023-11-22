package br.com.alura.mundobola.auxiliardoteste

import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.aplicacao.extra.paraMoedaBrasileira
import java.time.LocalDateTime

val tituloTelaLista = "Mundo Bola"
val tituloTelaCadastro = "Cadastrar/Editar Bola"
val tituloTelaDetalhes = "Detalhes da Bola"
val iconeBuscaDescricao = "Buscar produto pelo nome"
val iconeEdicaoDescricao = "Editar bola"
val iconeDeletarDescricao = "Deletar bola"
val iconeVoltarDescricao = "Voltar para a tela anterior"
val iconeFABDescricao = "Adicionar Produto"

val textoNomeCadastroTela = "Nome"
val textoPrecoCadastroTela = "Preço"
val textoMarcaCadastroTela = "Marca"
val textoDescricaoCadastroTela = "Descrição"
val textoSalvarCadastroTela = "Salvar"
val descricaoImagemCadastroTela = "imagem da bola"

val placeholderNomeCadastroTela = "Insira o nome da Bola"
val placeholderPrecoCadastroTela = "Insira o preço da bola"
val placeholderDescricaoCadastroTela = "Insira uma descrição com mais detalhes sobre o produto"

val textoNomeObrigatorioCadastroTela = "*Campo de Nome é obrigatório"
val textoPrecoObrigatorioCadastroTela = "*Campo de Preço é obrigatório"


val descricaoImagemScaffoldCadastroTela = "imagem da bola"
val textoUrlScaffoldCadastroTela = "Url da Imagem"
val dicaUrlScaffoldCadastroTela = "Insira o link contendo a imagem da bola"
val textoCancelarScaffoldCadastroTela = "Cancelar"
val textoConfirmarScaffoldCadastroTela = "Confirmar"


val textoDescricaoProdutoTelaDetalhes = "Sobre o produto:"
val textoMarcaTelaDetalhes = "Marca: "
val textoDataCriacaoTelaDetalhes = "Criado em: "
val textoDataAlteracaoTelaDetalhes = "Alterado em: "

val nomeBolaTeste = "Mercurial"
val precoBolaTeste = "19.90"
val marcaNikeTexto = "Nike"
val marcaAdidasTexto = "Adidas"
val marcaPenaltyTexto = "Penalty"

val nomeBolaExistente = "Jabulani"
val precoBolaExistenteEditado = "1090.90".toBigDecimal().paraMoedaBrasileira()
val precoBolaExistenteOriginal = "1090.90"
val dataCriacaoBolaExistente = LocalDateTime.now().dataFormatada()
