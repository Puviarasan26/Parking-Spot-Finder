package com.puvi.mapscomposeguide.data.mapper

import com.puvi.mapscomposeguide.data.local.ParkingSpotEntity
import com.puvi.mapscomposeguide.domain.ParkingSpot

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot {
    return ParkingSpot(lat = lat, lng = lng, id = id)
}

fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(lat = lat, lng = lng, id = id)
}