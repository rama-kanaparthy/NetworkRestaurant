package com.rama.networkrestaurant.screen

import com.rama.networkrestaurant.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RestaurantScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        var imageUrl by remember { mutableStateOf<String?>(null) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Restaurant Image
            // Load Image using Glide
            imageUrl?.let { url ->
                GlideImage(
                    model = url,
                    contentDescription = "Restaurant Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                ) {
                    it.diskCacheStrategy(DiskCacheStrategy.ALL) // Caching strategy
                }
            }

            // Restaurant Name
            Text(
                text = "Welcome to Eatelicious!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            )

            // Spacer to push the button to the bottom
            Spacer(modifier = Modifier.weight(1f))
        }

        // Button at Bottom
        Button(
            onClick = {
                imageUrl = "https://images.pexels.com/photos/735869/pexels-photo-735869.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
                      },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Aligns button at the bottom
        ) {
            Text(text = "Display Restaurant", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRestaurantScreen() {
    RestaurantScreen()
}

