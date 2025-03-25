package com.rama.networkrestaurant.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.integration.compose.GlideImage
import com.example.eatelicious.repositories.RestaurantRepository
import com.rama.networkrestaurant.composes.RestaurantCard
import com.rama.networkrestaurant.models.Restaurant
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RestaurantScreen() {

    val listState = rememberLazyListState()
    val restaurantRepository = remember { RestaurantRepository() }
    val coroutineScope = rememberCoroutineScope()
    var restaurants by remember { mutableStateOf(listOf<Restaurant>()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            restaurants = restaurantRepository.getRestaurants()
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState
    ) {
        restaurants.forEach{ restaurant ->
            item{
                Box(modifier = Modifier.fillMaxWidth()){
                    RestaurantCard(restaurant)
                }
            }
        }

    }

}





