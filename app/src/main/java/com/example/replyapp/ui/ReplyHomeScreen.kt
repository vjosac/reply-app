package com.example.replyapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.replyapp.data.Email
import com.example.replyapp.data.MailboxType
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.replyapp.R
import com.example.replyapp.data.local.LocalAccountsDataProvider

@Composable
fun ReplyHomeScreen(
    replyUiState: ReplyUiState,
    onTabPressed: (MailboxType) -> Unit,
    onEmailCardPressed: (Email) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            mailboxType = MailboxType.Inbox,
            icon = Icons.Default.Email,
            text = stringResource(id = R.string.tab_inbox)
        ),
        NavigationItemContent(
            mailboxType = MailboxType.Sent,
            icon = Icons.Filled.Send,
            text = stringResource(id = R.string.tab_sent)
        ),
        NavigationItemContent(
            mailboxType = MailboxType.Drafts,
            icon = Icons.Default.Edit,
            text = stringResource(id = R.string.tab_drafts)
        ),
        NavigationItemContent(
            mailboxType = MailboxType.Spam,
            icon = Icons.Default.ExitToApp,
            text = stringResource(id = R.string.tab_spam)
        )
    )
    if (replyUiState.isShowingHomepage) {
        ReplyAppContent(
            replyUiState = replyUiState,
            onTabPressed = onTabPressed,
            onEmailCardPressed = onEmailCardPressed,
            navigationItemContentList = navigationItemContentList,
            modifier = modifier
        )
    } else {
        ReplyDetailsScreen(
            replyUiState = replyUiState,
            onBackPressed = onDetailScreenBackPressed,
            modifier = modifier
        )
    }
}

@Composable
private fun ReplyAppContent(
    replyUiState: ReplyUiState,
    onTabPressed: ((MailboxType) -> Unit),
    onEmailCardPressed: (Email) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val navigationRailContentDescription = stringResource(R.string.navigation_rail)
        ReplyNavigationRail(
            currentTab = replyUiState.currentMailbox,
            onTabPressed = onTabPressed,
            navigationItemContentList = navigationItemContentList,
            modifier = Modifier
                .testTag(navigationRailContentDescription)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            ReplyListOnlyContent(
                replyUiState = replyUiState,
                onEmailCardPressed = onEmailCardPressed,
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        horizontal = dimensionResource(R.dimen.email_list_only_horizontal_padding)
                    )
            )
            val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
            ReplyBottomNavigationBar(
                currentTab = replyUiState.currentMailbox,
                onTabPressed = onTabPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}


@Composable
private fun ReplyNavigationRail(
    currentTab: MailboxType,
    onTabPressed: ((MailboxType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.mailboxType,
                onClick = { onTabPressed(navItem.mailboxType) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}


@Composable
private fun ReplyBottomNavigationBar(
    currentTab: MailboxType,
    onTabPressed: ((MailboxType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.mailboxType,
                onClick = { onTabPressed(navItem.mailboxType) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

@Composable
private fun NavigationDrawerHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ReplyLogo(modifier = Modifier.size(dimensionResource(R.dimen.reply_logo_size)))
        ReplyProfileImage(
            drawableRes = LocalAccountsDataProvider.defaultAccount.avatar,
            description = stringResource(id = R.string.profile),
            modifier = Modifier.size(dimensionResource(R.dimen.profile_image_size))
        )
    }
}

private data class NavigationItemContent(
    val mailboxType: MailboxType,
    val icon: ImageVector,
    val text: String
)