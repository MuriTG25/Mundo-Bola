package br.com.alura.mundobola.ui.extra

import br.com.alura.mundobola.dominio.Marca
import java.time.LocalDateTime

val amostraDeListaDeMarcas = listOf<Marca>(
    Marca(
        "1",
        "Adidas",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png",
        LocalDateTime.now()
    ),
    Marca(
        "2",
        "Nike",
        "https://logospng.org/wp-content/uploads/nike.jpg",
        LocalDateTime.now()
    ),
    Marca(
        "3",
        "Penalty",
        "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png",
        LocalDateTime.now()
    )
)
