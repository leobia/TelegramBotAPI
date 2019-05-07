package com.github.insanusmokrassar.TelegramBotAPI.bot.Ktor.base

import com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts.*
import com.github.insanusmokrassar.TelegramBotAPI.utils.toJsonWithoutNulls
import io.ktor.client.HttpClient
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent

class SimpleRequestCallFactory : AbstractRequestCallFactory() {
    override fun <T : Any> prepareCallBody(
        client: HttpClient,
        baseUrl: String,
        request: Request<T>
    ): Any? = (request as? SimpleRequest<T>) ?.let { _ ->
        val content = request.toJsonWithoutNulls(SimpleRequestSerializer).toString()

        TextContent(
            content,
            ContentType.Application.Json
        )
    }

}