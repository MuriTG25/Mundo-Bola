package br.com.alura.mundobola.aplicacao.dao

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.dominio.Bola
import java.time.LocalDateTime

val listaBolaCompletaNome = """Total90, Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sodales
laoreet, Jabulani, Penalty Lider Campo, Penalty Lider Campo, Penalty Lider Campo""".trimIndent()


const val idNike = "849324c0-2d2d-4097-87f4-68dae63b2f5b"
const val idPenalty = "8bc9a223-3a8f-4523-aba8-dc1d9811523b"
const val idAdidas = "4946112a-b895-4c8f-b5c1-1c8dc0b65dee"

val data = LocalDateTime.of(2022,8,14,10,40)

val BolaDeTesteCompleta = Bola(
    bolaId = "c6fec989-5440-49b5-8b03-8236556f46ab",
    nome = "Bola Nike",
    preco = "49.99".toBigDecimal(),
    marcaId = idNike,
    descricao = LoremIpsum(10).values.first(),
    dataCriacao = data,
    dataAlteracao = data,
    imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
    )

val BolaDeTesteSimples = Bola(
    nome = "Bola Nike",
    preco = "49.99".toBigDecimal()
    )

val BolaJaExistente = Bola(
    bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
    nome = "Total90",
    preco = "99.90".toBigDecimal(),
    marcaId = "849324c0-2d2d-4097-87f4-68dae63b2f5b",
    descricao = LoremIpsum(30).values.first(),
    dataCriacao = LocalDateTime.now(),
    imagem = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg",
)