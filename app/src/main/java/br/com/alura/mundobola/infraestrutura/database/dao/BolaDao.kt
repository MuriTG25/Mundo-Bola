package br.com.alura.mundobola.infraestrutura.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.alura.mundobola.aplicacao.modelo.entity.BolaEntity
import br.com.alura.mundobola.aplicacao.modelo.pojo.BolaPOJO
import kotlinx.coroutines.flow.Flow

@Dao
interface BolaDao {
    @Query("SELECT * FROM bola")
    fun listaDeBolas(): Flow<List<BolaEntity>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun adicionarBola(bola: BolaEntity)

    @Query("SELECT * FROM bola WHERE bolaId = :bolaId")
    fun encontrarBolaPeloId(bolaId: String): Flow<BolaEntity?>

    @Update(entity = BolaEntity::class)
    suspend fun atualizaBola(bola: BolaPOJO)

    @Query("DELETE FROM bola WHERE bolaId = :bolaId")
    suspend fun deletaBola(bolaId: String)

    @Query("SELECT * FROM bola ORDER BY :property ASC")
    fun listaDeBolasOrdenadaAsc(property: String): Flow<List<BolaEntity>>

    @Query("SELECT * FROM bola ORDER BY :property DESC")
    fun listaDeBolasOrdenadaDesc(property: String): Flow<List<BolaEntity>>

    @Query("SELECT * FROM bola WHERE nome LIKE '%' || :nome || '%'")
    fun buscaBolasPorNome(nome: String): Flow<List<BolaEntity>>
}

