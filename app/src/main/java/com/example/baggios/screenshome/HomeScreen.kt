package com.example.baggios.screenshome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baggios.navigation.Screen
import com.example.baggios.ui.theme.BaggiosBorder
import com.example.baggios.ui.theme.BaggiosCyan
import com.example.baggios.ui.theme.BaggiosCyanLight
import com.example.baggios.ui.theme.BaggiosIconContact
import com.example.baggios.ui.theme.BaggiosIconDisco
import com.example.baggios.ui.theme.BaggiosIconPhotos
import com.example.baggios.ui.theme.BaggiosIconRelease
import com.example.baggios.ui.theme.BaggiosIconRider
import com.example.baggios.ui.theme.BaggiosIconShows
import com.example.baggios.ui.theme.BaggiosIconSocial
import com.example.baggios.ui.theme.BaggiosTextSecondary

// Modelo de cada card da home
data class HomeMenuItem(
    val title: String,
    val description: String,
    val emoji: String,
    val iconColor: androidx.compose.ui.graphics.Color,
    val route: String,
    val isWide: Boolean = false
)

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {

    val menuItems = listOf(
        HomeMenuItem("Release",       "Bio e textos da banda",       "📄", BaggiosIconRelease,  Screen.Release.route),
        HomeMenuItem("Fotos",         "Galeria de press photos",     "🖼",  BaggiosIconPhotos,   Screen.Photos.route),
        HomeMenuItem("Rider Técnico", "Equipamentos e palco",        "🎛",  BaggiosIconRider,    Screen.Rider.route),
        HomeMenuItem("Discografia",   "5 álbuns · 4 EPs · 1 DVD",   "💿",  BaggiosIconDisco,    Screen.Discography.route),
        HomeMenuItem("Agenda de Shows","Próximas datas e festivais", "🎤",  BaggiosIconShows,    Screen.Shows.route, isWide = true),
        HomeMenuItem("Contatos",      "Booking e assessoria",        "📞",  BaggiosIconContact,  Screen.Contacts.route),
        HomeMenuItem("Redes Sociais", "@thebaggios",                 "🔗",  BaggiosIconSocial,   Screen.Social.route),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        HomeHeader()

        // Grid de cards
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // Label "materiais"
            item(span = { GridItemSpan(2) }) {
                SectionLabel(text = "MATERIAIS")
            }

            // Cards normais (release, fotos, rider, discografia)
            items(menuItems.filter { !it.isWide && it.route != Screen.Contacts.route && it.route != Screen.Social.route }) { item ->
                HomeCard(item = item, onClick = { onNavigate(item.route) })
            }

            // Card largo (shows)
            items(menuItems.filter { it.isWide }) { item ->
                HomeCard(
                    item = item,
                    onClick = { onNavigate(item.route) },
                    modifier = Modifier.wrapContentWidth(),
                    span = true
                )
            }

            // Label "contato & links"
            item(span = { GridItemSpan(2) }) {
                SectionLabel(text = "CONTATO & LINKS")
            }

            // Contatos e Redes Sociais
            items(menuItems.filter { it.route == Screen.Contacts.route || it.route == Screen.Social.route }) { item ->
                HomeCard(item = item, onClick = { onNavigate(item.route) })
            }
        }
    }
}

@Composable
fun HomeHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 72.dp, bottom = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "press kit",
            style = MaterialTheme.typography.labelSmall,
            color = BaggiosTextSecondary
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "THE BAGGIOS",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "SÃO CRISTÓVÃO · SE · DESDE 2004",
            style = MaterialTheme.typography.labelSmall,
            color = BaggiosCyanLight
        )
        Spacer(modifier = Modifier.height(12.dp))
        // Linha ciano decorativa
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(2.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(BaggiosCyan)
        )
    }
}

@Composable
fun SectionLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier.padding(top = 16.dp, bottom = 6.dp)
    )
}

@Composable
fun HomeCard(
    item: HomeMenuItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    span: Boolean = false
) {
    Card(
        modifier = modifier
            .then(if (span) Modifier.fillMaxWidth() else Modifier)
            .clip(RoundedCornerShape(14.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 0.5.dp,
            color = BaggiosBorder
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        if (span) {
            // Layout horizontal para card largo
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CardIcon(emoji = item.emoji, color = item.iconColor)
                Column {
                    Text(text = item.title,       style = MaterialTheme.typography.titleMedium)
                    Text(text = item.description, style = MaterialTheme.typography.bodySmall)
                }
            }
        } else {
            // Layout vertical para card normal
            Column(
                modifier = Modifier.padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CardIcon(emoji = item.emoji, color = item.iconColor)
                Text(text = item.title,       style = MaterialTheme.typography.titleMedium)
                Text(text = item.description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun CardIcon(emoji: String, color: androidx.compose.ui.graphics.Color) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color.copy(alpha = 0.15f)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = emoji, fontSize = 16.sp)
    }
}