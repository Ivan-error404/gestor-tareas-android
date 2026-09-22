package com.ivan.gestortareas

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivan.gestortareas.ui.GestorTareasApp
import com.ivan.gestortareas.ui.TareaViewModel
import com.ivan.gestortareas.ui.theme.GestorTareasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GestorTareasTheme {
                GestorTareasScreen()
            }
        }
    }
}

@Composable
fun GestorTareasScreen(
    viewModel: TareaViewModel = viewModel(
        factory = TareaViewModel.Factory(
            LocalContext.current.applicationContext as Application
        )
    )
) {
    GestorTareasApp(viewModel)
}
