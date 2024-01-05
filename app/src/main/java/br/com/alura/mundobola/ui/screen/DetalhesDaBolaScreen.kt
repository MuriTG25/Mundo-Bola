package br.com.alura.mundobola.ui.screen

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.components.detalhesdabola.DialogConfirmacaoExclusaoComponent
import br.com.alura.mundobola.ui.components.detalhesdabola.DialogImagemComponent
import br.com.alura.mundobola.ui.extra.bolaDeAmostra
import br.com.alura.mundobola.ui.extra.margemPadrao
import br.com.alura.mundobola.ui.extra.mensagemDeAviso
import br.com.alura.mundobola.ui.extra.tamanhoFonteGrande
import br.com.alura.mundobola.ui.extra.tamanhoFonteMedia
import br.com.alura.mundobola.ui.extra.tamanhoFonteMini
import br.com.alura.mundobola.ui.extra.tamanhoFonteTitulo
import br.com.alura.mundobola.ui.stateholder.DetalhesDaBolaUiState

@Composable
fun DetalhesDaBolaScreen(
    modifier: Modifier = Modifier,
    state: DetalhesDaBolaUiState,
    context: Context = LocalContext.current,
    navegarDeVolta: () -> Unit = {},
    noClicaEdita: () -> Unit = {},
    noClicaDeleta: () -> Unit = {},
) {
    if (state.marcaEncontrada) {
        ScaffoldScreen(
            titulo = "Detalhes da Bola",
            mostraVolta = true,
            mostraEditaEDelete = true,
            noClicaVolta = navegarDeVolta,
            noClicaEdita = noClicaEdita,
            noClicaDeleta = {
                state.noClickConfirmacaoExclusao(true)
            },
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .verticalScroll(rememberScrollState()),
            ) {
                ImagemBolaComponent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .height(200.dp)
                        .clickable {
                            state.noClickDaImagem(true)
                        },
                    imagemDaBola = state.imagemDaBola,
                    escala = ContentScale.FillHeight
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(margemPadrao)
                        .background(Color.White),
                    verticalArrangement = Arrangement.spacedBy(margemPadrao),
                ) {
                    TextoProdutoComponent(
                        texto = state.nomeBola,
                        fontSize = tamanhoFonteTitulo,
                        fontWeight = FontWeight.Bold
                    )
                    TextoProdutoComponent(
                        texto = state.precoDaBola,
                        fontSize = tamanhoFonteGrande,
                        fontWeight = FontWeight.Bold
                    )
                    if (!state.descricaoDaBola.isBlank()) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .clickable {
                                    state.noClickDaDescricao(!state.expandirDescricao)
                                },
                            shape = RoundedCornerShape(margemPadrao),
                            shadowElevation = 4.dp,
                            border = BorderStroke(1.dp, color = Color.Black),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(margemPadrao / 2)
                            ) {
                                TextoProdutoComponent(
                                    texto = "Sobre o produto:",
                                    fontSize = tamanhoFonteMedia,
                                    fontWeight = FontWeight.Bold
                                )
                                val tamanhoDescricao = if (state.expandirDescricao) {
                                    Int.MAX_VALUE
                                } else {
                                    5
                                }
                                TextoProdutoComponent(
                                    texto = state.descricaoDaBola, maxLines = tamanhoDescricao
                                )
                            }
                        }
                    }
                    if (!state.nomeDaMarca.isBlank()) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextoProdutoComponent(
                                texto = "Marca: ",
                                fontSize = tamanhoFonteMedia,
                                fontWeight = FontWeight.Bold
                            )
                            TextoProdutoComponent(
                                texto = state.nomeDaMarca,
                                fontSize = tamanhoFonteMedia
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(margemPadrao / 2)
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextoProdutoComponent(
                                texto = "Criado em: ",
                                fontSize = tamanhoFonteMini,
                                fontWeight = FontWeight.Bold
                            )
                            TextoProdutoComponent(
                                texto = state.dataCriacaoBola,
                                fontSize = tamanhoFonteMini
                            )
                        }
                        if (!state.dataAlteracaoBola.isBlank()) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                TextoProdutoComponent(
                                    texto = "Alterado em: ",
                                    fontSize = tamanhoFonteMini,
                                    fontWeight = FontWeight.Bold
                                )
                                TextoProdutoComponent(
                                    texto = state.dataAlteracaoBola,
                                    fontSize = tamanhoFonteMini
                                )
                            }
                        }
                    }
                }
                if (state.expandirImagem) {
                    DialogImagemComponent(
                        modifier = Modifier.padding(margemPadrao / 2),
                        noClickkSair = {
                            state.noClickDaImagem(false)
                        },
                        imagemDaBola = state.imagemDaBola,
                    )
                }
                if (state.expandirConfirmacaoExclusao) {
                    DialogConfirmacaoExclusaoComponent(
                        texto = "Deseja mesmo excluir essa bola?",
                        noClickDeletar = noClicaDeleta,
                        noClickSair = {
                            state.noClickConfirmacaoExclusao(false)
                        }
                    )
                }
                //TODO talvez eu substitua o toast pelo Snackbar
                if(state.ativarToast){
                    LaunchedEffect(key1 = Unit){
                        context.mensagemDeAviso("Bola Deletada com sucesso")
                    }
                }
            }
        }
    } else {
        ErroScreen(
            descricaoErro = "buscar a bola",
            navegarDeVolta = navegarDeVolta
        )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun DetalhesDaBolaScreenPreviewUsuarioEncontrado() {
    DetalhesDaBolaScreen(
        state = DetalhesDaBolaUiState(
            marcaEncontrada = true,
            nomeBola = bolaDeAmostra.nome,
            precoDaBola = bolaDeAmostra.preco,
            descricaoDaBola = bolaDeAmostra.descricao,
            nomeDaMarca = bolaDeAmostra.marcaId,
            dataCriacaoBola = bolaDeAmostra.dataCriacao,
            dataAlteracaoBola = bolaDeAmostra.dataAlteracao
        )
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetalhesDaBolaScreenPreviewUsuarioNaoEncontrado() {
    DetalhesDaBolaScreen(
        state = DetalhesDaBolaUiState(
            marcaEncontrada = false
        )
    )
}