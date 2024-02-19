package data.di


import data.api.KtorApi
import data.api.KtorApiImpl
import data.api.MovieApi
import data.datasource.remote.movie.DefaultMovieDataSource
import data.datasource.remote.movie.MovieDataSource
import data.repository.DefaultMovieRepository
import domain.repository.MovieRepository
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import presentation.viewmodel.MovieViewModel

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
  appDeclaration()
  modules(
    apiModule,
    datasourceModule,
    repositoryModule,
    viewModelModule
  )
}

private val apiModule = module {
  single<KtorApi> { KtorApiImpl() }
  factory { MovieApi() }
}
private val viewModelModule = module {
  single { MovieViewModel(get()) }
}
private val repositoryModule = module {
  single<MovieRepository> { DefaultMovieRepository(get()) }
}
private val datasourceModule = module {
  single<MovieDataSource> { DefaultMovieDataSource(get()) }
}

fun initKoin() = initKoin {}