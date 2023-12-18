package br.com.alura.mundobola.aplicacao.modelo.entity

import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteCompleta
import br.com.alura.mundobola.auxiliarTeste.bolaDeTesteSimples
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

    private val bolaEntitySimplesConvertida = bolaDeTesteSimples.toBolaEntity()
    private val bolaEntityCompletaConvertida = bolaDeTesteCompleta.toBolaEntity()
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
    fun `Deve manter a dataDeAlteracao como LocalDateTime ou Null, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteCompleta.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaCompletaConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaSimplesConvertida.dataAlteracao.shouldBeNull()
        bolaCompletaConvertida.dataAlteracao.shouldBeEqualTo(dataParaTestes)
    }
    //Teste do toBolaEntity
    @Test
    fun `Deve converter em BolaEntity, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteSimples.shouldBeInstanceOf<Bola>()
        bolaEntitySimplesConvertida.shouldBeInstanceOf<BolaEntity>()
    }
    @Test
    fun `Deve manter o id como String, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.bolaId.shouldBeInstanceOf<String>()
        bolaEntityCompletaConvertida.bolaId.shouldBeInstanceOf<String>()
        bolaEntityCompletaConvertida.bolaId.shouldBeEqualTo(bolaIdTeste)
    }
    @Test
    fun `Deve manter o nome como String, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.nome.shouldBeInstanceOf<String>()
        bolaEntityCompletaConvertida.nome.shouldBeInstanceOf<String>()
        bolaEntityCompletaConvertida.nome.shouldBeEqualTo(nomeBolaTeste)
    }
    @Test
    fun `Deve manter o preco como BigDecimal, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.preco.shouldBeInstanceOf<BigDecimal>()
        bolaEntityCompletaConvertida.preco.shouldBeInstanceOf<BigDecimal>()
        bolaEntityCompletaConvertida.preco.shouldBeEqualTo(precoBolaTeste)
    }
    @Test
    fun `Deve manter a marcaID como String ou Null, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.marcaId.shouldBeInstanceOf<String>()
        bolaEntityCompletaConvertida.marcaId.shouldBeInstanceOf<String>()
        bolaEntitySimplesConvertida.marcaId.shouldBeNull()
        bolaEntityCompletaConvertida.marcaId.shouldBeEqualTo(idNike)
    }
    @Test
    fun `Deve manter a descricao como String ou Null, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.descricao.shouldBeInstanceOf<String>()
        bolaEntityCompletaConvertida.descricao.shouldBeInstanceOf<String>()
        bolaEntitySimplesConvertida.descricao.shouldBeNull()
        bolaEntityCompletaConvertida.descricao.shouldBeEqualTo(descricaoBolaTeste)
    }
    @Test
    fun `Deve manter a imagem como String ou Null, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.imagem.shouldBeInstanceOf<String>()
        bolaEntityCompletaConvertida.imagem.shouldBeInstanceOf<String>()
        bolaEntitySimplesConvertida.imagem.shouldBeNull()
        bolaEntityCompletaConvertida.imagem.shouldBeEqualTo(imagemBolaTeste)
    }
    @Test
    fun `Deve manter a dataDeCriacao como LocalDateTime, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        bolaEntityCompletaConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        bolaEntitySimplesConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        bolaEntityCompletaConvertida.dataCriacao.shouldBeEqualTo(dataParaTestes)
        bolaEntitySimplesConvertida.dataCriacao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
    @Test
    fun `Deve manter a dataDeCriacao como LocalDateTime ou Null, Quando utilizarmos o toBolaEntity() em uma Bola`(){
        bolaDeTesteCompleta.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaEntityCompletaConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        bolaEntitySimplesConvertida.dataAlteracao.shouldBeNull()
        bolaEntityCompletaConvertida.dataAlteracao.shouldBeEqualTo(dataParaTestes)
    }
}