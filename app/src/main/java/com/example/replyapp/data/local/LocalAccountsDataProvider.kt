package com.example.replyapp.data.local

import com.example.replyapp.R
import com.example.replyapp.data.Account

object LocalAccountsDataProvider {
    val defaultAccount = Account(-1, -1, -1, -1, null)

    private val allUserContactAccounts = listOf(
        Account(
            id = 4L,
            firstName = R.string.account_4_first_name,
            lastName = R.string.account_4_last_name,
            email = R.string.account_4_email,
            avatar = null
        ),
        Account(
            id = 5L,
            firstName = R.string.account_5_first_name,
            lastName = R.string.account_5_last_name,
            email = R.string.account_5_email,
            avatar = null
        ),
        Account(
            id = 6L,
            firstName = R.string.account_6_first_name,
            lastName = R.string.account_6_last_name,
            email = R.string.account_6_email,
            avatar = null
        ),
        Account(
            id = 7L,
            firstName = R.string.account_7_first_name,
            lastName = R.string.account_7_last_name,
            email = R.string.account_7_email,
            avatar = null
        ),
        Account(
            id = 8L,
            firstName = R.string.account_8_first_name,
            lastName = R.string.account_8_last_name,
            email = R.string.account_8_email,
            avatar = null
        ),
        Account(
            id = 9L,
            firstName = R.string.account_9_first_name,
            lastName = R.string.account_9_last_name,
            email = R.string.account_9_email,
            avatar = null
        ),
        Account(
            id = 10L,
            firstName = R.string.account_10_first_name,
            lastName = R.string.account_10_last_name,
            email = R.string.account_10_email,
            avatar = null
        ),
        Account(
            id = 11L,
            firstName = R.string.account_11_first_name,
            lastName = R.string.account_11_last_name,
            email = R.string.account_11_email,
            avatar = null
        ),
        Account(
            id = 12L,
            firstName = R.string.account_12_first_name,
            lastName = R.string.account_12_last_name,
            email = R.string.account_12_email,
            avatar = null
        ),
        Account(
            id = 13L,
            firstName = R.string.account_13_first_name,
            lastName = R.string.account_13_last_name,
            email = R.string.account_13_email,
            avatar = null
        )
    )

    fun getContactAccountById(accountId: Long): Account {
        return allUserContactAccounts.firstOrNull { it.id == accountId}
            ?: allUserContactAccounts.first()
    }
}