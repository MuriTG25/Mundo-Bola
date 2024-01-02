package br.com.alura.mundobola.aplicacao.modelo.entity

import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import br.com.alura.mundobola.auxiliarTeste.idMarcaTeste
import br.com.alura.mundobola.auxiliarTeste.imagemMarcaTeste
import br.com.alura.mundobola.auxiliarTeste.marcaCompletaParaTestes
import br.com.alura.mundobola.auxiliarTeste.marcaEntityCompletaParaTestes
import br.com.alura.mundobola.auxiliarTeste.marcaEntitySimpleParaTestes
import br.com.alura.mundobola.auxiliarTeste.marcaSimpleParaTestes
import br.com.alura.mundobola.auxiliarTeste.nomeMarcaTeste
import br.com.alura.mundobola.dominio.Marca
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

class MarcaEntityTest{
    private val marcaSimplesConvertida = marcaEntitySimpleParaTestes.toMarca()
    private val marcaCompletaConvertida = marcaEntityCompletaParaTestes.toMarca()

    private val marcaEntitySimplesConvertida = marcaSimpleParaTestes.toMarcaEntity()
    private val marcaEntityCompletaConvertida = marcaCompletaParaTestes.toMarcaEntity()
    @Test
    fun `deve Retornar Marca, ao converter MarcaEntity com o toMarca`(){
        marcaEntitySimpleParaTestes.shouldBeInstanceOf<MarcaEntity>()
        marcaSimplesConvertida.shouldBeInstanceOf<Marca>()
    }
    @Test
    fun `deve manter marcaId em String, ao converter MarcaEntity com o toMarca`(){
        marcaEntitySimpleParaTestes.marcaId.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.marcaId.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.marcaId.shouldBeEqualTo(idMarcaTeste)
    }
    @Test
    fun `deve manter nome em String, ao converter MarcaEntity com o toMarca`(){
        marcaEntitySimpleParaTestes.nome.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.nome.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.nome.shouldBeEqualTo(nomeMarcaTeste)
    }
    @Test
    fun `deve manter imagem em String ou Null, ao converter MarcaEntity com o toMarca`(){
        marcaEntityCompletaParaTestes.imagem.shouldBeInstanceOf<String>()
        marcaCompletaConvertida.imagem.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.imagem.shouldBeNull()
        marcaCompletaConvertida.imagem.shouldBeEqualTo(imagemMarcaTeste)
    }
    @Test
    fun `deve manter dataCriacao em LocalDateTime, ao converter MarcaEntity com o toMarca`() {
        marcaEntityCompletaParaTestes.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaCompletaConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaSimplesConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaCompletaConvertida.dataCriacao.shouldBeEqualTo(dataParaTestes)
        marcaSimplesConvertida.dataCriacao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
    @Test
    fun `deve manter dataAlteracao em LocalDateTime ou Null, ao converter MarcaEntity com o toMarca`() {
        marcaEntityCompletaParaTestes.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        marcaCompletaConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        marcaSimplesConvertida.dataAlteracao.shouldBeNull()
        marcaCompletaConvertida.dataAlteracao.shouldBeEqualTo(dataParaTestes)
    }
    @Test
    fun `deve Retornar MarcaEntity, ao converter Marca com o toMarcaEntity`(){
        marcaSimpleParaTestes.shouldBeInstanceOf<Marca>()
        marcaEntitySimplesConvertida.shouldBeInstanceOf<MarcaEntity>()
    }
    @Test
    fun `deve manter marcaId em String, ao converter Marca com o toMarcaEntity`(){
        marcaSimpleParaTestes.marcaId.shouldBeInstanceOf<String>()
        marcaEntitySimplesConvertida.marcaId.shouldBeInstanceOf<String>()
        marcaEntitySimplesConvertida.marcaId.shouldBeEqualTo(idMarcaTeste)
    }
    @Test
    fun `deve manter nome em String, ao converter Marca com o toMarcaEntity`(){
        marcaSimpleParaTestes.nome.shouldBeInstanceOf<String>()
        marcaEntitySimplesConvertida.nome.shouldBeInstanceOf<String>()
        marcaEntitySimplesConvertida.nome.shouldBeEqualTo(nomeMarcaTeste)
    }
    @Test
    fun `deve manter imagem em String ou Null, ao converter Marca com o toMarcaEntity`(){
        marcaCompletaParaTestes.imagem.shouldBeInstanceOf<String>()
        marcaEntityCompletaConvertida.imagem.shouldBeInstanceOf<String>()
        marcaEntitySimplesConvertida.imagem.shouldBeNull()
        marcaEntityCompletaConvertida.imagem.shouldBeEqualTo(imagemMarcaTeste)
    }
    @Test
    fun `deve manter dataCriacao em LocalDateTime, ao converter Marca com o toMarcaEntity`() {
        marcaCompletaParaTestes.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaEntityCompletaConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaEntitySimplesConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaEntityCompletaConvertida.dataCriacao.shouldBeEqualTo(dataParaTestes)
        marcaEntitySimplesConvertida.dataCriacao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
    @Test
    fun `deve manter dataAlteracao em LocalDateTime ou Null, ao converter Marca com o toMarcaEntity`() {
        marcaCompletaParaTestes.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        marcaEntityCompletaConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        marcaEntitySimplesConvertida.dataAlteracao.shouldBeNull()
        marcaEntityCompletaConvertida.dataAlteracao.shouldBeEqualTo(dataParaTestes)
    }
}