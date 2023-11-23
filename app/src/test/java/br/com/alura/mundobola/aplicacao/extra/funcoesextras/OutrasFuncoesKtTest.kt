package br.com.alura.mundobola.aplicacao.extra.funcoesextras

import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.aplicacao.extra.estaVazio
import br.com.alura.mundobola.aplicacao.extra.paraMoedaBrasileira
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldBeNull
import org.junit.Test
import java.time.LocalDateTime

class OutrasFuncoesKtTest {
    @Test
    fun `Deve retornar String com data formatada, quando convertemos LocalDateTime`(){
        val data = LocalDateTime.of(2020, 4, 30, 20, 30)
        val dataFormatada = data.dataFormatada()
        dataFormatada.shouldBeInstanceOf(String::class)
        dataFormatada.shouldBeEqualTo("30/04/2020")
    }
    @Test
    fun `Deve retornar String com valor de Real, quando convertemos BigDecimal`(){
        val valorConvertido = "19.90".toBigDecimal().paraMoedaBrasileira()
        valorConvertido.shouldBeInstanceOf(String::class)
        valorConvertido.shouldBeEqualTo("R\$ 19,90")
    }
    @Test
    fun `Deve retornar o mesmo valor, quando a String nao esta vazia`(){
        val stringNaoVazia = "a".estaVazio()
        stringNaoVazia.shouldBeEqualTo("a")
    }
    @Test
    fun `Deve retornar Null, quando a String estiver blank vazia`(){
        val stringEmpty = "".estaVazio()
        stringEmpty.shouldBeNull()
        val stringBlank = "       ".estaVazio()
        stringBlank.shouldBeNull()

    }


}