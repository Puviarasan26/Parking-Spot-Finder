package com.puvi.mapscomposeguide.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.puvi.mapscomposeguide.domain.ParkingSpotRepository
import com.puvi.mapscomposeguide.presentation.MapStyle.json
import javax.inject.Inject

class MapsViewModel @Inject constructor(private val repository: ParkingSpotRepository) :
    ViewModel() {
    var state by mutableStateOf(MapState())

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.ToggleFalloutMap -> {
                state = state.copy(
                    properties = MapProperties(
                        mapStyleOptions = if (state.isFalloutMap) null else {
                            MapStyleOptions(
                                json
                            )
                        }
                    ),
                    isFalloutMap = !state.isFalloutMap
                )
            }
        }
    }
}