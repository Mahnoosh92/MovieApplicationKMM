package presentation.viewmodel

import data.model.remote.Movie
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

  private val _movies = MutableStateFlow<MovieUiState>(MovieUiState())
  val movies: StateFlow<MovieUiState> = _movies
  init {
    getMovies()
  }
  private fun getMovies() {
    viewModelScope.launch {
      movieRepository.getMovies()
        .onFailure { throwable ->
          _movies.update { movieUiState ->
            movieUiState.copy(errorMessage = throwable.message)
          }
        }
        .onSuccess { list ->
          _movies.update { movieUiState ->
            movieUiState.copy(data = list)
          }
        }
    }
  }
}

data class MovieUiState(val data: List<Movie>? = null, val errorMessage: String? = null)