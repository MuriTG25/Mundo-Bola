package br.com.alura.mundobola.aplicacao.modelo.entity

import br.com.alura.mundobola.auxiliarTeste.bolaEntityDeTesteCompleta
import br.com.alura.mundobola.auxiliarTeste.bolaEntityDeTesteSimples
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

class BolaEntityTest{
    private val bolaSimplesConvertida = bolaEntityDeTesteSimples.toBola()
    private val bolaCompletaConvertida = bolaEntityDeTesteCompleta.toBola()
    @Test
    fun `Deve converter em Bola, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteSimples.shouldBeInstanceOf<BolaEntity>()
        bolaSimplesConvertida.shouldBeInstanceOf<Bola>()
    }
    @Test
    fun `Deve manter o id como String, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.bolaId.shouldBeInstanceOf<String>()
        bolaCompletaConvertida.bolaId.shouldBeInstanceOf<String>()
        bolaCompletaConvertida.bolaId.shouldBeEqualTo(bolaIdTeste)
    }
    @Test
    fun `Deve manter o nome como String, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.nome.shouldBeInstanceOf<String>()
        bolaCompletaConvertida.nome.shouldBeInstanceOf<String>()
        bolaCompletaConvertida.nome.shouldBeEqualTo(nomeBolaTeste)
    }
    @Test
    fun `Deve manter o preco como BigDecimal, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.preco.shouldBeInstanceOf<BigDecimal>()
        bolaCompletaConvertida.preco.shouldBeInstanceOf<BigDecimal>()
        bolaCompletaConvertida.preco.shouldBeEqualTo(precoBolaTeste)
    }
    @Test
    fun `Deve manter a marcaID como String ou Null, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.marcaId.shouldBeInstanceOf<String>()
        bolaCompletaConvertida.marcaId.shouldBeInstanceOf<String>()
        bolaSimplesConvertida.marcaId.shouldBeNull()
        bolaCompletaConvertida.marcaId.shouldBeEqualTo(idNike)
    }
    @Test
    fun `Deve manter a descricao como String ou Null, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.descricao.shouldBeInstanceOf<String>()
        bolaCompletaConvertida.descricao.shouldBeInstanceOf<String>()
        bolaSimplesConvertida.descricao.shouldBeNull()
        bolaCompletaConvertida.descricao.shouldBeEqualTo(descricaoBolaTeste)
    }
    @Test
    fun `Deve manter a imagem como String ou Null, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.imagem.shouldBeInstanceOf<String>()
        bolaCompletaConvertida.imagem.shouldBeInstanceOf<String>()
        bolaSimplesConvertida.imagem.shouldBeNull()
        bolaCompletaConvertida.imagem.shouldBeEqualTo(imagemBolaTeste)
    }
    @Test
    fun `Deve manter a dataDeCriacao como LocalDateTime, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        bolaCompletaConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        bolaSimplesConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        bolaCompletaConvertida.dataCriacao.shouldBeEqualTo(dataParaTestes)
        bolaSimplesConvertida.dataCriacao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
    @Test
    fun `Deve manter a dataDeCriacao como LocalDateTime ou Null, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaCompletaConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaSimplesConvertida.dataAlteracao.shouldBeNull()
        bolaCompletaConvertida.dataAlteracao.shouldBeEqualTo(dataParaTestes)
    }
}