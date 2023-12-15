package br.com.alura.mundobola.infraestrutura.di.module

import android.content.Context
import androidx.room.Room
import br.com.alura.mundobola.infraestrutura.database.MundoBolaDatabase
import br.com.alura.mundobola.infraestrutura.database.dao.BolaDao
import br.com.alura.mundobola.infraestrutura.database.dao.MarcaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "mundobola.db"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ):MundoBolaDatabase{
        return Room.databaseBuilder(
            context,
            MundoBolaDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    @Provides
    fun provideBolaDao(db:MundoBolaDatabase):BolaDao{
        return db.bolaDao()
    }
    @Provides
    fun provideMarcaDao(db:MundoBolaDatabase):MarcaDao{
        return db.marcaDao()
    }
}