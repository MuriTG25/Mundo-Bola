package br.com.alura.mundobola.aplicacao.repositorio

import br.com.alura.mundobola.aplicacao.dao.BolaDao
import br.com.alura.mundobola.aplicacao.dao.MarcaDao
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MundoBolaRepositorio @Inject constructor(
    private val bolaDao: BolaDao,
    private val marcaDao: MarcaDao,
){
    suspend fun listaDeBolas(): StateFlow<List<Bola>> {
        return bolaDao.listaDeBolas()
    }
    suspend fun adicionarBola(bola: Bola){
        bolaDao.adicionarBola(bola)
    }
    suspend fun listaDeMarcas(): StateFlow<List<Marca>> {
        return marcaDao.listaDeMarcas()
    }
    suspend fun encontrarBolaPeloId(id:String): Flow<Bola?> {
        return flow {
           emit(bolaDao.encontrarBolaPeloId(id))
        }
    }
    suspend fun encontrarMarcaPeloId(id:String): Flow<Marca?> {
        return flow {
            emit(marcaDao.encontrarMarcaPeloId(id))
        }
    }
    suspend fun encontrarNomeMarcaPeloId(id:String): Flow<String?> {
        return flow {
            emit(marcaDao.encontrarMarcaPeloId(id)?.nome)
        }
    }
    suspend fun deletaBola(id: String){
        encontrarBolaPeloId(id).collect{ bolaEncotrada ->
            bolaEncotrada?.let {
                bolaDao.deletaBola(it)
            }
        }
    }
    suspend fun editaBola(
        novaBola: Bola,
    ){
        encontrarBolaPeloId(novaBola.bolaId).collect{ bolaEncotrada ->
            bolaEncotrada?.let {
                bolaDao.deletaBola(it)
                bolaDao.adicionarBola(novaBola)
            }
        }
    }
}