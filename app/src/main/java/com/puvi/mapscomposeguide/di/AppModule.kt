package com.puvi.mapscomposeguide.di

import android.app.Application
import androidx.room.Room
import com.puvi.mapscomposeguide.data.local.ParkingSpotDatabase
import com.puvi.mapscomposeguide.data.repository.ParkingSpotRepositoryImpl
import com.puvi.mapscomposeguide.domain.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesParkingSpotDatabase(app: Application): ParkingSpotDatabase {
        return Room.databaseBuilder(
            app,
            ParkingSpotDatabase::class.java,
            "parking_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun providesParkingSpotRepository(db: ParkingSpotDatabase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(db.dao)
    }
}