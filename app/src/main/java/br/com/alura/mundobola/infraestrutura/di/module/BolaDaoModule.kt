package br.com.alura.mundobola.infraestrutura.di.module

import br.com.alura.mundobola.aplicacao.dao.BolaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BolaDaoModule {
    @Provides
    @Singleton
    fun provideBolaDao():BolaDao{
        return BolaDao()
    }
}