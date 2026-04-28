package com.example.baggios.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val BaggiosTypography = Typography(
    // Títulos de tela (ex: "RELEASE", "DISCOGRAFIA")
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        letterSpacing = 2.sp,
        color = BaggiosWhite
    ),
    // Subtítulos e nomes de seção
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        letterSpacing = 1.sp,
        color = BaggiosTextPrimary
    ),
    // Títulos dos cards
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        color = BaggiosTextPrimary
    ),
    // Corpo de texto (release, bio)
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        color = BaggiosTextPrimary
    ),
    // Descrições menores
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = 0.5.sp,
        color = BaggiosTextSecondary
    ),
    // Labels (ex: "MATERIAIS", "CONTATO")
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        letterSpacing = 3.sp,
        color = BaggiosTextSecondary
    )
)