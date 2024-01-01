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
private const val idAdidas = "4946112a-b895-4c8f-b5c1-1c8dc0b65dee"
private const val idPenalty = "8bc9a223-3a8f-4523-aba8-dc1d9811523b"

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

suspend fun MarcaDao.inserirMaisMarcasNoDb() {
    adicionarMarca(marca2)
    adicionarMarca(marca3)
}

private val marca2 = MarcaEntity(
    idAdidas,
    "Adidas",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png",
    LocalDateTime.now()
)

private val marca3 = MarcaEntity(
    idPenalty,
    "Penalty",
    "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png",
    LocalDateTime.now()
)

suspend fun BolaDao.inserirMaisBolasNoDb() {
    adicionarBola(bola4)
    adicionarBola(bola5)
    adicionarBola(bola6)
}

private val bola4 = BolaEntity(
    bolaId = "a27a1d9e-07b3-4ed5-bee0-1d66ee9a7054",
    nome = "Penalty Lider Campo",
    preco = 299.90.toBigDecimal(),
    marcaId = idPenalty,
    descricao = null,
    imagem = "https://d2p7wtszppk2p4.cloudfront.net/Custom/Content/Products/51/33/51330_bola-campo-lider-xxi-bc-lj-pt-t-u-pr-7852-5213031710_l4_637570278602232766.jpg",
    dataCriacao = LocalDateTime.now(),
    dataAlteracao = null
)
private val bola5 = BolaEntity(
    bolaId = "f6c7214f-5041-4096-91f2-26db7d4341df",
    nome = "Bola Society Penalty Se7e R2 Ko X",
    preco = 249.90.toBigDecimal(),
    marcaId = idPenalty,
    descricao = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer imperdiet tincidunt tortor non condimentum. Proin egestas accumsan nibh a iaculis. Suspendisse non leo erat. Sed lobortis ligula id tellus pretium. ",
    imagem = "https://images-americanas.b2w.io/produtos/7332761295/imagens/bola-de-futebol-society-penalty-se7e-r2-ko-x-pt-az-e-pt-am/7332761367_3_large.jpg",
    dataCriacao = dataMedia,
    dataAlteracao = null
)
private val bola6 = BolaEntity(
    bolaId = "e859e886-31dc-4fee-8d4f-01fbd565cabd",
    nome = "Bola Al Rihla Pro",
    preco = 999.90.toBigDecimal(),
    marcaId = idAdidas,
    descricao = "\"Al Rihla\" significa \"A Jornada\", e a bola é só o começo. O resto da sua jornada no futebol ainda vai ser escrito. Com estrutura sem costuras, esta bola oficial da Copa do Mundo FIFA Catar 2022™ adidas Al Rihla Pro representa um novo conceito de alta precisão. ",
    imagem = "https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/aa6f6d655b3d40a1a71cae680085031a_9366/Bola_Al_Rihla_Pro_Branco_H57783.jpg",
    dataCriacao = dataMaisAntigo,
    dataAlteracao = null
)