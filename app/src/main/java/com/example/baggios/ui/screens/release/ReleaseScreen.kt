package com.example.baggios.ui.screens.release

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.baggios.ui.theme.BaggiosCyan
import com.example.baggios.ui.theme.BaggiosTextPrimary
import com.example.baggios.ui.theme.BaggiosTextSecondary

@Composable
fun ReleaseScreen(onBack: () -> Unit) {

    val releaseText = """
        The Baggios foi criada em 2004 na cidade de São Cristóvão, Sergipe, pelo guitarrista Julio Andrade, hoje acompanhado por Gabriel Perninha, na bateria, e Rafael Ramos nas teclas.
        
        A banda com mais de 20 anos segue colecionando elogios pelo mundo como uma das mais inventivas da atualidade. Isso se manifesta em suas apresentações viscerais e originalidade nos álbuns. O som do trio traz timbres clássicos e mescla de forma ímpar ritmos do mundo a riffs blueseiros com o peso do rock setentista e a pluralidade da música brasileira.
        
        Com cinco álbuns, quatro EPs e um DVD ao vivo na bagagem, o The Baggios foi indicado ao Grammy Latino duas vezes na categoria "Melhor Álbum de Rock ou Música Alternativa", em 2017 com o álbum "Brutown" e em 2019 com "Vulcão". Ambos os trabalhos marcaram presença nas principais listas de melhores discos pela crítica especializada.
        
        Em 2010, a banda ganhou o Prêmio Nacional da ARPUB (Associação das Rádios Públicas do Brasil) com a música "Em Outras". A música "Sem Condição", do álbum "Sina", foi eleita pela Revista Rolling Stone uma das melhores de 2013.
        
        Em 2016, The Baggios foi uma das atrações do Festival Lollapalooza. Nesses vinte anos de carreira, suas turnês passaram por mais de 50 cidades brasileiras, pelos Estados Unidos, Canadá, México e por várias cidades da Itália, França, Suíça e Inglaterra.
        
        A banda vem se apresentando nos principais festivais do país, como Virada Cultural de São Paulo, Festival Porão do Rock, Porto Musical, Psicodália, Rec Beat e Bananada, além de ter se apresentado em lugares consagrados como Auditório Ibirapuera, Circo Voador e SESC Pompeia.
    """.trimIndent()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header com botão de voltar
        ReleaseHeader(onBack = onBack)

        // Conteúdo rolável
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp)
        ) {
            // Card de destaque — Grammy
            GrammyBadgeCard()

            Spacer(modifier = Modifier.height(24.dp))

            // Texto do release
            Text(
                text = releaseText,
                style = MaterialTheme.typography.bodyLarge,
                color = BaggiosTextPrimary,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun ReleaseHeader(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 72.dp, bottom = 16.dp, start = 8.dp, end = 24.dp)
    ) {
        // Botão voltar
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

        // Título
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "sobre a banda",
                style = MaterialTheme.typography.labelSmall,
                color = BaggiosTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "RELEASE",
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
fun GrammyBadgeCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 0.5.dp,
            color = BaggiosCyan.copy(alpha = 0.4f)
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "🏆", style = MaterialTheme.typography.headlineMedium)
            Column {
                Text(
                    text = "2x Indicado ao Grammy Latino",
                    style = MaterialTheme.typography.titleMedium,
                    color = BaggiosCyan
                )
                Text(
                    text = "Melhor Álbum de Rock ou Música Alternativa · 2017 e 2019",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
