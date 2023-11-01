package br.com.alura.mundobola.aplicacao.dao

import br.com.alura.mundobola.auxiliarTeste.idNike
import br.com.alura.mundobola.auxiliarTeste.marcaCompletaParaTestes
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeNull
import org.junit.Test

class MarcaDaoTest {
    private val marcaDao = MarcaDao()

    @Test
    fun `Deve retornar lista, quando chamamos a função lista de Marcas`(): Unit = runBlocking {
        val listaDeProdutos = marcaDao.listaDeMarcas().firstOrNull()
        listaDeProdutos?.size.shouldBeEqualTo(3)
        listaDeProdutos?.joinToString { marca ->
            marca.nome
        }.shouldBeEqualTo("Adidas, Nike, Penalty")
    }
    @Test
    fun `Deve retornar uma marca, Quando chamarmos a função de encontrar por id valido`(): Unit = runBlocking{
        val marcaEncontrada = marcaDao.encontrarMarcaPeloId(idNike)
        marcaEncontrada?.nome.shouldBeEqualTo("Nike")
    }
    @Test
    fun `Deve retornar null, Quando chamarmos a função de encontrar por id inválido`(): Unit = runBlocking{
        val marcaEncontrada = marcaDao.encontrarMarcaPeloId("fcvdsfdsfsdfsd")
        marcaEncontrada.shouldBeNull()
    }
    @Test
    fun `Deve não alterar a lista, Quando inserirmos uma marca nova`(): Unit = runBlocking{
        val listaDeProdutos = marcaDao.listaDeMarcas().firstOrNull()
        val tamanhoLista = listaDeProdutos?.size
        tamanhoLista.shouldBeEqualTo(3)
        listaDeProdutos?.let {
            it + marcaCompletaParaTestes
        }
        tamanhoLista.shouldBeEqualTo(3)
        val novaLista = listaDeProdutos?.let {
            it + marcaCompletaParaTestes
        }
        novaLista?.size.shouldBeEqualTo(4)
    }

}