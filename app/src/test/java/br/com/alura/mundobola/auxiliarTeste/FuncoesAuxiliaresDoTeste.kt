package br.com.alura.mundobola.auxiliarTeste

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.aplicacao.modelo.entity.BolaEntity
import br.com.alura.mundobola.aplicacao.modelo.entity.MarcaEntity
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import java.time.LocalDateTime

val listaBolaCompletaNome = """Total90, Jabulani, Penalty Lider Campo, Penalty Lider Campo, Penalty Lider Campo""".trimIndent()


const val idNike = "849324c0-2d2d-4097-87f4-68dae63b2f5b"
const val idPenalty = "8bc9a223-3a8f-4523-aba8-dc1d9811523b"
const val idAdidas = "4946112a-b895-4c8f-b5c1-1c8dc0b65dee"

val dataParaTestes = LocalDateTime.of(2022,8,14,10,40)

val bolaIdTeste = "c6fec989-5440-49b5-8b03-8236556f46ab"
val nomeBolaTeste = "Bola Nike"
val precoBolaTeste = "49.99".toBigDecimal()
val descricaoBolaTeste = LoremIpsum(10).values.first()
val imagemBolaTeste = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg"

val bolaDeTesteCompleta = Bola(
    bolaId = "c6fec989-5440-49b5-8b03-8236556f46ab",
    nome = "Bola Nike",
    preco = "49.99".toBigDecimal(),
    marcaId = idNike,
    descricao = LoremIpsum(10).values.first(),
    dataCriacao = dataParaTestes,
    dataAlteracao = dataParaTestes,
    imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
    )

val bolaDeTesteSimples = Bola(
    nome = "Bola Nike",
    preco = "49.99".toBigDecimal()
    )
val bolaEntityDeTesteCompleta = BolaEntity(
    bolaId = "c6fec989-5440-49b5-8b03-8236556f46ab",
    nome = "Bola Nike",
    preco = "49.99".toBigDecimal(),
    marcaId = idNike,
    descricao = LoremIpsum(10).values.first(),
    dataCriacao = dataParaTestes,
    dataAlteracao = dataParaTestes,
    imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
    )

val bolaEntityDeTesteSimples = BolaEntity(
    nome = "Bola Nike",
    preco = "49.99".toBigDecimal()
    )

val BolaJaExistenteParaTestes = Bola(
    bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
    nome = "Total90",
    preco = "99.90".toBigDecimal(),
    marcaId = "849324c0-2d2d-4097-87f4-68dae63b2f5b",
    descricao = LoremIpsum(30).values.first(),
    dataCriacao = LocalDateTime.now(),
    imagem = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg",
)
val marcaCompletaParaTestes = Marca(
    "344e9c2d-6c08-44aa-a443-459562b629b4",
    "Umbro",
    "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png",
    dataCriacao = dataParaTestes,
    dataAlteracao = dataParaTestes
)
val marcaSimpleParaTestes = Marca(
    "344e9c2d-6c08-44aa-a443-459562b629b4",
    "Umbro",
)
val marcaEntityCompletaParaTestes = MarcaEntity(
    "344e9c2d-6c08-44aa-a443-459562b629b4",
    "Umbro",
    "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png",
    dataCriacao = dataParaTestes,
    dataAlteracao = dataParaTestes
)
val marcaEntitySimpleParaTestes = MarcaEntity(
    "344e9c2d-6c08-44aa-a443-459562b629b4",
    "Umbro",
)
val idMarcaTeste = "344e9c2d-6c08-44aa-a443-459562b629b4"
val nomeMarcaTeste = "Umbro"
val imagemMarcaTeste = "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png"