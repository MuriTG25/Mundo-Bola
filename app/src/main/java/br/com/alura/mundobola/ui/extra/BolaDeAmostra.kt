package br.com.alura.mundobola.ui.extra

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.aplicacao.modelo.view.BolaView

import java.time.LocalDateTime

val bolaDeAmostra = BolaView(
    bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
    nome = "Total90",
    preco = "99.90",
    marcaId = "id",
    descricao = LoremIpsum(10).values.first(),
    dataCriacao = LocalDateTime.now().dataFormatada(),
    imagem = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg",
)

val amostraDeListaDeBolas = listOf(
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = "Total90",
        preco = "99.90",
        marcaId = "id",
        descricao = LoremIpsum(30).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
        imagem = "https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg",
    ),
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = LoremIpsum(10).values.first(),
        preco = "39.90",
        marcaId = "id",
        descricao = LoremIpsum(10).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
    ),
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = "Jabulani",
        preco = "1090.90",
        marcaId = "id",
        descricao = LoremIpsum(10).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
        imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
    ),
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = "Jabulani",
        preco = "1090.90",
        marcaId = "id",
        descricao = LoremIpsum(10).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
        imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
    ),
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = "Jabulani",
        preco = "1090.90",
        marcaId = "id",
        descricao = LoremIpsum(10).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
        imagem = "https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg",
    ),
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = "Penalty Lider Campo",
        preco = "299.90",
        marcaId = "id",
        descricao = LoremIpsum(5).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
        imagem = "https://cambuci.vteximg.com.br/arquivos/ids/460927/bola-lider-n4-521305-1641-1.jpg?v=637819402244530000",
    ),
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = "Penalty Lider Campo",
        preco = "299.90",
        marcaId = "id",
        descricao = LoremIpsum(100).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
        imagem = "https://cambuci.vteximg.com.br/arquivos/ids/943920/bola_campo_lider_xxi_521303_1850_1.jpg?v=638240930364500000"
    ),
    BolaView
        (
        bolaId = "a4216a2e-a33a-4857-b47d-1d17b921c1a6",
        nome = "Penalty Lider Campo",
        preco = "299.90",
        marcaId = "id",
        descricao = LoremIpsum(50).values.first(),
        dataCriacao = LocalDateTime.now().dataFormatada(),
        imagem = "https://cambuci.vteximg.com.br/arquivos/ids/943919-292-292/bola-lider-521303-1710-1.jpg?v=638240930324100000",
    ),
)
