package data.datasource.remote.movie

import data.model.remote.Movie

interface MovieDataSource {

  suspend fun getMovies():List<Movie>
}