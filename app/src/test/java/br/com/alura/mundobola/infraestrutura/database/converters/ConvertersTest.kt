package br.com.alura.mundobola.infraestrutura.database.converters

import br.com.alura.mundobola.auxiliarTeste.dataParaTestes
import br.com.alura.mundobola.auxiliarTeste.precoBolaTeste
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test
import java.math.BigDecimal
import java.time.LocalDateTime

class ConvertersTest{
    private val converter = Converters()
    private val dataEmString = "2022-08-14T10:40"
    private val dataInvalidaEmOutroFormato = "2022-08-14 10:40"
    private val precoBolaEmDouble: Double = 49.99
    @Test
    fun `deve converter em String, quando utilizar o converter em LocalDateTime`(){
        val dataConvertida = converter.deLocalDateTimeParaString(dataParaTestes)
        dataConvertida.shouldBeInstanceOf<String>()
        dataConvertida.shouldBeEqualTo(dataEmString)
    }
    @Test
    fun `deve converter de volta para LocalDateTime, quando inserirmos um string que era LocalDateTime`(){
        val dataConvertida =converter.deStringParaLocalDateTime(dataEmString)
        dataConvertida.shouldBeInstanceOf<LocalDateTime>()
        dataConvertida.shouldBeEqualTo(dataParaTestes)
    }
    @Test
    fun `deve manter null, quando utilizar o deLocalDateTimeParaString em valor null`(){
        converter.deLocalDateTimeParaString(null).
        shouldBeNull()
    }
    @Test
    fun `deve manter null, quando utilizar o deLocalDateTimeParaString em valor de String vazia`(){
        converter.deStringParaLocalDateTime("").
            shouldBeNull()
    }
    @Test
    fun `deve manter null, quando utilizar o deLocalDateTimeParaString em valor em String Invalida`(){
        converter.deStringParaLocalDateTime(dataInvalidaEmOutroFormato).
            shouldBeNull()
    }
    @Test
    fun `deve manter null, quando utilizar o deStringParaLocalDateTime em valor null`(){
        converter.deStringParaLocalDateTime(null)
            .shouldBeNull()
    }
    @Test
    fun `deve voltar a data original, ao converter em String e depois converter de volta`(){
        val dataConvertida1 = converter.deLocalDateTimeParaString(dataParaTestes)
        val dataConvertida2 = converter.deStringParaLocalDateTime(dataConvertida1)
        dataConvertida2.shouldBeInstanceOf<LocalDateTime>()
        dataConvertida2.shouldBeEqualTo(dataParaTestes)
    }
    @Test
    fun `deve converter em Double, quando utilizar o converter em BigDecimal`(){
        val precoConvertido = converter.deBigDecimalParaDouble(precoBolaTeste)
        precoConvertido.shouldBeInstanceOf<Double>()
        precoConvertido.shouldBeEqualTo(precoBolaEmDouble)
    }
    @Test
    fun `deve converter em BigDecimal, quando utilizar o converter em Double`() {
        val precoConvertido = converter.deDoubleParaBigDecimal(precoBolaEmDouble)
        precoConvertido.shouldBeInstanceOf<BigDecimal>()
        precoConvertido.shouldBeEqualTo(precoBolaTeste)
    }
    @Test
    fun `deve voltar ao preco original, ao converter em Double e depois converter de volta`(){
        val precoConvertido1 = converter.deBigDecimalParaDouble(precoBolaTeste)
        val precoConvertido2 = converter.deDoubleParaBigDecimal(precoConvertido1)
        precoConvertido2.shouldBeInstanceOf<BigDecimal>()
        precoConvertido2.shouldBeEqualTo(precoBolaTeste)
    }
}