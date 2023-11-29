package br.com.alura.mundobola.aplicacao.modelo.view

import br.com.alura.mundobola.aplicacao.modelo.dto.BolaDTO
import br.com.alura.mundobola.aplicacao.modelo.dto.paraBolaDTO
import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteCompleta
import br.com.alura.mundobola.auxiliarTeste.BolaDeTesteSimples
import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test

class BolaDTOTest{
    private val bolaSimplesConvertida = BolaDeTesteSimples.paraBolaDTO()
    private val bolaCompletaConvertida = bolaDeTesteCompleta.paraBolaDTO()
    @Test
    fun `Deve retornar BolaView, Quando buscarmos a classe do objeto`(){
        bolaSimplesConvertida.shouldBeInstanceOf(BolaDTO::class)
    }
    @Test
    fun`Deve retornar preco Convertido em String, Quando convertemos Bola Em BolaView`(){
        val precoBola = bolaSimplesConvertida.preco
        precoBola.shouldBeInstanceOf(String::class)
        BolaDeTesteSimples.preco.shouldBeEqualTo("49.99".toBigDecimal())
        precoBola.shouldBeEqualTo("R\$ 49,99")
    }
    @Test
    fun `Deve retornar MarcaID, Quando Buscarmos bola com valor de MarcaID valido`(){
        bolaCompletaConvertida.marcaId.shouldBeEqualTo("849324c0-2d2d-4097-87f4-68dae63b2f5b")
    }
    @Test
    fun `Deve retornar String Vazia, Quando Buscarmos bola com valor de MarcaID nulo`(){
        BolaDeTesteSimples.marcaId.shouldBeNull()
        bolaSimplesConvertida.marcaId.shouldBeEqualTo("")
    }
    @Test
    fun `Deve retornar a Descricao, Quando buscarmos a descricao da bola`(){
        bolaCompletaConvertida.descricao.shouldBeEqualTo(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sodales\n" +
                    "laoreet"
        )
    }
    @Test
    fun `Deve retornar String Vazia, Quando buscarmos bola com a Descricao nula`(){
        BolaDeTesteSimples.descricao.shouldBeNull()
        bolaSimplesConvertida.descricao.shouldBeEqualTo("")
    }
    @Test
    fun `Deve retornar a Url da Imagem, Quando buscarmos a imagem da bola`(){
        bolaCompletaConvertida.imagem.shouldBeEqualTo(
            "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg"
        )
    }
    @Test
    fun `Deve retornar String Vazia, Quando buscarmos a imagem da bola nula`(){
        BolaDeTesteSimples.imagem.shouldBeNull()
        bolaSimplesConvertida.imagem.shouldBeEqualTo("")
    }
    @Test
    fun`Deve retornar Data de Criacao Convertido em String, Quando convertemos Bola Em BolaView`(){
        val dataCriacao = bolaCompletaConvertida.dataCriacao
        dataCriacao.shouldBeInstanceOf(String::class)
        bolaDeTesteCompleta.dataCriacao.shouldBeEqualTo(dataParaTestes)
        dataCriacao.shouldBeEqualTo("14/08/2022")
    }
    @Test
    fun`Deve retornar Data de Alteracao Convertido em String, Quando convertemos Bola Em BolaView`(){
        val dataAlteracao = bolaCompletaConvertida.dataAlteracao
        dataAlteracao.shouldBeInstanceOf(String::class)
        bolaDeTesteCompleta.dataAlteracao.shouldBeEqualTo(dataParaTestes)
        dataAlteracao.shouldBeEqualTo("14/08/2022")
    }
    @Test
    fun `Deve retornar String Vazia, Quando buscarmos a data de alteracao da bola nula`(){
        BolaDeTesteSimples.dataAlteracao.shouldBeNull()
        bolaSimplesConvertida.dataAlteracao.shouldBeEqualTo("")
    }
}