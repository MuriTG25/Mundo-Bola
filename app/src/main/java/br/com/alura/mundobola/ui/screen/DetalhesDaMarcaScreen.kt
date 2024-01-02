package br.com.alura.mundobola.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.ui.components.comum.BotaoComponent
import br.com.alura.mundobola.ui.components.comum.ImagemBolaComponent
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.components.detalhesdabola.DialogImagemComponent
import br.com.alura.mundobola.ui.extra.amostraDeListaDeMarcas
import br.com.alura.mundobola.ui.extra.margemPadrao
import br.com.alura.mundobola.ui.extra.tamanhoFonteMini
import br.com.alura.mundobola.ui.extra.tamanhoFonteTitulo
import br.com.alura.mundobola.ui.stateholder.DetalhesDaMarcaUiState
import java.time.LocalDateTime

@Composable
fun DetalhesDaMarcaScreen(
    modifier: Modifier = Modifier,
    state: DetalhesDaMarcaUiState,
    navegarDeVolta: () -> Unit = {},
    noClicaEditaMarca: () -> Unit = {},
    noClicaDeletaMarca: () -> Unit = {},
) {
    if (state.marcaEncontrada) {
        ScaffoldScreen(
            titulo = "Detalhes da Marca",
            mostraVolta = true,
            noClicaVolta = navegarDeVolta,
            mostraEditaEDelete = true,
            noClicaEdita = noClicaEditaMarca,
            noClicaDeleta = noClicaDeletaMarca,
        ) {
            //TODO vou começar a implementar a tela de detalhes
            Column(
                modifier = modifier.fillMaxSize(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(2.dp, Color.Black),
                    horizontalArrangement = Arrangement.spacedBy(margemPadrao)
                ) {
                    ImagemBolaComponent(
                        modifier = Modifier
                            .fillMaxWidth(0.3F)
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .aspectRatio(1F)
                            .clickable {
                                state.noClickDaExpansaoDaImagem(true)
                            },
                        imagemDaBola = state.imagem,
                        escala = ContentScale.FillWidth
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = margemPadrao),
                    ) {
                        TextoProdutoComponent(
                            texto = state.nome,
                            fontSize = tamanhoFonteTitulo,
                            fontWeight = FontWeight.Bold
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(margemPadrao / 2)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                            ) {
                                TextoProdutoComponent(
                                    texto = "Criado em: ",
                                    fontSize = tamanhoFonteMini,
                                    fontWeight = FontWeight.Bold
                                )
                                TextoProdutoComponent(
                                    texto = state.dataCriacao,
                                    fontSize = tamanhoFonteMini
                                )
                            }
                            if (state.dataAlteracao.isNotBlank()) {
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    TextoProdutoComponent(
                                        texto = "Alterado em: ",
                                        fontSize = tamanhoFonteMini,
                                        fontWeight = FontWeight.Bold
                                    )
                                    TextoProdutoComponent(
                                        texto = state.dataAlteracao,
                                        fontSize = tamanhoFonteMini
                                    )
                                }
                            }
                        }

                    }
                }
                val icone = if (state.expandirListaDeBolas)
                    Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown
                val textoBotao = if (state.expandirListaDeBolas)
                    "Esconder lista de Bolas"
                else "Mostrar lista de Bolas"
                BotaoComponent(
                    modifier = Modifier
                        .padding(margemPadrao)
                        .fillMaxWidth(),
                    texto = textoBotao,
                    temImagem = true,
                    imagem = icone,
                    noClicarBotao = {
                        state.noClickDaExpansaoDaListaDeBolas(
                            !state.expandirListaDeBolas
                        )
                    }
                )
                if (state.expandirImagem) {
                    DialogImagemComponent(
                        modifier = Modifier.padding(margemPadrao / 2),
                        noClickkSair = {
                            state.noClickDaExpansaoDaImagem(false)
                        },
                        imagemDaBola = state.imagem,
                    )
                }
            }
        }
    } else {
        ErroScreen(
            descricaoErro = "buscar a Marca",
            navegarDeVolta = navegarDeVolta
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetalhesDaMarcaScreenComDataDeAlteracaoPreview() {
    DetalhesDaMarcaScreen(
        state = DetalhesDaMarcaUiState(
            nome = amostraDeListaDeMarcas.first().nome,
            marcaId = amostraDeListaDeMarcas.first().marcaId,
            dataCriacao = LocalDateTime.now().dataFormatada(),
            dataAlteracao = LocalDateTime.now().dataFormatada()
        )
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetalhesDaMarcaScreenSemDataDeAlteracaoPreview() {
    DetalhesDaMarcaScreen(
        state = DetalhesDaMarcaUiState(
            nome = amostraDeListaDeMarcas.first().nome,
            marcaId = amostraDeListaDeMarcas.first().marcaId,
            dataCriacao = LocalDateTime.now().dataFormatada(),
        )
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetalhesDaMarcaScreenComErro() {
    DetalhesDaMarcaScreen(
        state = DetalhesDaMarcaUiState(
            marcaEncontrada = false,
        )
    )
}