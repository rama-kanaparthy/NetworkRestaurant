package com.rama.networkrestaurant.composes

import com.rama.networkrestaurant.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rama.networkrestaurant.models.Restaurant
import com.rama.networkrestaurant.ui.theme.Purple80

private val imageUrls = arrayOf(
    "https://images.pexels.com/photos/735869/pexels-photo-735869.jpeg",
    "https://images.pexels.com/photos/1618873/pexels-photo-1618873.jpeg",
    "https://images.pexels.com/photos/2762942/pexels-photo-2762942.jpeg",
    "https://images.pexels.com/photos/7937/pexels-photo-7937.jpeg",
    "https://images.pexels.com/photos/4559174/pexels-photo-4559174.jpeg",
    "https://images.pexels.com/photos/7780260/pexels-photo-7780260.jpeg",
    "https://images.pexels.com/photos/265947/pexels-photo-265947.jpeg",
    "https://images.pexels.com/photos/698907/pexels-photo-698907.jpeg",
    "https://images.pexels.com/photos/2696064/pexels-photo-2696064.jpeg",
    "https://images.pexels.com/photos/1395967/pexels-photo-1395967.jpeg"
)

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RestaurantCard(restaurant: Restaurant){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = CutCornerShape(
            20.dp
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Row(modifier = Modifier.padding(8.dp)) {

            GlideImage(
                model = imageUrls.random(),
                contentDescription = "Restaurant Image",
                modifier = Modifier.size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        shape = CircleShape,
                        color = Purple80
                    ),
                contentScale = ContentScale.Crop,
            ) {
                it.placeholder(R.drawable.placeholder) // ✅ Shows while loading
                    .error(R.drawable.error) // ✅ Shows on failure
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // ✅ Enables caching
            }

            Spacer(Modifier.padding(8.dp))

            Column {
                Text(
                    restaurant.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 8.dp, start =8.dp, bottom = 2.dp , end = 8.dp)
                )

                Spacer(Modifier.padding(4.dp))

                Text(
                    restaurant.type,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = 2.dp, start =8.dp, bottom = 8.dp , end = 8.dp)
                )
            }
        }
    }
}