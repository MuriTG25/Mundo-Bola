package br.com.alura.mundobola.infraestrutura.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.alura.mundobola.aplicacao.modelo.entity.MarcaEntity
import br.com.alura.mundobola.aplicacao.modelo.pojo.MarcaPOJO
import kotlinx.coroutines.flow.Flow

@Dao
interface MarcaDao {
    @Query("SELECT * FROM marca")
    fun listaDeMarcas(): Flow<List<MarcaEntity>>

    @Query("SELECT * FROM marca WHERE marcaId = :marcaId")
    fun encontrarMarcaPeloId(marcaId: String): Flow<MarcaEntity?>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun adicionarMarca(marca: MarcaEntity)

    @Update(entity = MarcaEntity::class)
    suspend fun editaMarca(marca: MarcaPOJO)
}