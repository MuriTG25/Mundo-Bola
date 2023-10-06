package br.com.alura.mundobola.aplicacao.dao

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.dominio.Bola
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime
import javax.inject.Singleton

class BolaDao(){
    companion object{
        private val listaDeBolas = mutableListOf<Bola>(
            Bola(
                nome = "Total90",
                preco = "99.90".toBigDecimal(),
                marcaId = "2",
                descricao = LoremIpsum(30).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg",
            ),
            Bola(
                nome = LoremIpsum(10).values.first(),
                preco = "39.90".toBigDecimal(),
                marcaId = "1",
                descricao = LoremIpsum(10).values.first(),
                dataCriacao = LocalDateTime.now()
            ),
            Bola(
                nome = "Jabulani",
                preco = "1090.90".toBigDecimal(),
                marcaId = "1",
                descricao = LoremIpsum(10).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
            ),
            Bola(
                nome = "Penalty Lider Campo",
                preco = "299.90".toBigDecimal(),
                marcaId = "3",
                descricao = LoremIpsum(5).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://cambuci.vteximg.com.br/arquivos/ids/460927/bola-lider-n4-521305-1641-1.jpg?v=637819402244530000",
            ),
            Bola(
                nome = "Penalty Lider Campo",
                preco = "299.90".toBigDecimal(),
                marcaId = "3",
                descricao = LoremIpsum(100).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://cambuci.vteximg.com.br/arquivos/ids/943920/bola_campo_lider_xxi_521303_1850_1.jpg?v=638240930364500000"
            ),
            Bola(
                nome = "Penalty Lider Campo",
                preco = "299.90".toBigDecimal(),
                marcaId = "3",
                descricao = LoremIpsum(50).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://cambuci.vteximg.com.br/arquivos/ids/943919-292-292/bola-lider-521303-1710-1.jpg?v=638240930324100000",
            ),
        )
        private val listaDeBolasStateFlow = MutableStateFlow<List<Bola>>(listaDeBolas)
    }
    suspend fun listaDeBolas() = listaDeBolasStateFlow.asStateFlow()

    suspend fun adicionarBola(bola: Bola){
        listaDeBolas.add(bola)
    }
}