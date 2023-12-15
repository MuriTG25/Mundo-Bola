package br.com.alura.mundobola.aplicacao.dao

import br.com.alura.mundobola.dominio.Marca
import java.time.LocalDateTime

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
