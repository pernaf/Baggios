package com.example.baggios.ui.screens.rider

import android.content.Context
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
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.example.baggios.ui.theme.BaggiosBorder
import com.example.baggios.ui.theme.BaggiosCyan
import com.example.baggios.ui.theme.BaggiosIconRelease
import com.example.baggios.ui.theme.BaggiosIconRider
import com.example.baggios.ui.theme.BaggiosIconShows
import com.example.baggios.ui.theme.BaggiosTextPrimary
import com.example.baggios.ui.theme.BaggiosTextSecondary
import java.io.File
import java.io.FileOutputStream

data class RiderFile(
    val title: String,
    val description: String,
    val assetName: String,
    val category: String
)

@Composable
fun RiderScreen(onBack: () -> Unit) {
    val context = LocalContext.current

    val riderFiles = listOf(
        RiderFile(
            title = "Rider Técnico",
            description = "Percussão",
            assetName = "rider_percussao.pdf",
            category = "RIDER"
        ),
        RiderFile(
            title = "Rider Técnico",
            description = "Percussão e Metais",
            assetName = "rider_percussao_metais.pdf",
            category = "RIDER"
        ),
        RiderFile(
            title = "Mapa de Palco",
            description = "Percussão",
            assetName = "mapa_palco_percussao.pdf",
            category = "MAPA DE PALCO"
        ),
        RiderFile(
            title = "Mapa de Palco",
            description = "Percussão e Metais",
            assetName = "mapa_palco_metais.pdf",
            category = "MAPA DE PALCO"
        ),
    )

    val riderOnly = riderFiles.filter { it.category == "RIDER" }
    val mapasOnly = riderFiles.filter { it.category == "MAPA DE PALCO" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        RiderHeader(onBack = onBack)

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Aviso importante
            RiderWarningCard()

            Spacer(modifier = Modifier.height(4.dp))

            // Seção Riders
            Text(
                text = "RIDERS TÉCNICOS",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )
            riderOnly.forEach { file ->
                RiderFileCard(
                    file = file,
                    onOpen = { openPdf(context, file.assetName) },
                    onDownload = { downloadPdf(context, file.assetName) }
                )
            }

            // Seção Mapas
            Text(
                text = "MAPAS DE PALCO",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )
            mapasOnly.forEach { file ->
                RiderFileCard(
                    file = file,
                    onOpen = { openPdf(context, file.assetName) },
                    onDownload = { downloadPdf(context, file.assetName) }
                )
            }

            // Contato técnico
            Spacer(modifier = Modifier.height(4.dp))
            RiderContactCard(context = context)
        }
    }
}

@Composable
fun RiderHeader(onBack: () -> Unit) {
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
                text = "informações técnicas",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "RIDER TÉCNICO",
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
fun RiderWarningCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = BaggiosIconShows.copy(alpha = 0.08f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 0.5.dp,
            color = BaggiosIconShows.copy(alpha = 0.4f)
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "⚠️", style = MaterialTheme.typography.titleMedium)
            Column {
                Text(
                    text = "Atenção Contratantes",
                    style = MaterialTheme.typography.titleMedium,
                    color = BaggiosIconShows
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Mudanças no rider só serão aceitas mediante aprovação da produção. Consulte antes de fazer qualquer contratação.",
                    style = MaterialTheme.typography.bodySmall,
                    color = BaggiosTextSecondary
                )
            }
        }
    }
}

@Composable
fun RiderFileCard(
    file: RiderFile,
    onOpen: () -> Unit,
    onDownload: () -> Unit
) {
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
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(BaggiosIconRelease.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.PictureAsPdf,
                    contentDescription = null,
                    tint = BaggiosIconRelease,
                    modifier = Modifier.size(24.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = file.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = BaggiosTextPrimary
                )
                Text(
                    text = file.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = BaggiosTextSecondary
                )
            }

            // Botão abrir
            IconButton(onClick = onOpen) {
                Icon(
                    imageVector = Icons.Filled.PictureAsPdf,
                    contentDescription = "Abrir",
                    tint = BaggiosCyan,
                    modifier = Modifier.size(22.dp)
                )
            }

            // Botão download
            IconButton(onClick = onDownload) {
                Icon(
                    imageVector = Icons.Filled.Download,
                    contentDescription = "Baixar",
                    tint = BaggiosIconRider,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Composable
fun RiderContactCard(context: Context) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 0.5.dp,
            color = BaggiosCyan.copy(alpha = 0.3f)
        ),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "📞", style = MaterialTheme.typography.titleMedium)
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Dúvidas técnicas?",
                    style = MaterialTheme.typography.titleMedium,
                    color = BaggiosCyan
                )
                Text(
                    text = "Entre em contato com a produção",
                    style = MaterialTheme.typography.bodySmall,
                    color = BaggiosTextSecondary
                )
            }
            TextButton(onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:thebaggios@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT, "Rider Técnico - The Baggios")
                }
                context.startActivity(intent)
            }) {
                Text(text = "Email", color = BaggiosCyan)
            }
        }
    }
}

// Abre o PDF com o visualizador padrão do celular
fun openPdf(context: Context, assetName: String) {
    val file = copyAssetToCache(context, assetName)
    val uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        file
    )
    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(uri, "application/pdf")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(intent)
}

// Copia para Downloads e abre com Intent de compartilhamento
fun downloadPdf(context: Context, assetName: String) {
    val file = copyAssetToCache(context, assetName)
    val uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.provider",
        file
    )
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "application/pdf"
        putExtra(Intent.EXTRA_STREAM, uri)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    context.startActivity(Intent.createChooser(intent, "Compartilhar PDF"))
}

// Copia o asset para o cache do app
fun copyAssetToCache(context: Context, assetName: String): File {
    val file = File(context.cacheDir, assetName)
    if (!file.exists()) {
        context.assets.open(assetName).use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }
    }
    return file
}

