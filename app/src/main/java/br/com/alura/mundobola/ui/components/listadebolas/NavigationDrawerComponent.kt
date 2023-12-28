package br.com.alura.mundobola.ui.components.listadebolas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.mundobola.aplicacao.modelo.dto.MarcaDTO
import br.com.alura.mundobola.ui.components.comum.TextoProdutoComponent
import br.com.alura.mundobola.ui.extra.amostraDeListaDeMarcas
import br.com.alura.mundobola.ui.extra.margemPadrao
import br.com.alura.mundobola.ui.extra.tamanhoFonteMedia

@Composable
fun NavigationDrawerComponent(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    listaDeMarcas: List<MarcaDTO> = emptyList(),
    noClicaMarca: (String) -> Unit = {},
    conteudo: @Composable () -> Unit = {},
) {
    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            Column (
                modifier = Modifier.fillMaxSize()
            ){
                TextoProdutoComponent(
                    modifier = Modifier.padding(margemPadrao/2),
                    texto = "Marcas",
                    fontSize = tamanhoFonteMedia,
                    fontWeight = FontWeight.Bold
                )
                LazyColumn(
                    modifier = Modifier
                ){
                    items(listaDeMarcas){marca ->
                        NavigationDrawerItemComImagemComponent(
                            titulo = marca.nome,
                            imagemDaMarca = marca.imagem,
                            noClicaItem = {
                                noClicaMarca(marca.marcaId)
                            }
                        )
                    }
                }
                NavigationDrawerItemSemImagemComponent(
                    titulo = "Cadastrar Marca"
                )
            }
        }
    ) {
        conteudo()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun NavigationDrawerComponentPreview() {
    NavigationDrawerComponent(
       drawerState =  rememberDrawerState(initialValue = DrawerValue.Open),
        listaDeMarcas = amostraDeListaDeMarcas,
    )
}