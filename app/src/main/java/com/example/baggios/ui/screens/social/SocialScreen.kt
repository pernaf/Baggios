package com.example.baggios.ui.screens.social

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baggios.ui.theme.BaggiosBorder
import com.example.baggios.ui.theme.BaggiosCyan
import com.example.baggios.ui.theme.BaggiosIconContact
import com.example.baggios.ui.theme.BaggiosIconDisco
import com.example.baggios.ui.theme.BaggiosIconRelease
import com.example.baggios.ui.theme.BaggiosIconRider
import com.example.baggios.ui.theme.BaggiosIconShows
import com.example.baggios.ui.theme.BaggiosIconSocial
import com.example.baggios.ui.theme.BaggiosTextPrimary
import com.example.baggios.ui.theme.BaggiosTextSecondary

data class SocialLink(
    val platform: String,
    val handle: String,
    val url: String,
    val emoji: String,
    val color: Color
)

@Composable
fun SocialScreen(onBack: () -> Unit) {
    val context = LocalContext.current

    val socialLinks = listOf(
        SocialLink(
            platform = "Instagram",
            handle = "@thebaggios",
            url = "https://instagram.com/thebaggios",
            emoji = "📸",
            color = BaggiosIconSocial
        ),
        SocialLink(
            platform = "YouTube",
            handle = "/thebaggios",
            url = "https://youtube.com/thebaggios",
            emoji = "▶",
            color = BaggiosIconShows
        ),
        SocialLink(
            platform = "Facebook",
            handle = "/thebaggios",
            url = "https://facebook.com/thebaggios",
            emoji = "👥",
            color = BaggiosIconContact
        ),
        SocialLink(
            platform = "Twitter / X",
            handle = "@thebaggios",
            url = "https://twitter.com/thebaggios",
            emoji = "✦",
            color = BaggiosIconRelease
        ),
        SocialLink(
            platform = "Spotify",
            handle = "The Baggios",
            url = "https://open.spotify.com/artist/thebaggios",
            emoji = "🎵",
            color = BaggiosIconRider
        ),
        SocialLink(
            platform = "Deezer",
            handle = "The Baggios",
            url = "https://deezer.com/artist/thebaggios",
            emoji = "🎶",
            color = BaggiosIconDisco
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        SocialHeader(onBack = onBack)

        // Lista de links
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "STREAMING & REDES",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )

            socialLinks.forEach { link ->
                SocialCard(
                    link = link,
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link.url))
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun SocialHeader(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 72.dp, bottom = 16.dp, start = 8.dp, end = 24.dp)
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Voltar",
                tint = BaggiosCyan,
                modifier = Modifier.size(20.dp)
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "siga a banda",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "REDES SOCIAIS",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(2.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(BaggiosCyan)
            )
        }
    }
}

@Composable
fun SocialCard(
    link: SocialLink,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 0.5.dp,
            color = BaggiosBorder
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(link.color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = link.emoji, fontSize = 20.sp)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = link.platform,
                    style = MaterialTheme.typography.titleMedium,
                    color = BaggiosTextPrimary
                )
                Text(
                    text = link.handle,
                    style = MaterialTheme.typography.bodySmall,
                    color = BaggiosTextSecondary
                )
            }
            Text(
                text = "→",
                style = MaterialTheme.typography.titleMedium,
                color = BaggiosCyan
            )
        }
    }
}
