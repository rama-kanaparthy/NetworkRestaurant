package com.rama.networkrestaurant.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
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





