package br.com.alura.mundobola.infraestrutura.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.mundobola.aplicacao.modelo.entity.BolaEntity
import br.com.alura.mundobola.aplicacao.modelo.entity.MarcaEntity
import br.com.alura.mundobola.infraestrutura.database.converters.Converters
import br.com.alura.mundobola.infraestrutura.database.dao.BolaDao
import br.com.alura.mundobola.infraestrutura.database.dao.MarcaDao

@Database(
    entities = [BolaEntity::class, MarcaEntity::class],
    exportSchema = true,
    version = 1
)
@TypeConverters(Converters::class)
abstract class MundoBolaDatabase : RoomDatabase() {
    abstract fun bolaDao(): BolaDao
    abstract fun marcaDao(): MarcaDao
}