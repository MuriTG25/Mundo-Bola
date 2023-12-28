package br.com.alura.mundobola.ui.extra

import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.aplicacao.modelo.dto.MarcaDTO
import br.com.alura.mundobola.dominio.Marca
import java.time.LocalDateTime

val amostraDeListaDeMarcas = listOf<MarcaDTO>(
    MarcaDTO(
        "1",
        "Adidas",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png",
        LocalDateTime.now().dataFormatada()
    ),
    MarcaDTO(
        "2",
        "Nike",
        "https://logospng.org/wp-content/uploads/nike.jpg",
        LocalDateTime.now().dataFormatada()
    ),
    MarcaDTO(
        "3",
        "Penalty",
        "https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png",
        LocalDateTime.now().dataFormatada()
    )
)
