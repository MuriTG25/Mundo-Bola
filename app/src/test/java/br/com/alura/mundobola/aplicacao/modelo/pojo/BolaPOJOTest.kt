package br.com.alura.mundobola.aplicacao.modelo.pojo

import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteCompleta
import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteSimples
import br.com.alura.mundobola.auxiliarTeste.bolaIdTeste
import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import br.com.alura.mundobola.auxiliarTeste.descricaoBolaTeste
import br.com.alura.mundobola.auxiliarTeste.idNike
import br.com.alura.mundobola.auxiliarTeste.imagemBolaTeste
import br.com.alura.mundobola.auxiliarTeste.nomeBolaTeste
import br.com.alura.mundobola.auxiliarTeste.precoBolaTeste
import br.com.alura.mundobola.dominio.Bola
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

class BolaPOJOTest{
    private val bolaPOJOSimplesConvertida = bolaDeTesteSimples.toBolaPOJO()
    private val bolaPOJOCompletaConvertida = bolaDeTesteCompleta.toBolaPOJO()

    @Test
    fun `Deve converter em BolaPOJO, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteSimples.shouldBeInstanceOf<Bola>()
        bolaPOJOSimplesConvertida.shouldBeInstanceOf<BolaPOJO>()
    }
    @Test
    fun `Deve manter o id como String, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteCompleta.bolaId.shouldBeInstanceOf<String>()
        bolaPOJOCompletaConvertida.bolaId.shouldBeInstanceOf<String>()
        bolaPOJOCompletaConvertida.bolaId.shouldBeEqualTo(bolaIdTeste)
    }
    @Test
    fun `Deve manter o nome como String, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteCompleta.nome.shouldBeInstanceOf<String>()
        bolaPOJOCompletaConvertida.nome.shouldBeInstanceOf<String>()
        bolaPOJOCompletaConvertida.nome.shouldBeEqualTo(nomeBolaTeste)
    }
    @Test
    fun `Deve manter o preco como BigDecimal, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteCompleta.preco.shouldBeInstanceOf<BigDecimal>()
        bolaPOJOCompletaConvertida.preco.shouldBeInstanceOf<BigDecimal>()
        bolaPOJOCompletaConvertida.preco.shouldBeEqualTo(precoBolaTeste)
    }
    @Test
    fun `Deve manter a marcaID como String ou Null, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteCompleta.marcaId.shouldBeInstanceOf<String>()
        bolaPOJOCompletaConvertida.marcaId.shouldBeInstanceOf<String>()
        bolaPOJOSimplesConvertida.marcaId.shouldBeNull()
        bolaPOJOCompletaConvertida.marcaId.shouldBeEqualTo(idNike)
    }
    @Test
    fun `Deve manter a descricao como String ou Null, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteCompleta.descricao.shouldBeInstanceOf<String>()
        bolaPOJOCompletaConvertida.descricao.shouldBeInstanceOf<String>()
        bolaPOJOSimplesConvertida.descricao.shouldBeNull()
        bolaPOJOCompletaConvertida.descricao.shouldBeEqualTo(descricaoBolaTeste)
    }
    @Test
    fun `Deve manter a imagem como String ou Null, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteCompleta.imagem.shouldBeInstanceOf<String>()
        bolaPOJOCompletaConvertida.imagem.shouldBeInstanceOf<String>()
        bolaPOJOSimplesConvertida.imagem.shouldBeNull()
        bolaPOJOCompletaConvertida.imagem.shouldBeEqualTo(imagemBolaTeste)
    }
    @Test
    fun `Deve manter a dataDeAlteracao como LocalDateTime, Quando utilizarmos o toBolaPOJO() em uma Bola`(){
        bolaDeTesteCompleta.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaDeTesteSimples.dataAlteracao.shouldBeNull()
        bolaPOJOCompletaConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaPOJOSimplesConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaPOJOCompletaConvertida.dataAlteracao.shouldBeEqualTo(dataParaTestes)
        bolaPOJOSimplesConvertida.dataAlteracao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
}