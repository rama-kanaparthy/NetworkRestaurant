package com.rama.networkrestaurant.models


import com.google.gson.annotations.SerializedName

data class Restaurant(
    val id: Int,
    val uid: String,
    val name: String,
    val type: String,
    val description: String,
    val review: String,
    val logo: String,

    @SerializedName("phone_number")
    val phoneNumber: String,

    val address: String,
    val hours: Hours
)

data class Hours(
    val monday: Day,
    val tuesday: Day,
    val wednesday: Day,
    val thursday: Day,
    val friday: Day,
    val saturday: Day,
    val sunday: Day
) {

    fun toMap(): Map<String, Day> {
        return mapOf(
            "monday" to monday,
            "tuesday" to tuesday,
            "wednesday" to wednesday,
            "thursday" to thursday,
            "friday" to friday,
            "saturday" to saturday,
            "sunday" to sunday
        )
    }
}

data class Day(
    @SerializedName("opens_at")
    val opensAt: String,

    @SerializedName("closes_at")
    val closesAt: String,

    @SerializedName("is_closed")
    val isClosed: Boolean
)