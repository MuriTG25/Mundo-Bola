package br.com.alura.mundobola.dominio

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import java.time.LocalDate

class BolaTest{
    private val bolaMinima = Bola(
        nome = "Jabulani",
        preco = "19.99".toBigDecimal()
    )
    @Test
    fun `Deve retornar UUID, Quando criamos uma bola sem inserir o ID`(){
        bolaMinima.bolaId.length.shouldBeEqualTo(36)
    }
    @Test
    fun `Deve retornar o horário atual, Quando criarmos uma bola sem inserir data de criação`(){
        bolaMinima.dataCriacao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
}