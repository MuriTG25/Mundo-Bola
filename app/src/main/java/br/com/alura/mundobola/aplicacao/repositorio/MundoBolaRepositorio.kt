package br.com.alura.mundobola.aplicacao.repositorio

import br.com.alura.mundobola.aplicacao.dao.BolaDao
import br.com.alura.mundobola.aplicacao.dao.MarcaDao
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import kotlinx.coroutines.flow.StateFlow
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
    suspend fun listaDeMarcas():List<Marca>{
        return marcaDao.listaDeMarcas().value
    }
    suspend fun encontrarBolaPeloId(id:String): Bola?{
        return bolaDao.encontrarBolaPeloId(id)
    }
    suspend fun encontrarMarcaPeloId(id:String): Marca?{
        return marcaDao.encontrarMarcaPeloId(id)
    }
    suspend fun encontrarNomeMarcaPeloId(id:String): String?{
        return marcaDao.encontrarMarcaPeloId(id)?.nome
    }
    suspend fun deletaBola(id: String){
        val bolaEncotrada = bolaDao.encontrarBolaPeloId(id)
        bolaEncotrada?.let {
            bolaDao.deletaBola(it)
        }
    }
    suspend fun editaBola(
        id: String,
        novaBola: Bola,
    ){
        val bolaEncotrada = bolaDao.encontrarBolaPeloId(id)
        bolaEncotrada?.let {
            bolaDao.deletaBola(it)
            bolaDao.adicionarBola(novaBola)
        }
    }
}