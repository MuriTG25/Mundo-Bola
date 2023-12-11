package br.com.alura.mundobola.aplicacao.modelo.entity

import br.com.alura.mundobola.auxiliarTeste.bolaEntityDeTesteCompleta
import br.com.alura.mundobola.auxiliarTeste.bolaEntityDeTesteSimples
import br.com.alura.mundobola.dominio.Bola
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Assert.*
import org.junit.Test

class BolaEntityTest{
    private val bolaSimplesConvertida = bolaEntityDeTesteSimples.toBola()
    private val bolaCompletaConvertida = bolaEntityDeTesteCompleta.toBola()
    @Test
    fun `Deve converter em Bola, Quando utilizarmos o toBola() em uma BolaEntity`(){
        bolaEntityDeTesteSimples.shouldBeInstanceOf<BolaEntity>()
        bolaSimplesConvertida.shouldBeInstanceOf<Bola>()
    }
}