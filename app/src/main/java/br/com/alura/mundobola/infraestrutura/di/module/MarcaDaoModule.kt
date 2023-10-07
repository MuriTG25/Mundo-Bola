package br.com.alura.mundobola.infraestrutura.di.module

import br.com.alura.mundobola.aplicacao.dao.MarcaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarcaDaoModule {
    @Provides
    @Singleton
    fun provideMarcaDao():MarcaDao{
        return MarcaDao()
    }
}