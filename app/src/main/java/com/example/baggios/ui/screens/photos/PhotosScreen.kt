package com.example.baggios.ui.screens.photos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.baggios.ui.theme.*

data class BandPhoto(
    val resId: Int,
    val caption: String,
    val category: String
)

@Composable
fun PhotosScreen(onBack: () -> Unit) {

    val photos = listOf(
        BandPhoto(
            resId = com.example.baggios.R.drawable.photo_press_1,
            caption = "Press Photo 2024",
            category = "PRESS PHOTOS"
        ),
        BandPhoto(
            resId = com.example.baggios.R.drawable.photo_press_2,
            caption = "Press Photo 2024",
            category = "PRESS PHOTOS"
        ),
        BandPhoto(
            resId = com.example.baggios.R.drawable.photo_press_3,
            caption = "Press Photo 2024",
            category = "PRESS PHOTOS"
        ),
        BandPhoto(
            resId = com.example.baggios.R.drawable.photo_press_4,
            caption = "Press Photo 2024",
            category = "PRESS PHOTOS"
        ),
        BandPhoto(
            resId = com.example.baggios.R.drawable.photo_show_1,
            caption = "FASC 2018 · São Cristóvão",
            category = "SHOWS"
        ),
    )

    var selectedPhoto by remember { mutableStateOf<BandPhoto?>(null) }

    val pressPhotos = photos.filter { it.category == "PRESS PHOTOS" }
    val showPhotos  = photos.filter { it.category == "SHOWS" }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            PhotosHeader(onBack = onBack)

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                // Label Press Photos
                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = "PRESS PHOTOS",
                        style = MaterialTheme.typography.labelSmall,
                        color = BaggiosTextSecondary,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                }

                items(pressPhotos) { photo ->
                    PhotoThumbnail(
                        photo = photo,
                        onClick = { selectedPhoto = photo }
                    )
                }

                // Label Shows
                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = "SHOWS",
                        style = MaterialTheme.typography.labelSmall,
                        color = BaggiosTextSecondary,
                        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                    )
                }

                items(showPhotos) { photo ->
                    PhotoThumbnail(
                        photo = photo,
                        onClick = { selectedPhoto = photo }
                    )
                }
            }
        }

        // Visualizador fullscreen
        selectedPhoto?.let { photo ->
            PhotoFullScreen(
                photo = photo,
                onClose = { selectedPhoto = null }
            )
        }
    }
}

@Composable
fun PhotosHeader(onBack: () -> Unit) {
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
                text = "galeria",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "FOTOS",
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
fun PhotoThumbnail(
    photo: BandPhoto,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = photo.resId,
            contentDescription = photo.caption,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Gradiente sutil no rodapé
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))
                    )
                )
        )
    }
}

@Composable
fun PhotoFullScreen(
    photo: BandPhoto,
    onClose: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .clickable { onClose() }
    ) {
        AsyncImage(
            model = photo.resId,
            contentDescription = photo.caption,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )

        // Botão fechar
        IconButton(
            onClick = onClose,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 48.dp, end = 16.dp)
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black.copy(alpha = 0.5f))
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Fechar",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

        // Caption
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(16.dp)
        ) {
            Text(
                text = photo.caption,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
    }
}

