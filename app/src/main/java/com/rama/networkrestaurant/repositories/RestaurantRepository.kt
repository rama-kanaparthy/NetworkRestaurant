package com.example.eatelicious.repositories

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rama.networkrestaurant.models.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class RestaurantRepository {
    private val gson = Gson()

    suspend fun getRestaurants() : List<Restaurant> {
        val apiUrl = "https://random-data-api.com/api/restaurant/random_restaurant?size=12"

        lateinit var restaurants: List<Restaurant>

        withContext(Dispatchers.IO) {
            try {
                val url = URL(apiUrl)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 5000
                connection.readTimeout = 5000

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val streamReader = InputStreamReader(connection.inputStream)
                    val bufferedReader = BufferedReader(streamReader)

                    val stringBuilder = StringBuilder()
                    var line: String?
                    while (bufferedReader.readLine().also { line = it } != null) {
                        stringBuilder.append(line)
                    }
                    val jsonString = stringBuilder.toString()

                    val sType = object : TypeToken<List<Restaurant>>() { }.type

                    // Parse the JSON string into a list of Restaurant objects
                    restaurants = gson.fromJson(jsonString, sType)

                } else {
                    println("Failed to fetch restaurant data: ${connection.responseCode}")
                }
                connection.disconnect()
            } catch (e: Exception) {
                println("Failed to fetch restaurant data: ${e.message}")
            }
        }

        return restaurants
    }
}


