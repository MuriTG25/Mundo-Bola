package br.com.alura.mundobola.aplicacao.modelo.view

import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.dominio.Marca

data class MarcaView(
    val marcaId: String,
    val nome: String,
    val imagem: String = "",
    val dataCriacao: String,
    val dataAlteracao: String = "Não Alterado",
)
fun Marca.paraMarcaView() = MarcaView(
    marcaId = marcaId,
    nome = nome,
    imagem = imagem ?: "",
    dataCriacao = dataCriacao.dataFormatada(),
    dataAlteracao = dataAlteracao?.dataFormatada() ?: "Não Alterado",
)