package data.datasource.remote.movie

import data.api.MovieApi
import data.model.remote.Movie

class DefaultMovieDataSource(private val movieApi: MovieApi):MovieDataSource {
  override suspend fun getMovies(): List<Movie> = movieApi.getMovies().results
}