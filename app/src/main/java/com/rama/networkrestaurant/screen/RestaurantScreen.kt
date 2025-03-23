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
@Composable
fun RestaurantScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Restaurant Image
            Image(
                painter = painterResource(id = R.drawable.placeholder), // Replace with actual image
                contentDescription = "Restaurant Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

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
            onClick = { /* TODO: Implement image loading */ },
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

