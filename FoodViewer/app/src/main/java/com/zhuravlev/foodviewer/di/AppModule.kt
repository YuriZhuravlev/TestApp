package com.zhuravlev.foodviewer.di

import android.content.Context
import androidx.room.Room
import com.zhuravlev.foodviewer.database.Database
import com.zhuravlev.foodviewer.database.DishDAO
import com.zhuravlev.foodviewer.database.LocationDAO
import com.zhuravlev.foodviewer.model.CategoryConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): Database = Room.databaseBuilder(
        context,
        Database::class.java,
        "food_db"
    ).addTypeConverter(CategoryConverter)
        .build()

    @Singleton
    @Provides
    fun provideDishDAO(db: Database): DishDAO = db.getDishDAO()


    @Singleton
    @Provides
    fun provideLocationDAO(db: Database): LocationDAO = db.getLocationDAO()
}