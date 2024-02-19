package data.api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import org.example.project.shared.BuildConfig
import io.ktor.http.*
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import kotlinx.serialization.serializer

class KtorApiImpl : KtorApi {
  override val client: HttpClient= HttpClient {
    install(ContentNegotiation) {
      json()
    }
  }

  override fun HttpRequestBuilder.json() {
    contentType(ContentType.Application.Json)
  }
}