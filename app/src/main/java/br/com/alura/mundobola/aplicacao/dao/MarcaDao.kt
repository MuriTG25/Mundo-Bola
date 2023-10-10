package br.com.alura.mundobola.aplicacao.dao

import br.com.alura.mundobola.dominio.Marca
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime

class MarcaDao() {
    companion object{
        private val listaDeMarcas = mutableListOf<Marca>(
            Marca(
                "4946112a-b895-4c8f-b5c1-1c8dc0b65dee",
                "Adidas",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png",
                LocalDateTime.now()
            ),
            Marca(
                "849324c0-2d2d-4097-87f4-68dae63b2f5b",
                "Nike",
                "https://logospng.org/wp-content/uploads/nike.jpg",
                LocalDateTime.now()
            ),
            Marca(
                "8bc9a223-3a8f-4523-aba8-dc1d9811523b",
                "Penalty",
                "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png",
                LocalDateTime.now()
            )
        )
        private val listaDeMarcasStateFlow = MutableStateFlow<List<Marca>>(listaDeMarcas)
    }
    suspend fun listaDeMarcas() = listaDeMarcasStateFlow.asStateFlow()
    suspend fun encontrarMarcaPeloId(id: String):Marca?{
        return listaDeMarcas.firstOrNull{
            it.marcaId == id
        }
    }
}