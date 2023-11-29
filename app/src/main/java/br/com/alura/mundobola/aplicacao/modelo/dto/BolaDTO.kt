package br.com.alura.mundobola.aplicacao.modelo.dto

import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.aplicacao.extra.paraMoedaBrasileira
import br.com.alura.mundobola.dominio.Bola

data class BolaDTO(
    val bolaId: String,
    val nome: String,
    val preco: String,
    val marcaId: String,
    val descricao: String,
    val imagem: String = "",
    val dataCriacao: String,
    val dataAlteracao: String,
)

fun Bola.paraBolaDTO() = BolaDTO(
    bolaId = bolaId,
    nome = nome,
    preco = preco.paraMoedaBrasileira(),
    marcaId = marcaId ?: "",
    descricao = descricao ?: "",
    imagem = imagem ?: "",
    dataCriacao = dataCriacao.dataFormatada(),
    dataAlteracao = dataAlteracao?.dataFormatada() ?: "",
)