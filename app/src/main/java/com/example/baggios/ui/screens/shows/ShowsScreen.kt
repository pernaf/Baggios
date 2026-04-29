package com.example.baggios.ui.screens.shows

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baggios.ui.theme.BaggiosBorder
import com.example.baggios.ui.theme.BaggiosCyan
import com.example.baggios.ui.theme.BaggiosCyanLight
import com.example.baggios.ui.theme.BaggiosTextPrimary
import com.example.baggios.ui.theme.BaggiosTextSecondary

data class Show(
    val day: String,
    val month: String,
    val year: String,
    val venue: String,
    val city: String,
    val state: String,
    val details: String? = null
)

@Composable
fun ShowsScreen(onBack: () -> Unit) {

    val shows = listOf(
        Show(
            day = "01", month = "MAI", year = "2026",
            venue = "Sextas Autorais no Stones Pub",
            city = "Aracaju", state = "SE"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ShowsHeader(onBack = onBack)

        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                Text(
                    text = "PRÓXIMAS DATAS",
                    style = MaterialTheme.typography.labelSmall,
                    color = BaggiosTextSecondary,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
            }

            items(shows) { show ->
                ShowCard(show = show)
            }
        }
    }
}

@Composable
fun ShowsHeader(onBack: () -> Unit) {
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
                text = "onde nos encontrar",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "AGENDA",
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
fun ShowCard(show: Show) {
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
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Bloco da data
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(BaggiosCyan.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = show.day,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = BaggiosCyan,
                        lineHeight = 24.sp
                    )
                    Text(
                        text = show.month,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = BaggiosCyanLight,
                        letterSpacing = 1.sp
                    )
                }
            }

            // Informações do show
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = show.venue,
                    style = MaterialTheme.typography.titleMedium,
                    color = BaggiosTextPrimary
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${show.city} · ${show.state}",
                    style = MaterialTheme.typography.bodySmall,
                    color = BaggiosTextSecondary
                )
                if (show.details != null) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(BaggiosCyan.copy(alpha = 0.15f))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = show.details,
                            fontSize = 10.sp,
                            color = BaggiosCyan
                        )
                    }
                }
            }

            // Ano
            Text(
                text = show.year,
                style = MaterialTheme.typography.bodySmall,
                color = BaggiosTextSecondary
            )
        }
    }
}

