package data.repository

import data.datasource.remote.movie.MovieDataSource
import data.model.remote.Movie
import domain.repository.MovieRepository

class DefaultMovieRepository(private val movieDataSource: MovieDataSource) : MovieRepository {
  override suspend fun getMovies(): Result<List<Movie>> {
    return kotlin.runCatching {
      movieDataSource.getMovies()
    }
  }
}