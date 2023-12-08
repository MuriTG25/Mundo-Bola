package br.com.alura.mundobola.aplicacao.repositorio

import br.com.alura.mundobola.aplicacao.dao.BolaDao
import br.com.alura.mundobola.aplicacao.dao.MarcaDao
import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteCompleta
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MundoBolaRepositorioTest {
    @MockK
    private val bolaDao = mockk<BolaDao>()
    @MockK
    private val marcaDao = mockk<MarcaDao>()
    private val repositorio by lazy {
        MundoBolaRepositorio(bolaDao, marcaDao)
    }
    @Before
    fun setUp(){
        MockKAnnotations.init(this)
    }

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
            coEvery {
                bolaDao.adicionarBola(bolaDeTesteCompleta)
            } returns (Unit)
            repositorio.adicionarBola(bolaDeTesteCompleta)
            coVerify {
                bolaDao.adicionarBola(bolaDeTesteCompleta)
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
            } returns mockkClass(Bola::class)
            repositorio.encontrarBolaPeloId("")?.firstOrNull()
            coVerify {
                bolaDao.encontrarBolaPeloId("")
            }
        }

    @Test
    fun `Deve chamar Marca do MarcaDao, Quando chamar Marcas pelo Id do repositorio`(): Unit =
        runBlocking {
            coEvery {
                marcaDao.encontrarMarcaPeloId("")
            } returns mockkClass(Marca::class)
            repositorio.encontrarMarcaPeloId("")?.firstOrNull()
            coVerify {
                marcaDao.encontrarMarcaPeloId("")
            }
        }

    @Test
    fun `Deve chamar encontrarBolaPeloId e DeletarBola do BolaDao, Quando chamar deletar Bola do repositorio`(): Unit =
        runBlocking {
            coEvery {
                bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
            } returns mockkClass(Bola::class)
            coEvery {
                bolaDao.deletaBola(any())
            } returns Unit
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
            } returns mockkClass(Bola::class)
            coEvery {
                bolaDao.deletaBola(any())
            } returns Unit
            coEvery {
                bolaDao.adicionarBola(any())
            } returns Unit
            repositorio.editaBola(bolaDeTesteCompleta)
            coVerifySequence {
                bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
                bolaDao.deletaBola(any())
                bolaDao.adicionarBola(any())
            }
        }
}