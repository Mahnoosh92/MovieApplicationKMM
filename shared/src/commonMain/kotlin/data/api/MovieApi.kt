package data.api

import data.model.remote.MoviesResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.request
import org.example.project.shared.BuildConfig
class MovieApi : KtorApi by KtorApiImpl() {
  companion object {
    const val movies = "https://api.themoviedb.org/3/movie/popular?api_key=4440212f74cc5cbe7457bb569a895f91"
  }

  suspend fun getMovies(): MoviesResponse {
    val request = client.get(movies)

    return request.body()
  }
}