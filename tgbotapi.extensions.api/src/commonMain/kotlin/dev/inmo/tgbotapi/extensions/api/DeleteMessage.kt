package dev.inmo.tgbotapi.extensions.api

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.requests.DeleteMessage
import dev.inmo.tgbotapi.types.ChatIdentifier
import dev.inmo.tgbotapi.types.MessageIdentifier
import dev.inmo.tgbotapi.types.chat.abstracts.Chat
import dev.inmo.tgbotapi.types.message.abstracts.Message

suspend fun TelegramBot.deleteMessage(
    chatId: ChatIdentifier,
    messageId: MessageIdentifier
) = execute(
    DeleteMessage(chatId, messageId)
)

suspend fun TelegramBot.deleteMessage(
    chat: Chat,
    messageId: MessageIdentifier
) = deleteMessage(chat.id, messageId)

suspend fun TelegramBot.deleteMessage(
    message: Message
) = deleteMessage(message.chat, message.messageId)

suspend fun Message.delete(
    requestsExecutor: TelegramBot
) = requestsExecutor.deleteMessage(this)
