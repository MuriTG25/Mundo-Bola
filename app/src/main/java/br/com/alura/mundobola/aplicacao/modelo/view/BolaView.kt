package br.com.alura.mundobola.aplicacao.modelo.view

import br.com.alura.mundobola.aplicacao.extra.dataFormatada
import br.com.alura.mundobola.aplicacao.extra.paraMoedaBrasileira
import br.com.alura.mundobola.dominio.Bola

data class BolaView(
    val bolaId: String,
    val nome: String,
    val preco: String,
    val marcaId: String,
    val descricao: String,
    val imagem: String = "",
    val dataCriacao: String,
    val dataAlteracao: String,
)

fun Bola.paraBolaView() = BolaView(
    bolaId = bolaId,
    nome = nome,
    preco = preco.paraMoedaBrasileira(),
    marcaId = marcaId ?: "",
    descricao = descricao ?: "",
    imagem = imagem ?: "",
    dataCriacao = dataCriacao.dataFormatada(),
    dataAlteracao = dataAlteracao?.dataFormatada() ?: "",
)