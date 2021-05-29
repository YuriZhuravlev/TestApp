package com.zhuravlev.foodviewer.di

import android.content.Context
import androidx.room.Room
import com.zhuravlev.foodviewer.database.Database
import com.zhuravlev.foodviewer.database.DishDAO
import com.zhuravlev.foodviewer.database.LocationDAO
import com.zhuravlev.foodviewer.model.CategoryConverter
import com.zhuravlev.foodviewer.net.MockNetworkService
import com.zhuravlev.foodviewer.net.NetworkService
import com.zhuravlev.foodviewer.repository.banner.UseCaseBanner
import com.zhuravlev.foodviewer.repository.banner.UseCaseBannerImpl
import com.zhuravlev.foodviewer.repository.category.UseCaseCategories
import com.zhuravlev.foodviewer.repository.category.UseCaseCategoriesImpl
import com.zhuravlev.foodviewer.repository.dish.UseCaseDishes
import com.zhuravlev.foodviewer.repository.dish.UseCaseDishesImpl
import com.zhuravlev.foodviewer.repository.location.UseCaseLocation
import com.zhuravlev.foodviewer.repository.location.UseCaseLocationImpl
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
    ).build()

    @Singleton
    @Provides
    fun provideDishDAO(db: Database): DishDAO = db.getDishDAO()


    @Singleton
    @Provides
    fun provideLocationDAO(db: Database): LocationDAO = db.getLocationDAO()

    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService = MockNetworkService()

    @Provides
    fun provideUseCaseLocation(
        dishDAO: DishDAO,
        locationDAO: LocationDAO,
        networkService: NetworkService
    ): UseCaseLocation = UseCaseLocationImpl(dishDAO, locationDAO, networkService)

    @Provides
    fun provideUseCaseCategories(
        dishDAO: DishDAO,
        useCaseLocation: UseCaseLocation,
        networkService: NetworkService
    ): UseCaseCategories = UseCaseCategoriesImpl(dishDAO, useCaseLocation, networkService)

    @Provides
    fun provideUseCaseDishes(
        dishDAO: DishDAO,
        useCaseLocation: UseCaseLocation,
        networkService: NetworkService
    ): UseCaseDishes = UseCaseDishesImpl(dishDAO, useCaseLocation, networkService)

    @Provides
    fun provideUseCaseBanner(
        useCaseLocation: UseCaseLocation,
        networkService: NetworkService
    ): UseCaseBanner = UseCaseBannerImpl(useCaseLocation, networkService)
}