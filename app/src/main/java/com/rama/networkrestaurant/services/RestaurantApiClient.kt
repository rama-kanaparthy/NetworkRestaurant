package com.rama.networkrestaurant.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_URL = "http://localhost:8080/"

class RestaurantApiClient {

    companion object {
        private var retrofit: Retrofit? = null

        fun getInstance() : Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!
        }
    }
}