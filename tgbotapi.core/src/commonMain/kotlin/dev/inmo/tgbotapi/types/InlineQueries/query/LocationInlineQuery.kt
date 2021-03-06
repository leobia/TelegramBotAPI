package dev.inmo.tgbotapi.types.InlineQueries.query

import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.InlineQueries.abstracts.InlineQuery

data class LocationInlineQuery(
    override val id: InlineQueryIdentifier,
    override val from: User,
    override val query: String,
    override val offset: String,
    val location: Location
) : InlineQuery
