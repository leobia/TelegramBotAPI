package dev.inmo.tgbotapi.requests.stickers.abstracts

import dev.inmo.tgbotapi.types.stickers.MaskPosition

interface StandardStickerSetAction : StickerSetAction {
    val emojis: String // must be more than one
    val maskPosition: MaskPosition?
}