package br.com.alura.mundobola.aplicacao.extra.funcoesextras


import br.com.alura.mundobola.aplicacao.extra.paraBigDecimal
import org.junit.Test
import java.math.BigDecimal
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull


class FunctionParaBigDecimalKtTest{
    @Test
    fun `Deve retornar Big Decimal, Quando convertemos a string`(){
        val stringConvertida = "19.90".paraBigDecimal()
        stringConvertida.shouldBeInstanceOf(BigDecimal::class.java)
    }
    @Test
    fun `Deve transformar virgula em ponto e converter em Big Decimal, Quando convertemos a string`(){
        val stringConvertida = "19,90".paraBigDecimal()
        stringConvertida.shouldBeInstanceOf(BigDecimal::class.java)
        stringConvertida.shouldBeEqualTo(BigDecimal("19.90"))
    }
    @Test
    fun `Deve ignorar - e retornar BigDecimal , Quando convertemos a string`(){
        val stringConvertida = "-19,90".paraBigDecimal()
        stringConvertida.shouldBeInstanceOf(BigDecimal::class.java)
        stringConvertida.shouldBeEqualTo(BigDecimal("19.90"))
    }
    @Test
    fun `Deve retornar null, Quando convertemos a string com mais de 1 ponto ou ponto`(){
        val stringCom2Virgulas = "1,9,90".paraBigDecimal()
        stringCom2Virgulas.shouldBeNull()
        val stringCom2Pontos = "1.9.90".paraBigDecimal()
        stringCom2Pontos.shouldBeNull()
        val stringComVirgulaEPonto = "1.9,90".paraBigDecimal()
        stringComVirgulaEPonto.shouldBeNull()
    }
    @Test
    fun `Deve retornar null, Quando inserirmos outros valores na String`(){
        val stringComLetras = "teste".paraBigDecimal()
        stringComLetras.shouldBeNull()
        val stringComBarra = "20/04".paraBigDecimal()
        stringComBarra.shouldBeNull()
        val stringComOutrosSimbolos = "1?9>90<".paraBigDecimal()
        stringComOutrosSimbolos.shouldBeNull()
    }
    @Test
    fun `Deve arrendondar para cima, Quando convertemos a string com mais de 2 casas decimais com valor acima de 5`(){
        val stringConvertida = "19.947".paraBigDecimal()
        stringConvertida.shouldBeEqualTo(BigDecimal("19.95"))
    }
    @Test
    fun `Deve arrendondar para baixo, Quando convertemos a string com mais de 2 casas decimais com valor abaixo de 5`(){
        val stringConvertida = "19.943".paraBigDecimal()
        stringConvertida.shouldBeEqualTo(BigDecimal("19.94"))
    }
    @Test
    fun `Deve arrendondar para cima, Quando convertemos a string com mais de 2 casas decimais com valor de 5`(){
        val stringConvertida = "19.945".paraBigDecimal()
        stringConvertida.shouldBeEqualTo(BigDecimal("19.95"))
    }

}