package data.api

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder

interface KtorApi {
  val client: HttpClient
  fun HttpRequestBuilder.json()
}