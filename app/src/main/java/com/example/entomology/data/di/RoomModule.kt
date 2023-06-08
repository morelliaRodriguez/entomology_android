package com.example.entomology.data.di

import android.content.Context
import androidx.room.Room
import com.example.entomology.data.local.database.EntomologyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val INSECT_DATABASE_NAME = "pokedex_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, EntomologyDataBase::class.java, INSECT_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideInsectDao(db:EntomologyDataBase) = db.getInsectDao()

    @Singleton
    @Provides
    fun provideCountInsectDao(db:EntomologyDataBase) = db.getCountInsectDao()
}