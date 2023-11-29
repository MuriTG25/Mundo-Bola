package br.com.alura.mundobola.aplicacao.modelo.view

import br.com.alura.mundobola.aplicacao.modelo.dto.MarcaDTO
import br.com.alura.mundobola.aplicacao.modelo.dto.paraMarcaDTO
import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import br.com.alura.mundobola.auxiliarTeste.marcaCompletaParaTestes
import br.com.alura.mundobola.auxiliarTeste.marcaSimpleParaTestes
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test

class MarcaDTOTest{
    private val marcaSimplesConvertida = marcaSimpleParaTestes.paraMarcaDTO()
    val marcaCompletaConvertida = marcaCompletaParaTestes.paraMarcaDTO()
    @Test
    fun `Deve retornar MarcaView, Quando buscarmos a classe do objeto`(){
        marcaSimplesConvertida.shouldBeInstanceOf(MarcaDTO::class)
    }
    @Test
    fun `Deve retornar a Url da Imagem, Quando buscarmos a imagem da marca`(){
        marcaCompletaConvertida.imagem.shouldBeEqualTo(
            "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png"
        )
    }
    @Test
    fun `Deve retornar String Vazia, Quando buscarmos a imagem da marca nula`(){
        marcaSimpleParaTestes.imagem.shouldBeNull()
        marcaSimplesConvertida.imagem.shouldBeEqualTo("")
    }
    @Test
    fun`Deve retornar Data de Criacao Convertido em String, Quando convertemos para MarcaView`(){
        val dataCriacao = marcaCompletaConvertida.dataCriacao
        dataCriacao.shouldBeInstanceOf(String::class)
        marcaCompletaParaTestes.dataCriacao.shouldBeEqualTo(dataParaTestes)
        dataCriacao.shouldBeEqualTo("14/08/2022")
    }
    @Test
    fun`Deve retornar Data de Alteracao Convertido em String, Quando convertemos para MarcaView`(){
        val dataAlteracao = marcaCompletaConvertida.dataAlteracao
        dataAlteracao.shouldBeInstanceOf(String::class)
        marcaCompletaParaTestes.dataAlteracao.shouldBeEqualTo(dataParaTestes)
        dataAlteracao.shouldBeEqualTo("14/08/2022")
    }
    @Test
    fun `Deve retornar String Vazia, Quando buscarmos a data de alteracao da bola nula`(){
        marcaSimpleParaTestes.dataAlteracao.shouldBeNull()
        marcaSimplesConvertida.dataAlteracao.shouldBeEqualTo("")
    }
}