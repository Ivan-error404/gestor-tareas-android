package com.ivan.gestortareas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val MoradoPrimario = Color(0xFF6750A4)
val MoradoClaro = Color(0xFFEADDFF)
val MoradoOscuro = Color(0xFF21005D)
val AzulSecundario = Color(0xFF625B71)

private val EsquemaClaro = lightColorScheme(
    primary = MoradoPrimario,
    onPrimary = Color.White,
    secondary = AzulSecundario,
    background = Color(0xFFFEF7FF)
)

private val EsquemaOscuro = darkColorScheme(
    primary = MoradoClaro,
    onPrimary = MoradoOscuro,
    secondary = Color.White,
    background = Color(0xFF1C1B1F)
)

@Composable
fun GestorTareasTheme(
    oscuro: Boolean = isSystemInDarkTheme(),
    contenido: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (oscuro) EsquemaOscuro else EsquemaClaro,
        content = contenido
    )
}
