package br.com.alura.mundobola.aplicacao.modelo.dto

import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.dominio.Marca

data class MarcaDTO(
    val marcaId: String,
    val nome: String,
    val imagem: String = "",
    val dataCriacao: String,
    val dataAlteracao: String = "",
)
fun Marca.paraMarcaDTO() = MarcaDTO(
    marcaId = marcaId,
    nome = nome,
    imagem = imagem ?: "",
    dataCriacao = dataCriacao.dataFormatada(),
    dataAlteracao = dataAlteracao?.dataFormatada() ?: "",
)