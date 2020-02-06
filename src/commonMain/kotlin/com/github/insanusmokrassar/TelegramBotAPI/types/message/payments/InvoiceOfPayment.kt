package com.github.insanusmokrassar.TelegramBotAPI.types.message.payments

import com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts.Request
import com.github.insanusmokrassar.TelegramBotAPI.requests.send.payments.SendInvoice
import com.github.insanusmokrassar.TelegramBotAPI.types.ChatIdentifier
import com.github.insanusmokrassar.TelegramBotAPI.types.MessageIdentifier
import com.github.insanusmokrassar.TelegramBotAPI.types.buttons.KeyboardMarkup
import com.github.insanusmokrassar.TelegramBotAPI.types.message.abstracts.ContentMessage
import com.github.insanusmokrassar.TelegramBotAPI.types.message.abstracts.Message
import com.github.insanusmokrassar.TelegramBotAPI.types.message.content.abstracts.MessageContent
import com.github.insanusmokrassar.TelegramBotAPI.types.message.payments.abstracts.PaymentInfo
import com.github.insanusmokrassar.TelegramBotAPI.types.payments.Invoice

data class InvoiceOfPayment(
    val invoice: Invoice
) : MessageContent {
    override fun createResend(
        chatId: ChatIdentifier,
        disableNotification: Boolean,
        replyToMessageId: MessageIdentifier?,
        replyMarkup: KeyboardMarkup?
    ): Request<ContentMessage<InvoiceOfPayment>> {
        error("Unfortunately, currently InvoiceOfPayment can not be resend due to requirement of additional parameters," +
            " which can't be provided during the call of this method")
    }
}
