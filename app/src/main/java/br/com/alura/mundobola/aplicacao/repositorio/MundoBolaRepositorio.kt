package br.com.alura.mundobola.aplicacao.repositorio


import br.com.alura.mundobola.aplicacao.modelo.entity.toBola
import br.com.alura.mundobola.aplicacao.modelo.entity.toBolaEntity
import br.com.alura.mundobola.aplicacao.modelo.entity.toMarca
import br.com.alura.mundobola.aplicacao.modelo.pojo.toBolaPOJO
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
    suspend fun listaDeBolas(): Flow<List<Bola>> {
        return bolaDao.listaDeBolas().map { lista ->
            lista.map { bola ->
                bola.toBola()
            }
        }
    }

    suspend fun adicionarBola(bola: Bola) {
        bolaDao.adicionarBola(bola.toBolaEntity())
    }

    suspend fun listaDeMarcas(): Flow<List<Marca>> {
        return marcaDao.listaDeMarcas().map { lista ->
            lista.map { marca ->
                marca.toMarca()
            }
        }
    }

    suspend fun encontrarBolaPeloId(id: String): Flow<Bola?> {
        return bolaDao.encontrarBolaPeloId(id).map {
            it?.toBola()
        }
    }

    suspend fun encontrarMarcaPeloId(id: String): Flow<Marca?> {
        return marcaDao.encontrarMarcaPeloId(id).map {
            it.toMarca()
        }
    }

    suspend fun deletaBola(id: String) {
        bolaDao.deletaBola(id)
    }

    suspend fun editaBola(
        novaBola: Bola,
    ) {
        bolaDao.atualizaBola(novaBola.toBolaPOJO())
    }

    suspend fun buscaBolaPorNome(nome: String): Flow<List<Bola>> {
        return bolaDao.buscaBolasPorNome(nome).map { lista ->
            lista.map { bola ->
                bola.toBola()
            }
        }
    }

    suspend fun listaDeBolasPorNomeAsc(): List<Bola> {
        return bolaDao.listaDeBolasPorNomeAsc().map { bola ->
            bola.toBola()
        }
    }

    suspend fun listaDeBolasPorNomeDesc(): List<Bola> {
        return bolaDao.listaDeBolasPorNomeDesc().map { bola ->
            bola.toBola()
        }
    }

    suspend fun listaDeBolasPorPrecoAsc(): List<Bola> {
        return bolaDao.listaDeBolasPorPrecoAsc().map { bola ->
            bola.toBola()
        }
    }

    suspend fun listaDeBolasPorPrecoDesc(): List<Bola> {
        return bolaDao.listaDeBolasPorPrecoDesc().map { bola ->
            bola.toBola()
        }
    }

    suspend fun listaDeBolasPeloMaisNovo(): List<Bola> {
        return bolaDao.listaDeBolasPeloMaisNovo().map { bola ->
                bola.toBola()
        }
    }

    suspend fun listaDeBolasPeloMaisAntigo(): List<Bola> {
        return bolaDao.listaDeBolasPeloMaisAntigo().map { bola ->
                bola.toBola()
        }
    }

}