import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import data.model.remote.Movie
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.koinInject
import presentation.viewmodel.MovieViewModel

@Composable
fun App(viewModel: MovieViewModel = koinInject()) {
  val movieUiState = viewModel.movies.collectAsState()
  MaterialTheme {
    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
      movieUiState.value.data?.let {
        items(it) {movie->
          Item(movie)
        }
      }
    }
  }
}

@Composable
fun Item(movie:Movie) {
  Text(text = movie.title?:"Default")
}