# FinanceApp TP3

**FinanceApp TP3** es una aplicación móvil para Android desarrollada por Software ORT TP3, diseñada para facilitar el seguimiento financiero de nuestros clientes. Esta aplicación representa el primer lanzamiento público de la empresa, con el objetivo de digitalizar y potenciar la llegada a miles de usuarios, permitiéndoles coleccionar y gestionar toda su información financiera de manera intuitiva y eficiente.

## 📱 Descripción

FinanceApp TP3 permite a los usuarios registrar y monitorear sus ingresos y egresos, ofreciéndoles una herramienta intuitiva para la gestión de sus finanzas personales o comerciales. Según el perfil configurado, se habilitarán funcionalidades adaptadas a cada necesidad.

### Funcionalidades Principales

**Para usuarios individuales:**

- Registro de ingresos mensuales
- Carga de gastos fijos y variables
- Categorización de movimientos (hogar, transporte, entretenimiento, salud, entre otros)
- Establecimiento de metas de ahorro
- Visualización de reportes dinámicos
- Alertas inteligentes sobre hábitos de consumo

**Otras funcionalidades destacadas:**

- Visualización de estadísticas y gráficos interactivos para entender la evolución financiera
- Búsqueda y filtrado de movimientos por fecha, categoría o monto
- Modo claro/oscuro configurable desde el panel de ajustes
- Sincronización automática con cuentas bancarias o billeteras virtuales (opcional)
- Resumen mensual automatizado con insights personalizados
- Widget resumen en pantalla de inicio con el balance del mes

## 🏗️ Arquitectura

### Tipo de Arquitectura Utilizada

El proyecto utiliza **Clean Architecture** combinada con el patrón **MVVM (Model-View-ViewModel)**. La arquitectura está organizada en las siguientes capas:

#### 1. **Presentation Layer** (`presentation/`)

- **Composables**: Componentes de UI construidos con Jetpack Compose
- **ViewModels**: Manejan la lógica de presentación y exponen el estado a la UI
- **Screens**: Pantallas principales de la aplicación

#### 2. **Domain Layer** (`domain/`)

- **Modelos**: Entidades de negocio (ej: `Response`)
- **Repositorios (Interfaces)**: Contratos que definen las operaciones de datos (estructura base preparada para futuras implementaciones)
- Lógica de negocio pura, independiente de frameworks

#### 3. **Data Layer** (`data/`)

- **DAO**: Data Access Objects para Room Database (estructura base preparada)
- **Repositorios (Implementaciones)**: Implementaciones concretas de los repositorios (estructura base preparada)
- **Database**: Configuración de Room Database (estructura base preparada)

#### 4. **DI Layer** (`di/`)

- **Módulos Hilt**: Configuración de inyección de dependencias

### ¿Por qué esta arquitectura?

1. **Separación de responsabilidades**: Cada capa tiene una responsabilidad clara y bien definida
2. **Escalabilidad**: Permite agregar nuevas funcionalidades sin afectar otras partes del código
3. **Mantenibilidad**: Facilita el mantenimiento y la evolución del código
4. **Independencia de frameworks**: La capa de dominio es independiente de Android, lo que permite reutilizar lógica

### ¿Podría mejorarse?

**Sí, se podrían implementar las siguientes mejoras:**

1. **Use Cases (Interactores)**: Agregar una capa de casos de uso entre ViewModel y Repository para encapsular la lógica de negocio específica
2. **Mappers**: Implementar mappers dedicados para convertir entre modelos de dominio y modelos de datos
3. **Result Wrapper**: Mejorar el manejo de `Response` usando un tipo `Result` más robusto con mejor tipado
4. **Repository Pattern mejorado**: Implementar repositorios que manejen múltiples fuentes de datos (Room + API remota) con estrategia de cache

## 🔄 Objetos Stateful y Stateless

### Objetos Stateful

Los objetos **stateful** mantienen y gestionan estado mutable. En el proyecto encontramos:

1. **Composables Stateful**:
   - `HomeScreen`: Gestiona `selectedPeriod` con `remember { mutableStateOf(Period.Monthly) }` para controlar el período seleccionado (mensual/semanal)
   - Mantiene estado local de transacciones de ejemplo con `remember { listOf(...) }`
   - Componentes que manejan estado de UI como diálogos, formularios o selecciones

### Objetos Stateless

Los objetos **stateless** no mantienen estado interno y son funciones puras. En el proyecto encontramos:

1. **Composables de Presentación Pura**:

   - `TransactionItem`: Solo recibe datos y los muestra, no mantiene estado
   - `BalanceSection`, `GreetingSection`: Componentes que solo muestran datos
   - `SavingsProgressBar`: Componente de presentación que recibe props
   - `WeeklySummarySection`: Muestra información sin estado interno
   - `ActionButton`: Componente reutilizable sin estado

2. **Utilidades**:
   - Funciones helper en `Utils.kt` son stateless

### Criterios para la Elección

**Stateful cuando:**

- Se necesita mantener estado entre recomposiciones
- El estado es específico de un componente y no necesita ser compartido
- Se requiere gestionar estado de UI (diálogos, formularios)
- Se necesita estado derivado de múltiples fuentes

**Stateless cuando:**

- El componente solo muestra datos (presentación)
- El componente es reutilizable y no necesita estado propio
- El estado se puede elevar a un componente padre o ViewModel
- Se busca mejorar la testabilidad y reutilización

## 🔧 Mejoras Detectadas

### 1. Falta de Implementación de ViewModels

**Problema identificado:**
Las pantallas principales (HomeScreen, AnalyticsScreen, SwapScreen, etc.) no tienen ViewModels asociados. El estado se maneja localmente en los composables, lo que dificulta la gestión de estado complejo y la persistencia durante cambios de configuración.

**Refactorización sugerida:**

- Crear ViewModels para cada pantalla principal
- Mover la lógica de negocio fuera de los composables
- Usar StateFlow para exponer el estado a la UI
- Implementar repositorios para manejar datos de transacciones

### 2. Datos Hardcodeados en la UI

**Problema identificado:**
En `HomeScreen`, las transacciones están hardcodeadas como datos de ejemplo. No hay conexión con una fuente de datos real (base de datos, API, etc.).

**Refactorización sugerida:**

- Implementar modelos de dominio para Transaction
- Crear DAO y entidades Room para persistir transacciones
- Implementar repositorios para manejar operaciones CRUD
- Conectar ViewModels con repositorios para obtener datos reales

### 3. Mezcla de Idiomas en el Código

**Problema identificado:**
El código tiene comentarios y strings mezclados entre español e inglés (ej: "Pantalla de Layers", "Inicio" en Screen.kt, pero el código está en inglés).

**Refactorización sugerida:**

- Estandarizar todo el código a inglés
- Usar recursos de strings para todos los textos visibles
- Implementar internacionalización (i18n) desde el inicio

### 4. Pantallas Placeholder Sin Funcionalidad

**Problema identificado:**
Varias pantallas (AnalyticsScreen, SwapScreen, LayersScreen, ProfileScreen, SettingsScreen) están implementadas solo como placeholders con texto, sin funcionalidad real.

**Refactorización sugerida:**

- Implementar la funcionalidad completa de cada pantalla según los requisitos
- Conectar con ViewModels y repositorios correspondientes
- Agregar componentes de UI necesarios para cada funcionalidad

## 🛡️ Manejo de Errores

### Estrategia Actual

El proyecto utiliza un `sealed class Response<T>` para manejar estados:

```kotlin
sealed class Response<out T> {
    data object Idle : Response<Nothing>()
    data object Loading : Response<Nothing>()
    data class Success<out T>(val data: T) : Response<T>()
    data class Failure(val e: Exception) : Response<Nothing>()
}
```

### Problemas Detectados

1. **Falta de manejo de errores**: Actualmente no hay implementación de manejo de errores en las pantallas principales
2. **Mensajes de error genéricos**: No hay estrategia definida para mostrar mensajes de error al usuario
3. **Falta de categorización**: No se distinguen tipos de errores (red, base de datos, validación)

### Estrategia Recomendada

#### 1. Crear Jerarquía de Errores

```kotlin
sealed class AppError : Exception() {
    data class NetworkError(val message: String) : AppError()
    data class DatabaseError(val message: String) : AppError()
    data class ValidationError(val field: String, val message: String) : AppError()
    data class UnknownError(val throwable: Throwable) : AppError()
}
```

#### 2. Mapper de Errores

```kotlin
object ErrorMapper {
    fun map(throwable: Throwable): AppError {
        return when (throwable) {
            is SQLiteException -> AppError.DatabaseError("Error de base de datos")
            is IOException -> AppError.NetworkError("Error de conexión")
            is IllegalArgumentException -> AppError.ValidationError("", throwable.message ?: "")
            else -> AppError.UnknownError(throwable)
        }
    }

    fun getMessage(error: AppError, context: Context): String {
        return when (error) {
            is AppError.NetworkError -> context.getString(R.string.error_network)
            is AppError.DatabaseError -> context.getString(R.string.error_database)
            is AppError.ValidationError -> error.message
            is AppError.UnknownError -> context.getString(R.string.error_unknown)
        }
    }
}
```

#### 3. Dónde Implementar el Manejo de Errores

**Repositorio (Data Layer):**

```kotlin
override suspend fun insertTransaction(transaction: Transaction): Result<Unit> {
    return try {
        transactionDao.insertTransaction(transaction)
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(ErrorMapper.map(e))
    }
}
```

**ViewModel (Presentation Layer):**

```kotlin
fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
    _transactionState.value = Response.Loading
    when (val result = repo.insertTransaction(transaction)) {
        is Result.Success -> {
            _transactionState.value = Response.Success(Unit)
        }
        is Result.Failure -> {
            _transactionState.value = Response.Failure(result.error)
        }
    }
}
```

**UI (Composable):**

```kotlin
is Response.Failure -> {
    val errorMessage = ErrorMapper.getMessage(error, context)
    LaunchedEffect(errorMessage) {
        showSnackbarMessage(coroutineScope, snackbarHostState, errorMessage)
    }
}
```

### Estrategia de Mapeo Recomendada

**Result Wrapper Pattern** es la más adecuada para este proyecto:

```kotlin
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val error: AppError) : Result<Nothing>()

    inline fun <R> map(transform: (T) -> R): Result<R> = when (this) {
        is Success -> Success(transform(data))
        is Failure -> this
    }
}
```

Ventajas:

- Type-safe: Compilador garantiza manejo de todos los casos
- Composable: Permite encadenar operaciones
- Integración con Kotlin Flow: Compatible con `Flow<Result<T>>`

## 🌐 Internacionalización (i18n)

### Estrategia para Español e Inglés

#### 1. Estructura de Recursos

Crear carpetas de recursos por idioma:

```
app/src/main/res/
├── values/           # Inglés (default)
│   └── strings.xml
├── values-es/        # Español
│   └── strings.xml
└── values-en/        # Inglés explícito (opcional)
    └── strings.xml
```

#### 2. Archivo de Strings Base (values/strings.xml)

```xml
<resources>
    <string name="app_name">FinanceApp</string>
    <string name="home_screen_title">Home</string>
    <string name="balance_label">Balance</string>
    <string name="error_network">Network error. Please try again.</string>
</resources>
```

#### 3. Archivo de Strings en Español (values-es/strings.xml)

```xml
<resources>
    <string name="app_name">FinanceApp</string>
    <string name="home_screen_title">Inicio</string>
    <string name="balance_label">Balance</string>
    <string name="error_network">Error de red. Por favor, intente nuevamente.</string>
</resources>
```

#### 4. Uso en el Código

```kotlin
// En lugar de strings hardcodeados
Text(text = "Inicio")  // ❌

// Usar recursos
Text(text = stringResource(R.string.home_screen_title))  // ✅
```

#### 5. Configuración en build.gradle.kts

```kotlin
android {
    defaultConfig {
        resConfigs("en", "es")  // Solo incluir estos idiomas en el APK
    }
}
```

### Estrategia para Múltiples Idiomas

#### 1. Agregar Nuevos Idiomas

Crear carpetas adicionales:

```
app/src/main/res/
├── values/           # Inglés (default)
├── values-es/        # Español
├── values-pt/        # Portugués
├── values-fr/        # Francés
└── values-de/        # Alemán
```

#### 2. Usar Localización Dinámica

```kotlin
// En MainActivity o Application
val configuration = Configuration(context.resources.configuration)
configuration.setLocale(Locale("es", "ES"))
context = context.createConfigurationContext(configuration)
```

#### 3. Permite Cambio de Idioma en Runtime

```kotlin
class LocaleManager(private val context: Context) {
    fun setLocale(locale: Locale) {
        val config = context.resources.configuration
        val localeMetrics = DisplayMetrics()
        context.resources.displayMetrics.getMetrics(localeMetrics)
        config.setLocale(locale)
        context.resources.updateConfiguration(config, localeMetrics)

        // Guardar preferencia
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("language", locale.language).apply()
    }

    fun getLocale(): Locale {
        val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val language = prefs.getString("language", "en") ?: "en"
        return Locale(language)
    }
}
```

#### 4. Extension para Strings

```kotlin
@Composable
fun stringResource(@StringRes id: Int, vararg formatArgs: Any): String {
    return LocalContext.current.resources.getString(id, *formatArgs)
}
```

#### 5. Mejores Prácticas

- **Usar placeholders**: `%1$s`, `%2$d` para strings parametrizados
- **Evitar concatenación**: No concatenar strings en código
- **Plurales**: Usar `<plurals>` para manejar singular/plural
- **Formato de fechas/números**: Usar `DateFormat` y `NumberFormat` con locale

```xml
<!-- Ejemplo de plurales -->
<plurals name="transaction_count">
    <item quantity="one">%d transacción</item>
    <item quantity="other">%d transacciones</item>
</plurals>
```

## 🛠️ Tecnologías Utilizadas

### Core

- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: Framework de UI moderno
- **Material Design 3**: Sistema de diseño

### Arquitectura

- **MVVM (Model-View-ViewModel)**: Patrón de arquitectura
- **Clean Architecture**: Separación en capas
- **Android Architecture Components**: ViewModel, LiveData/Flow

### Dependency Injection

- **Hilt**: Framework de inyección de dependencias para Android

### Base de Datos

- **Room**: Biblioteca de persistencia de datos (estructura base preparada para futuras implementaciones)
- **Kotlin Flow**: Flujos reactivos para datos

### Asynchronous Programming

- **Kotlin Coroutines**: Programación asíncrona
- **StateFlow / Flow**: Flujos de estado reactivos

### Navigation

- **Navigation Compose**: Navegación entre pantallas
- **Hilt Navigation Compose**: Integración con Hilt

## 📁 Estructura del Proyecto

```
app/src/main/java/ro/alexmamo/roomjetpackcompose/
├── components/          # Componentes reutilizables
├── core/               # Utilidades y constantes
├── data/               # Capa de datos
│   ├── dao/           # Data Access Objects
│   ├── network/       # Base de datos Room
│   └── repository/    # Implementaciones de repositorios
├── di/                 # Módulos de inyección de dependencias
├── domain/             # Capa de dominio
│   ├── model/         # Modelos de negocio
│   └── repository/    # Interfaces de repositorios
├── navigation/         # Configuración de navegación
├── presentation/       # Capa de presentación
│   ├── analytics/
│   ├── home/
│   ├── layers/
│   ├── profile/
│   ├── settings/
│   └── swap/
└── ui/                 # Temas y estilos
    └── theme/
```

## 🚀 Configuración e Instalación

### Requisitos Previos

- Android Studio Hedgehog | 2023.1.1 o superior
- JDK 21
- Android SDK 21 (Android 5.0) o superior
- Gradle 8.0+

### Instalación

1. Clonar el repositorio:

```bash
git clone [repository-url]
cd TodoList_Grupo9
```

2. Abrir el proyecto en Android Studio

3. Sincronizar dependencias de Gradle

4. Ejecutar la aplicación en un emulador o dispositivo físico

## 📝 Licencia

Este proyecto está siendo desarrollado por Software ORT TP3 para fines educativos y comerciales.

---

**FinanceApp TP3** - Transformando la gestión financiera personal, permitiendo a los usuarios tener control total sobre sus finanzas, tomar mejores decisiones y construir hábitos económicos saludables desde una única plataforma simple y personalizada.
