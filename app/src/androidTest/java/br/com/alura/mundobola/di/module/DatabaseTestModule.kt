package br.com.alura.mundobola.di.module

import android.content.Context
import androidx.room.Room
import br.com.alura.mundobola.infraestrutura.database.MundoBolaDatabase
import br.com.alura.mundobola.infraestrutura.database.dao.BolaDao
import br.com.alura.mundobola.infraestrutura.database.dao.MarcaDao
import br.com.alura.mundobola.infraestrutura.di.module.DatabaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
class DatabaseTestModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MundoBolaDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            MundoBolaDatabase::class.java,
        ).build()
    }
    @Provides
    fun provideBolaDao(db:MundoBolaDatabase): BolaDao {
        return db.bolaDao()
    }
    @Provides
    fun provideMarcaDao(db:MundoBolaDatabase): MarcaDao {
        return db.marcaDao()
    }
}