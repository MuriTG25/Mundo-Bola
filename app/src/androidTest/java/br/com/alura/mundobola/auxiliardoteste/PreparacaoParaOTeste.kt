package br.com.alura.mundobola.auxiliardoteste

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.aplicacao.modelo.entity.BolaEntity
import br.com.alura.mundobola.aplicacao.modelo.entity.MarcaEntity
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.infraestrutura.database.MundoBolaDatabase
import br.com.alura.mundobola.infraestrutura.database.dao.BolaDao
import br.com.alura.mundobola.infraestrutura.database.dao.MarcaDao
import java.time.LocalDateTime

fun MundoBolaDatabase.limpaDatabase() {
    clearAllTables()
}

private val dataMaisAntigo = LocalDateTime.of(2022, 8, 14, 10, 40)
private val dataMedia = LocalDateTime.of(2022, 10, 14, 10, 40)
private val dataMaisNovo = LocalDateTime.of(2023, 8, 14, 10, 40)
private const val idNike = "849324c0-2d2d-4097-87f4-68dae63b2f5b"

private val marcaNike = MarcaEntity(
    marcaId = idNike,
    nome = "Nike",
    imagem = "https://logospng.org/wp-content/uploads/nike.jpg",
    dataCriacao = dataMaisAntigo,
    dataAlteracao = dataMaisNovo
)
val bola1 = BolaEntity(
    bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
    nome = "Total90",
    preco = "99.90".toBigDecimal(),
    marcaId = idNike,
    descricao = LoremIpsum(10).values.first(),
    dataCriacao = dataMaisAntigo,
    imagem = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg",
)
private val bola2 = BolaEntity(
    bolaId = "0309d77c-c7c1-4eb7-b2ba-457b7eafade4",
    nome = "Bola Nike Premier League Academy",
    preco = 199.90.toBigDecimal(),
    marcaId = idNike,
    descricao = "A Bola de Futebol Premier League Academy tem sulcos inovadores projetados para um giro consistente quando a bola está no ar. ",
    imagem = "https://imgnike-a.akamaihd.net/768x768/0243935B.jpg",
    dataCriacao = dataMaisNovo
)
private val bola3 = BolaEntity(
    bolaId = "da6d14aa-9125-4f5a-871e-bbca635c9255",
    nome = "Jabulani",
    preco = "1090.90".toBigDecimal(),
    marcaId = idNike,
    descricao = LoremIpsum(10).values.first(),
    dataCriacao = dataMedia,
    imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
)

suspend fun insereDadosNoDb(
    marcaDao: MarcaDao,
    bolaDao: BolaDao,
) {
    marcaDao.adicionarMarca(
        marcaNike
    )
    bolaDao.adicionarBola(
        bola1
    )
    bolaDao.adicionarBola(
        bola2
    )
    bolaDao.adicionarBola(
        bola3
    )
}
suspend fun MarcaDao.inserirMaisMarcasNoDb(){
    adicionarMarca(marca2)
    adicionarMarca(marca3)
}

private val marca2 = MarcaEntity(
"4946112a-b895-4c8f-b5c1-1c8dc0b65dee",
"Adidas",
"https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png",
LocalDateTime.now()
)

private val marca3 = MarcaEntity(
"8bc9a223-3a8f-4523-aba8-dc1d9811523b",
"Penalty",
"https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png",
LocalDateTime.now()
)