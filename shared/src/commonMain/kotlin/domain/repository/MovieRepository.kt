package domain.repository

import data.model.remote.Movie

interface MovieRepository {
  suspend fun getMovies(): Result<List<Movie>>
}