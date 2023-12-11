package br.com.alura.mundobola.aplicacao.modelo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.alura.mundobola.dominio.Marca
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class MarcaEntity(
    @PrimaryKey(false)
    val marcaId: String = UUID.randomUUID().toString(),
    @ColumnInfo(index = true)
    val nome: String,
    val imagem: String? = null,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val dataAlteracao: LocalDateTime? = null,
    val estaAtivo: Boolean = true,
)
fun MarcaEntity.toMarca() = Marca(
    marcaId = marcaId,
    nome = nome,
    imagem = imagem,
    dataCriacao = dataCriacao,
    dataAlteracao = dataAlteracao,
    estaAtivo = estaAtivo
)
