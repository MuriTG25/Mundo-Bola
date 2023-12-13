package br.com.alura.mundobola.aplicacao.modelo.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import br.com.alura.mundobola.dominio.Bola
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MarcaEntity::class,
            parentColumns = arrayOf("marcaId"),
            childColumns = arrayOf("marcaId"),
            onDelete = ForeignKey.CASCADE
        )
    ],
    tableName = "bola"
)
data class BolaEntity(
    @PrimaryKey(false)
    val bolaId: String = UUID.randomUUID().toString(),
    @ColumnInfo(index = true)
    val nome: String,
    val preco: BigDecimal,
    @ColumnInfo(index = true)
    val marcaId: String? = null,
    val descricao: String? = null,
    val imagem: String? = null,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val dataAlteracao: LocalDateTime? = null,
)

fun BolaEntity.toBola() = Bola(
    bolaId = bolaId,
    nome = nome,
    preco = preco,
    marcaId = marcaId,
    descricao = descricao,
    imagem = imagem,
    dataCriacao = dataCriacao,
    dataAlteracao = dataAlteracao,
)

