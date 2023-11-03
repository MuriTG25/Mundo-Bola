package br.com.alura.mundobola.ui.viewmodel

import br.com.alura.mundobola.aplicacao.dao.BolaDao
import br.com.alura.mundobola.aplicacao.dao.MarcaDao
import br.com.alura.mundobola.aplicacao.repositorio.MundoBolaRepositorio
import br.com.alura.mundobola.dominio.Bola
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ScaffoldViewModelTest{
    private val bolaDao = mockk<BolaDao>()
    private val marcaDao = mockk<MarcaDao>()
    private val repositorio by lazy {
        MundoBolaRepositorio(bolaDao, marcaDao)
    }
    private val viewModel by lazy{
        ScaffoldViewModel(repositorio)
    }
    @Test
    fun `Deve chamar delete bola e editar bola do bola Dao, Quando chamar o delete Bola do View Model`(): Unit
        = runBlocking{
        coEvery {
            bolaDao.deletaBola(any())
        } returns Unit
        coEvery {
            bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
        } returns mockkClass(Bola::class)
        viewModel.deletaUsuario("c6fec989-5440-49b5-8b03-8236556f46ab")
        coVerifySequence {
            bolaDao.encontrarBolaPeloId("c6fec989-5440-49b5-8b03-8236556f46ab")
            bolaDao.deletaBola(any())
        }
    }
}