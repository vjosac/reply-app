package com.example.replyapp.data

import androidx.annotation.StringRes

data class Email(
    val id: Long,
    val sender: Account,
    val recipients: List<Account> = emptyList(),
    @StringRes val subject: Int = -1,
    @StringRes val body: Int = -1,
    val mailbox: MailboxType = MailboxType.Inbox,
    var createdAt: Int = -1
)
