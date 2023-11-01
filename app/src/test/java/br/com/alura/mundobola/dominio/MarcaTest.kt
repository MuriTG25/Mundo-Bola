package br.com.alura.mundobola.dominio

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import java.time.LocalDate

class MarcaTest{
    private val marcaMinima = Marca(
        nome = "Jabulani"
    )
    @Test
    fun `Deve retornar UUID, Quando criamos uma bola sem inserir o ID`(){
        marcaMinima.marcaId.length.shouldBeEqualTo(36)
    }
    @Test
    fun `Deve retornar o horário atual, Quando criarmos uma bola sem inserir data de criação`(){
        marcaMinima.dataCriacao.toLocalDate().shouldBeEqualTo(LocalDate.now())
    }
}