package data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
  @SerialName("backdrop_path") val backdropPath: String?,
  @SerialName("poster_path") val posterPath: String?,
  @SerialName("original_language") val originalLanguage: String?,
  @SerialName("original_title") val originalTitle: String?,
  @SerialName("release_date") val releaseDate: String?,
  @SerialName("genre_ids") val genreIds: List<Int>?,
  @SerialName("vote_average") val voteAverage: Double?,
  @SerialName("vote_count") val voteCount: Double?,
  val adult: Boolean?,
  val video: Boolean?,
  val popularity: Double?,
  val id: Int?,
  val overview: String?,
  val title: String?
)