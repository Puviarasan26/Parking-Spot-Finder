package com.puvi.mapscomposeguide.presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.puvi.mapscomposeguide.domain.ParkingSpot
import com.puvi.mapscomposeguide.presentation.MapStyle.json

data class MapState(
    val properties: MapProperties = MapProperties(),
    val parkingSpots: List<ParkingSpot> = emptyList(),
    val isFalloutMap: Boolean = false
)
