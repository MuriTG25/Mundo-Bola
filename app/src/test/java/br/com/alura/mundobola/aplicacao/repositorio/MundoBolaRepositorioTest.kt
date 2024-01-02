package br.com.alura.mundobola.aplicacao.repositorio

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.aplicacao.modelo.entity.toBolaEntity
import br.com.alura.mundobola.aplicacao.modelo.entity.toMarcaEntity
import br.com.alura.mundobola.aplicacao.modelo.pojo.BolaPOJO
import br.com.alura.mundobola.aplicacao.modelo.pojo.MarcaPOJO
import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import br.com.alura.mundobola.auxiliarTeste.idNike
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import br.com.alura.mundobola.infraestrutura.database.dao.BolaDao
import br.com.alura.mundobola.infraestrutura.database.dao.MarcaDao
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class MundoBolaRepositorioTest {

    @MockK(relaxUnitFun = true)
    private lateinit var bolaDao: BolaDao
    @MockK(relaxUnitFun = true)
    private lateinit var marcaDao: MarcaDao

    private val toBolaEntity = mockkStatic(Bola::toBolaEntity)
    private val toMarcaEntity = mockkStatic(Marca::toMarcaEntity)

    @InjectMockKs
    lateinit var repositorio: MundoBolaRepositorio

    private val bolaMockadaCompleta = mockk<Bola> {
        every { bolaId } returns "c6fec989-5440-49b5-8b03-8236556f46ab"
        every { nome } returns "Bola Nike"
        every { preco } returns "49.99".toBigDecimal()
        every { marcaId } returns idNike
        every { descricao } returns LoremIpsum(10).values.first()
        every { dataCriacao } returns dataParaTestes
        every { dataAlteracao } returns dataParaTestes
        every { imagem } returns "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg"
    }
    private val bolaPOJOMockada = mockk<BolaPOJO>()
    private val marcaMockadaCompleta = mockk<Marca>{
        every { marcaId } returns idNike
        every { nome } returns "Nike"
        every { imagem } returns "https://logospng.org/wp-content/uploads/nike.jpg"
        every { dataCriacao } returns dataParaTestes
        every { dataAlteracao } returns dataParaTestes
    }
    private val marcaPOJOMockada = mockk<MarcaPOJO>()

    @get:Rule
    val mockkRule = MockKRule(this)

    @Test
    fun `Deve chamar a lista de bolas do boladao, Quando chamar a lista de bolas do repositorio`(): Unit =
        runBlocking {
            coEvery {
                bolaDao.listaDeBolas()
            } returns mockk()
            repositorio.listaDeBolas()
            coVerify {
                bolaDao.listaDeBolas()
            }
        }

    @Test
    fun `Deve chamar toBolaEntity e adicao de bola do BolaDao, Quando chamar a adicao de bolas do repositorio`(): Unit =
        runBlocking {
            repositorio.adicionarBola(bolaMockadaCompleta)
            coVerifySequence {
                toBolaEntity
                bolaDao.adicionarBola(any())
            }
        }
    @Test
    fun `Deve chamar toMarcaEntity e adicao de Marca do BolaDao, Quando chamar a adição de Marca do repositorio`() =
        runBlocking{
            repositorio.adicionarMarca(marcaMockadaCompleta)
            coVerifySequence {
                toMarcaEntity
                marcaDao.adicionarMarca(any())
            }
    }

    @Test
    fun `Deve chamar a lista de Marcas do MarcaDao, Quando chamar a lista de Marcas do repositorio`(): Unit =
        runBlocking {
            coEvery {
                marcaDao.listaDeMarcas()
            } returns mockk()
            repositorio.listaDeMarcas()
            coVerify {
                marcaDao.listaDeMarcas()
            }
        }

    @Test
    fun `Deve chamar bola do BolaDao, Quando chamar Bola pelo Id do repositorio`(): Unit =
        runBlocking {
            coEvery {
                bolaDao.encontrarBolaPeloId("")
            } returns mockk()
            repositorio.encontrarBolaPeloId("")
            coVerify {
                bolaDao.encontrarBolaPeloId("")
            }
        }

    @Test
    fun `Deve chamar Marca do MarcaDao, Quando chamar Marcas pelo Id do repositorio`(): Unit =
        runBlocking {
            coEvery {
                marcaDao.encontrarMarcaPeloId("")
            } returns mockk()
            repositorio.encontrarMarcaPeloId("")
            coVerify {
                marcaDao.encontrarMarcaPeloId("")
            }
        }

    @Test
    fun `Deve chamar DeletaBola do BolaDao, Quando chamar deletar Bola do repositorio`(): Unit =
        runBlocking {
            repositorio.deletaBola("")
            coVerify {
                bolaDao.deletaBola("")
            }
        }

    @Test
    fun `Deve chamar editaBola do BolaDao, Quando chamar editar Bola do repositorio`(): Unit =
        runBlocking {
            repositorio.editaBola(bolaPOJOMockada)
            coVerify {
                bolaDao.editaBola(any())
            }
        }
    @Test
    fun `Deve chamar editaMarca do BolaDao, Quando chamar editar Marca do repositorio`() =
        runBlocking{
        repositorio.editaMarca(marcaPOJOMockada)
            coVerify {
                marcaDao.editaMarca(any())
            }
    }
    @Test
    fun `Deve chamar o buscaBolaPorNome do BolaDao, Quando chamar buscaBolaPorNome do repositorio`(): Unit =
        runBlocking {
            every {
                bolaDao.buscaBolasPorNome("")
            } returns mockk()
            repositorio.buscaBolaPorNome("")
            coVerify {
                bolaDao.buscaBolasPorNome("")
            }
        }
    //TODO: tenho que consertar estes testes
//    @Test
//    fun `Deve chamar o listaDeBolasPorNomeAsc do BolaDao, Quando chamar o listaDeBolasPorNomeAsc do repositorio`(): Unit =
//        runBlocking {
//            coEvery {
//                bolaDao.listaDeBolasPorNomeAsc()
//            } returns mockk()
//            repositorio.listaDeBolasPorNomeAsc()
//            coVerify{
//                bolaDao.listaDeBolasPorNomeAsc()
//            }
//        }
//    @Test
//    fun `Deve chamar o listaDeBolasPorNomeDesc do BolaDao, Quando chamar o listaDeBolasPorNomeDesc do repositorio`(): Unit =
//        runBlocking {
//            coEvery {
//                bolaDao.listaDeBolasPorNomeDesc()
//            } returns mockk()
//            repositorio.listaDeBolasPorNomeDesc()
//            coVerify {
//                bolaDao.listaDeBolasPorNomeDesc()
//            }
//        }
//    @Test
//    fun `Deve chamar o listaDeBolasPorPrecoAsc do BolaDao, Quando chamar o listaDeBolasPorPrecoAsc do repositorio`(): Unit =
//        runBlocking {
//            coEvery {
//                bolaDao.listaDeBolasPorPrecoAsc()
//            } returns mockk()
//            repositorio.listaDeBolasPorPrecoAsc()
//            coVerify {
//                bolaDao.listaDeBolasPorPrecoAsc()
//            }
//        }
//    @Test
//    fun `Deve chamar o listaDeBolasPorPrecoDesc do BolaDao, Quando chamar o listaDeBolasPorPrecoDesc do repositorio`(): Unit =
//        runBlocking {
//            coEvery {
//                bolaDao.listaDeBolasPorPrecoDesc()
//            } returns mockk()
//            repositorio.listaDeBolasPorPrecoDesc()
//            coVerifyAll {
//                toBola
//                bolaDao.listaDeBolasPorPrecoDesc()
//            }
//        }
//    @Test
//    fun `Deve chamar o listaDeBolasPeloMaisNovo do BolaDao, Quando chamar o listaDeBolasPeloMaisNovo do repositorio`(): Unit =
//        runBlocking {
//            coEvery {
//                bolaDao.listaDeBolasPeloMaisNovo()
//            } returns mockk()
//            repositorio.listaDeBolasPeloMaisNovo()
//            coVerify {
//                bolaDao.listaDeBolasPeloMaisNovo()
//            }
//        }
//    @Test
//    fun `Deve chamar o listaDeBolasPeloMaisAntigo do BolaDao, Quando chamar o listaDeBolasPeloMaisAntigo do repositorio`(): Unit =
//        runBlocking {
//            coEvery {
//                bolaDao.listaDeBolasPeloMaisAntigo()
//            } returns mockk()
//            repositorio.listaDeBolasPeloMaisAntigo()
//            coVerify {
//                bolaDao.listaDeBolasPeloMaisAntigo()
//            }
//        }
}