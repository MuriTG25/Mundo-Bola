package br.com.alura.mundobola.aplicacao.modelo.entity

import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import br.com.alura.mundobola.auxiliarTeste.idMarcaTeste
import br.com.alura.mundobola.auxiliarTeste.imagemMarcaTeste
import br.com.alura.mundobola.auxiliarTeste.marcaEntityCompletaParaTestes
import br.com.alura.mundobola.auxiliarTeste.marcaEntitySimpleParaTestes
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
    @Test
    fun `deve Retornar Marca, ao converter MarcaEntity com o toMarca()`(){
        marcaEntitySimpleParaTestes.shouldBeInstanceOf<MarcaEntity>()
        marcaSimplesConvertida.shouldBeInstanceOf<Marca>()
    }
    @Test
    fun `deve manter marcaId em String, ao converter MarcaEntity com o toMarca()`(){
        marcaEntitySimpleParaTestes.marcaId.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.marcaId.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.marcaId.shouldBeEqualTo(idMarcaTeste)
    }
    @Test
    fun `deve manter nome em String, ao converter MarcaEntity com o toMarca()`(){
        marcaEntitySimpleParaTestes.nome.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.nome.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.nome.shouldBeEqualTo(nomeMarcaTeste)
    }
    @Test
    fun `deve manter imagem em String ou Null, ao converter MarcaEntity com o toMarca()`(){
        marcaEntityCompletaParaTestes.imagem.shouldBeInstanceOf<String>()
        marcaCompletaConvertida.imagem.shouldBeInstanceOf<String>()
        marcaSimplesConvertida.imagem.shouldBeNull()
        marcaCompletaConvertida.imagem.shouldBeEqualTo(imagemMarcaTeste)
    }
    @Test
    fun `deve manter dataCraicao em LocalDateTime, ao converter MarcaEntity com o toMarca()`() {
        marcaEntityCompletaParaTestes.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaCompletaConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaSimplesConvertida.dataCriacao.shouldBeInstanceOf<LocalDateTime>()
        marcaCompletaConvertida.dataCriacao.shouldBeEqualTo(dataParaTestes)
        marcaSimplesConvertida.dataCriacao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
    @Test
    fun `deve manter dataAlteracao em LocalDateTime ou Null, ao converter MarcaEntity com o toMarca()`() {
        marcaEntityCompletaParaTestes.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        marcaCompletaConvertida.dataAlteracao.shouldBeInstanceOf<LocalDateTime>()
        marcaSimplesConvertida.dataAlteracao.shouldBeNull()
        marcaCompletaConvertida.dataAlteracao.shouldBeEqualTo(dataParaTestes)
    }


}