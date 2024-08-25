package com.puvi.mapscomposeguide.data.repository

import com.puvi.mapscomposeguide.data.local.ParkingSpotDao
import com.puvi.mapscomposeguide.data.mapper.toParkingSpot
import com.puvi.mapscomposeguide.data.mapper.toParkingSpotEntity
import com.puvi.mapscomposeguide.domain.ParkingSpot
import com.puvi.mapscomposeguide.domain.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class ParkingSpotRepositoryImpl(private val dao: ParkingSpotDao) : ParkingSpotRepository {
    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        dao.insertParkingSpot(spot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        dao.deleteParkingSpot(spot.toParkingSpotEntity())
    }

    override fun getParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.getParkingSpots().map { spots ->
            spots.map { it.toParkingSpot() }
        }
    }
}