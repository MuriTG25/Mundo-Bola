package br.com.alura.mundobola.aplicacao.repositorio


import br.com.alura.mundobola.aplicacao.extra.OrdenacaoDaLista
import br.com.alura.mundobola.aplicacao.modelo.entity.BolaEntity
import br.com.alura.mundobola.aplicacao.modelo.entity.toBola
import br.com.alura.mundobola.aplicacao.modelo.entity.toBolaEntity
import br.com.alura.mundobola.aplicacao.modelo.entity.toMarca
import br.com.alura.mundobola.aplicacao.modelo.entity.toMarcaEntity
import br.com.alura.mundobola.aplicacao.modelo.pojo.BolaPOJO
import br.com.alura.mundobola.aplicacao.modelo.pojo.MarcaPOJO
import br.com.alura.mundobola.dominio.Bola
import br.com.alura.mundobola.dominio.Marca
import br.com.alura.mundobola.infraestrutura.database.dao.BolaDao
import br.com.alura.mundobola.infraestrutura.database.dao.MarcaDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MundoBolaRepositorio @Inject constructor(
    private val bolaDao: BolaDao,
    private val marcaDao: MarcaDao,
) {
    fun listaDeBolas(): Flow<List<Bola>> {
        return bolaDao.listaDeBolas().map { lista ->
            lista.map { bola ->
                bola.toBola()
            }
        }
    }

    suspend fun adicionarBola(bola: Bola) {
        bolaDao.adicionarBola(bola.toBolaEntity())
    }

    suspend fun adicionarMarca(marca: Marca) {
        marcaDao.adicionarMarca(marca.toMarcaEntity())
    }

    fun listaDeMarcas(): Flow<List<Marca>> {
        return marcaDao.listaDeMarcas().map { lista ->
            lista.map { marca ->
                marca.toMarca()
            }
        }
    }

    fun encontrarBolaPeloId(id: String): Flow<Bola?> {
        return bolaDao.encontrarBolaPeloId(id).map {
            it?.toBola()
        }
    }

    fun encontrarMarcaPeloId(id: String): Flow<Marca?> {
        return marcaDao.encontrarMarcaPeloId(id).map { marca ->
            marca?.toMarca()
        }
    }

    suspend fun deletaBola(id: String) {
        bolaDao.deletaBola(id)
    }

    suspend fun editaBola(bola: BolaPOJO) {
        bolaDao.editaBola(bola)
    }

    suspend fun editaMarca(marca: MarcaPOJO) {
        marcaDao.editaMarca(marca)
    }
    suspend fun deletaMarca(marcaId: String){
        marcaDao.deletaMarca(marcaId)
    }

    fun buscaBolaPorNome(nome: String): Flow<List<Bola>> {
        return bolaDao.buscaBolasPorNome(nome).map { lista ->
            lista.map { bola ->
                bola.toBola()
            }
        }
    }

    suspend fun listaDeBolasOrdenada(ordenacaoDaLista: OrdenacaoDaLista):List<Bola>{
        val listas =  when(ordenacaoDaLista){
            OrdenacaoDaLista.NOME_ASC -> bolaDao.listaDeBolasPorNomeAsc()
            OrdenacaoDaLista.NOME_DESC -> bolaDao.listaDeBolasPorNomeDesc()
            OrdenacaoDaLista.PRECO_ASC -> bolaDao.listaDeBolasPorPrecoAsc()
            OrdenacaoDaLista.PRECO_DESC -> bolaDao.listaDeBolasPorPrecoDesc()
            OrdenacaoDaLista.MAIS_ANTIGO -> bolaDao.listaDeBolasPeloMaisAntigo()
            OrdenacaoDaLista.MAIS_NOVO -> bolaDao.listaDeBolasPeloMaisNovo()
        }
        return listas.map {
            it.toBola()
        }
    }
    fun listaDeBolasPorMarca(marcaId: String): Flow<List<Bola>> {
        return bolaDao.listaDeBolasPorMarca(marcaId).map {lista->
            lista.map {
                it.toBola()
            }
        }
    }
}