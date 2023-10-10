package br.com.alura.mundobola.aplicacao.dao

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime
import javax.inject.Singleton

class BolaDao(){
    companion object{
        private val listaDeBolas = mutableListOf<Bola>(
            Bola(
                bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
                nome = "Total90",
                preco = "99.90".toBigDecimal(),
                marcaId = "849324c0-2d2d-4097-87f4-68dae63b2f5b",
                descricao = LoremIpsum(30).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg",
            ),
            Bola(
                bolaId = "7cbc19a7-77d8-4fac-a8a9-057716b1c7fb",
                nome = LoremIpsum(10).values.first(),
                preco = "39.90".toBigDecimal(),
                marcaId = "4946112a-b895-4c8f-b5c1-1c8dc0b65dee",
                descricao = LoremIpsum(10).values.first(),
                dataCriacao = LocalDateTime.now()
            ),
            Bola(
                bolaId = "da6d14aa-9125-4f5a-871e-bbca635c9255",
                nome = "Jabulani",
                preco = "1090.90".toBigDecimal(),
                marcaId = "4946112a-b895-4c8f-b5c1-1c8dc0b65dee",
                descricao = LoremIpsum(10).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
            ),
            Bola(
                bolaId = "a27a1d9e-07b3-4ed5-bee0-1d66ee9a7054",
                nome = "Penalty Lider Campo",
                preco = "299.90".toBigDecimal(),
                marcaId = "8bc9a223-3a8f-4523-aba8-dc1d9811523b",
                descricao = LoremIpsum(5).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://cambuci.vteximg.com.br/arquivos/ids/460927/bola-lider-n4-521305-1641-1.jpg?v=637819402244530000",
            ),
            Bola(
                bolaId = "f6c7214f-5041-4096-91f2-26db7d4341df",
                nome = "Penalty Lider Campo",
                preco = "299.90".toBigDecimal(),
                marcaId = "8bc9a223-3a8f-4523-aba8-dc1d9811523b",
                descricao = LoremIpsum(100).values.first(),
                dataCriacao = LocalDateTime.now(),
                imagem = "https://cambuci.vteximg.com.br/arquivos/ids/943920/bola_campo_lider_xxi_521303_1850_1.jpg?v=638240930364500000"
            ),
            Bola(
                "0309d77c-c7c1-4eb7-b2ba-457b7eafade4",
                nome = "Penalty Lider Campo",
                preco = "299.90".toBigDecimal(),
                marcaId = "8bc9a223-3a8f-4523-aba8-dc1d9811523b",
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
    suspend fun encontrarBolaPeloId(id: String):Bola?{
        return listaDeBolas.firstOrNull{
            it.bolaId == id
        }
    }
}