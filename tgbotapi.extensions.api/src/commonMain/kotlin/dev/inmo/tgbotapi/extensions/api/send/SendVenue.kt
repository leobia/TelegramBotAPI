package dev.inmo.tgbotapi.extensions.api.send

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.send.SendVenue
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.buttons.KeyboardMarkup
import dev.inmo.tgbotapi.types.chat.abstracts.Chat
import dev.inmo.tgbotapi.types.message.abstracts.Message
import dev.inmo.tgbotapi.types.venue.Venue

suspend fun TelegramBot.sendVenue(
    chatId: ChatIdentifier,
    latitude: Double,
    longitude: Double,
    title: String,
    address: String,
    foursquareId: String? = null,
    disableNotification: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    replyMarkup: KeyboardMarkup? = null
) = execute(
    SendVenue(
        chatId, latitude, longitude, title, address, foursquareId, disableNotification, replyToMessageId, replyMarkup
    )
)

suspend fun TelegramBot.sendVenue(
    chat: Chat,
    latitude: Double,
    longitude: Double,
    title: String,
    address: String,
    foursquareId: String? = null,
    disableNotification: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    replyMarkup: KeyboardMarkup? = null
) = sendVenue(
    chat.id, latitude, longitude, title, address, foursquareId, disableNotification, replyToMessageId, replyMarkup
)

suspend fun TelegramBot.sendVenue(
    chatId: ChatIdentifier,
    location: Location,
    title: String,
    address: String,
    foursquareId: String? = null,
    disableNotification: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    replyMarkup: KeyboardMarkup? = null
) = sendVenue(
    chatId, location.latitude, location.longitude, title, address, foursquareId, disableNotification, replyToMessageId, replyMarkup
)

suspend fun TelegramBot.sendVenue(
    chat: Chat,
    location: Location,
    title: String,
    address: String,
    foursquareId: String? = null,
    disableNotification: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    replyMarkup: KeyboardMarkup? = null
) = sendVenue(
    chat.id, location.latitude, location.longitude, title, address, foursquareId, disableNotification, replyToMessageId, replyMarkup
)

suspend fun TelegramBot.sendVenue(
    chatId: ChatIdentifier,
    venue: Venue,
    disableNotification: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    replyMarkup: KeyboardMarkup? = null
) = execute(
    SendVenue(
        chatId, venue, disableNotification, replyToMessageId, replyMarkup
    )
)

suspend fun TelegramBot.sendVenue(
    chat: Chat,
    venue: Venue,
    disableNotification: Boolean = false,
    replyToMessageId: MessageIdentifier? = null,
    replyMarkup: KeyboardMarkup? = null
) = sendVenue(
    chat.id, venue, disableNotification, replyToMessageId, replyMarkup
)

suspend inline fun TelegramBot.reply(
    to: Message,
    latitude: Double,
    longitude: Double,
    title: String,
    address: String,
    foursquareId: String? = null,
    disableNotification: Boolean = false,
    replyMarkup: KeyboardMarkup? = null
) = sendVenue(
    to.chat, latitude, longitude, title, address, foursquareId, disableNotification, to.messageId, replyMarkup
)

suspend inline fun TelegramBot.reply(
    to: Message,
    location: Location,
    title: String,
    address: String,
    foursquareId: String? = null,
    disableNotification: Boolean = false,
    replyMarkup: KeyboardMarkup? = null
) = sendVenue(
    to.chat, location, title, address, foursquareId, disableNotification, to.messageId, replyMarkup
)

suspend inline fun TelegramBot.reply(
    to: Message,
    venue: Venue,
    disableNotification: Boolean = false,
    replyMarkup: KeyboardMarkup? = null
) = sendVenue(
    to.chat, venue, disableNotification, to.messageId, replyMarkup
)
