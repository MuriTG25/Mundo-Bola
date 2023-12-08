package br.com.alura.mundobola.aplicacao.repositorio

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.aplicacao.dao.BolaDao
import br.com.alura.mundobola.aplicacao.dao.MarcaDao
import br.com.alura.mundobola.aplicacao.extra.paraBigDecimal
import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteCompleta
import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import br.com.alura.mundobola.auxiliarTeste.idNike
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import io.mockk.Called
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.mockkConstructor
import io.mockk.mockkStatic
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MundoBolaRepositorioTest {
    @MockK(relaxUnitFun = true)
    private lateinit var bolaDao: BolaDao
    @MockK(relaxUnitFun = true)
    private lateinit var marcaDao: MarcaDao
    @InjectMockKs
    lateinit var repositorio: MundoBolaRepositorio

    private val bolaMockada = mockkClass(Bola::class)
    private val bolaMockadaCompleta = mockk<Bola>{
        every { bolaId } returns "c6fec989-5440-49b5-8b03-8236556f46ab"
        every { nome } returns "Bola Nike"
        every { preco } returns "49.99".toBigDecimal()
        every { marcaId } returns idNike
        every { descricao } returns LoremIpsum(10).values.first()
        every { dataCriacao } returns dataParaTestes
        every { dataAlteracao } returns dataParaTestes
        every { imagem } returns "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg"
    }
    private val marcaMockada = mockkClass(Marca::class)

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
    fun `Deve chamar adicao de bola do BolaDao, Quando chamar a adicao de bolas do repositorio`(): Unit =
        runBlocking {
            repositorio.adicionarBola(bolaMockada)
            coVerify {
                bolaDao.adicionarBola(bolaMockada)
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
            } returns bolaMockada
            repositorio.encontrarBolaPeloId("").firstOrNull()
            coVerify {
                bolaDao.encontrarBolaPeloId("")
            }
        }

    @Test
    fun `Deve chamar Marca do MarcaDao, Quando chamar Marcas pelo Id do repositorio`(): Unit =
        runBlocking {
            coEvery {
                marcaDao.encontrarMarcaPeloId("")
            } returns marcaMockada
            repositorio.encontrarMarcaPeloId("").firstOrNull()
            coVerify {
                marcaDao.encontrarMarcaPeloId("")
            }
        }

    @Test
    fun `Deve chamar encontrarBolaPeloId e DeletarBola do BolaDao, Quando chamar deletar Bola do repositorio`(): Unit =
        runBlocking {
            coEvery {
                bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
            } returns bolaMockadaCompleta
            repositorio.deletaBola("c6fec989-5440-49b5-8b03-8236556f46ab")
            coVerifySequence {
                bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
                bolaDao.deletaBola(any())
            }
        }

    @Test
    fun `Deve chamar encontrarBolaPeloId, Adicionar Bola e DeletarBola do BolaDao, Quando chamar editar Bola do repositorio`(): Unit =
        runBlocking {
            coEvery {
                bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
            } returns bolaMockadaCompleta
            repositorio.editaBola(bolaMockadaCompleta)
            coVerifySequence {
                bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
                bolaDao.deletaBola(any())
                bolaDao.adicionarBola(any())
            }
        }
}