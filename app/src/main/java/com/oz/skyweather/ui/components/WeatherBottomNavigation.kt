package com.oz.skyweather.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.oz.skyweather.R
import com.oz.skyweather.ui.theme.SkyWeatherTheme

sealed class Screen(
    val route: String,
    @StringRes val stringRes: Int,
    @DrawableRes val iconRes: Int,
){
    object Home: Screen("home", R.string.nav_home, R.drawable.ic_round_home)
    object Calendar: Screen("calendar", R.string.nav_calendar, R.drawable.ic_calendar_month)
    object Settings: Screen("settings", R.string.nav_settings, R.drawable.ic_round_settings)
}

val screens = listOf(
    Screen.Home,
    Screen.Calendar,
    Screen.Settings
)

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) = BottomNavigation(modifier) {
    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colors.onSurface) {
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = screen == Screen.Home,
                onClick = { },
                icon = { Icon(painterResource(id = screen.iconRes), contentDescription = null) },
                label = { Text(stringResource(id = screen.stringRes)) },
                unselectedContentColor = Color.LightGray,
                alwaysShowLabel = false
            )
        }
    }
}

@Preview
@Composable
fun NavigationPreview(){
    SkyWeatherTheme {
        Navigation()
    }
}

@Preview
@Composable
fun NavigationPreviewDark(){
    SkyWeatherTheme(darkTheme = true) {
        Navigation()
    }
}