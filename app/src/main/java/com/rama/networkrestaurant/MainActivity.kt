package com.rama.networkrestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.rama.networkrestaurant.screen.RestaurantScreen
import com.rama.networkrestaurant.ui.theme.NetworkRestaurantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetworkRestaurantTheme {
                MainScreen()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Image Loading with Glide", color = Color.Black)
                },
                colors = smallTopAppBarColors(
                    containerColor = Color.Yellow // Change this to your desired color
                )
            )
        }
    ) { paddingValues ->
        ContentMain(paddingValues)
    }
}

@Composable
fun ContentMain(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),

    ){
        RestaurantScreen()
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
