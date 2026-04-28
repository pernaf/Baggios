package com.example.baggios.ui.screens.discography

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.baggios.ui.theme.BaggiosBorder
import com.example.baggios.ui.theme.BaggiosCyan
import com.example.baggios.ui.theme.BaggiosTextPrimary
import com.example.baggios.ui.theme.BaggiosTextSecondary

data class Album(
    val title: String,
    val year: String,
    val type: AlbumType,
    val coverRes: Int,
    val highlight: String? = null,
    val tracks: List<String> = emptyList()
)

enum class AlbumType(val label: String) {
    ALBUM("Álbum"),
    EP("EP"),
    DVD("DVD ao Vivo")
}

@Composable
fun DiscographyScreen(onBack: () -> Unit) {

    val albums = listOf(
        Album(
            title = "Tupã-Rá",
            year = "2021",
            type = AlbumType.ALBUM,
            coverRes = com.example.baggios.R.drawable.album_tupara,
            tracks = listOf("Tupã-Rá", "Baião do Fim do Mundo", "Jurema", "Xangô")
        ),
        Album(
            title = "Vulcão",
            year = "2018",
            type = AlbumType.ALBUM,
            coverRes = com.example.baggios.R.drawable.album_vulcao,
            highlight = "Indicado ao Grammy Latino",
            tracks = listOf("Vulcão", "Juliana", "Fogo", "Raiz")
        ),
        Album(
            title = "Brutown",
            year = "2016",
            type = AlbumType.ALBUM,
            coverRes = com.example.baggios.R.drawable.album_brutown,
            highlight = "Indicado ao Grammy Latino",
            tracks = listOf("Brutown", "Sem Luz", "Pesadelo", "Cidade")
        ),
        Album(
            title = "Sina",
            year = "2013",
            type = AlbumType.ALBUM,
            coverRes = com.example.baggios.R.drawable.album_sina,
            tracks = listOf("Sem Condição", "Sina", "Estrada", "Mar")
        ),
        Album(
            title = "The Baggios",
            year = "2011",
            type = AlbumType.ALBUM,
            coverRes = com.example.baggios.R.drawable.album_the_baggios,
            tracks = listOf("Em Outras", "Baggios", "Blues do Norte", "Sertão")
        ),
        Album(
            title = "10 Anos Depois",
            year = "2014",
            type = AlbumType.DVD,
            coverRes = com.example.baggios.R.drawable.album_10_anos_depois,
        ),
        Album(
            title = "Juliana",
            year = "2018",
            type = AlbumType.EP,
            coverRes = com.example.baggios.R.drawable.ep_juliana,
        ),
        Album(
            title = "Acústico Aperipê",
            year = "2014",
            type = AlbumType.EP,
            coverRes = com.example.baggios.R.drawable.ep_acustico_areripe,
        ),
        Album(
            title = "Hard Times",
            year = "2009",
            type = AlbumType.EP,
            coverRes = com.example.baggios.R.drawable.ep_hard_times,
        ),
        Album(
            title = "EP Demo",
            year = "2006",
            type = AlbumType.EP,
            coverRes = com.example.baggios.R.drawable.ep_demo,
        ),
    )

    val albumsOnly = albums.filter { it.type == AlbumType.ALBUM }
    val epsAndDvd  = albums.filter { it.type != AlbumType.ALBUM }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        DiscographyHeader(onBack = onBack)

        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                Text(
                    text = "ÁLBUNS DE ESTÚDIO",
                    style = MaterialTheme.typography.labelSmall,
                    color = BaggiosTextSecondary,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
            }
            items(albumsOnly) { album ->
                AlbumCard(album = album)
            }

            item {
                Text(
                    text = "EPs & DVD",
                    style = MaterialTheme.typography.labelSmall,
                    color = BaggiosTextSecondary,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                )
            }
            items(epsAndDvd) { album ->
                AlbumCard(album = album)
            }
        }
    }
}

@Composable
fun DiscographyHeader(onBack: () -> Unit) {
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
                text = "obras da banda",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "DISCOGRAFIA",
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
fun AlbumCard(album: Album) {
    Card(
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
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Capa do álbum
            AsyncImage(
                model = album.coverRes,
                contentDescription = "Capa de ${album.title}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            // Informações
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = album.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = BaggiosTextPrimary
                    )
                    if (album.type != AlbumType.ALBUM) {
                        AlbumTypeBadge(type = album.type)
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = album.year,
                    style = MaterialTheme.typography.bodySmall,
                    color = BaggiosTextSecondary
                )

                if (album.highlight != null) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "🏆 ${album.highlight}",
                        style = MaterialTheme.typography.bodySmall,
                        color = BaggiosCyan
                    )
                }

                if (album.tracks.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = album.tracks.joinToString(" · "),
                        style = MaterialTheme.typography.bodySmall,
                        color = BaggiosTextSecondary
                    )
                }
            }
        }
    }
}

@Composable
fun AlbumTypeBadge(type: AlbumType) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(BaggiosCyan.copy(alpha = 0.15f))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = type.label,
            style = MaterialTheme.typography.bodySmall,
            color = BaggiosCyan,
            fontSize = 9.sp
        )
    }
}