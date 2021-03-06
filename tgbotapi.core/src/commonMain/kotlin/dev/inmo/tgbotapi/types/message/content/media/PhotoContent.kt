package dev.inmo.tgbotapi.types.message.content.media

import dev.inmo.tgbotapi.CommonAbstracts.TextPart
import dev.inmo.tgbotapi.requests.abstracts.Request
import dev.inmo.tgbotapi.requests.send.media.SendPhoto
import dev.inmo.tgbotapi.types.ChatIdentifier
import dev.inmo.tgbotapi.types.InputMedia.InputMediaPhoto
import dev.inmo.tgbotapi.types.InputMedia.MediaGroupMemberInputMedia
import dev.inmo.tgbotapi.types.MessageIdentifier
import dev.inmo.tgbotapi.types.ParseMode.HTMLParseMode
import dev.inmo.tgbotapi.types.ParseMode.MarkdownV2
import dev.inmo.tgbotapi.types.buttons.KeyboardMarkup
import dev.inmo.tgbotapi.types.files.*
import dev.inmo.tgbotapi.types.message.abstracts.ContentMessage
import dev.inmo.tgbotapi.types.message.content.abstracts.MediaCollectionContent
import dev.inmo.tgbotapi.types.message.content.abstracts.MediaGroupContent
import dev.inmo.tgbotapi.utils.toHtmlCaptions
import dev.inmo.tgbotapi.utils.toMarkdownV2Captions

data class PhotoContent(
    override val mediaCollection: Photo,
    override val caption: String? = null,
    override val captionEntities: List<TextPart> = emptyList()
) : MediaCollectionContent<PhotoSize>, MediaGroupContent {
    override val media: PhotoSize = mediaCollection.biggest() ?: throw IllegalStateException("Can't locate any photo size for this content")

    override fun createResend(
        chatId: ChatIdentifier,
        disableNotification: Boolean,
        replyToMessageId: MessageIdentifier?,
        replyMarkup: KeyboardMarkup?
    ): Request<ContentMessage<PhotoContent>> = SendPhoto(
        chatId,
        media.fileId,
        toHtmlCaptions().firstOrNull(),
        HTMLParseMode,
        disableNotification,
        replyToMessageId,
        replyMarkup
    )

    override fun toMediaGroupMemberInputMedia(): MediaGroupMemberInputMedia = InputMediaPhoto(
        media.fileId,
        toHtmlCaptions().firstOrNull(),
        HTMLParseMode
    )

    override fun asInputMedia(): InputMediaPhoto = InputMediaPhoto(
        media.fileId,
        toMarkdownV2Captions().firstOrNull(),
        MarkdownV2
    )
}
