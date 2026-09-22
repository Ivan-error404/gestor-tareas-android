# Gestor de Tareas — App Android (Kotlin)

Aplicación Android de **gestión de tareas** desarrollada en **Kotlin** con **Jetpack Compose**, **Room** (base de datos local) y Material Design 3, con soporte de **tema claro y oscuro**.

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-03DAC5?style=for-the-badge&logo=jetpackcompose&logoColor=black)

## Características

- **Arquitectura MVVM** con ViewModel y Repository
- **Base de datos Room** con corrutinas (`Flow` reactivo)
- **UI con Jetpack Compose** y Material Design 3
- **Tema claro y oscuro** automático según el sistema
- Crear, marcar como completada y eliminar tareas
- Instrucciones de KSP para Room

## Estructura del proyecto

```
app/src/main/java/com/ivan/gestortareas/
├── data/
│   ├── Tarea.kt            # Entidad Room
│   ├── TareaDao.kt         # Acceso a datos (Flow)
│   ├── TareaDatabase.kt    # Base de datos Room
│   └── TareaRepository.kt  # Capa de repositorio
├── ui/
│   ├── TareaViewModel.kt   # ViewModel (StateFlow)
│   ├── GestorTareasApp.kt  # UI Compose
│   └── theme/Theme.kt      # Tema claro/oscuro
└── MainActivity.kt
```

## Requisitos

- Android Studio Iguana (2023.2.1) o superior
- JDK 17
- Mínimo SDK 24 (Android 7.0)

## Cómo ejecutar

1. Abre el proyecto en **Android Studio**
2. Espera a que Gradle sincronice las dependencias
3. Pulsa **Run ▶** sobre un emulador o dispositivo físico

## Dependencias principales

| Librería              | Versión   | Uso                         |
|-----------------------|-----------|-----------------------------|
| Jetpack Compose       | BOM 2024.09 | UI declarativa            |
| Material 3            | BOM       | Componentes Material       |
| Room                  | 2.6.1     | Base de datos local        |
| Kotlin Coroutines     | 2.0.20    | Flujos reactivos            |