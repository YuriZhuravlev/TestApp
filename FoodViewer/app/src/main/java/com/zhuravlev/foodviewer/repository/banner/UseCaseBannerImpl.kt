package com.zhuravlev.foodviewer.repository.banner

import com.zhuravlev.foodviewer.model.Banner
import com.zhuravlev.foodviewer.net.NetworkService
import com.zhuravlev.foodviewer.repository.location.UseCaseLocation

class UseCaseBannerImpl(
    private val useCaseLocation: UseCaseLocation,
    private val networkService: NetworkService
): UseCaseBanner {
    override fun getBanner(): List<Banner> {
        return networkService.getBanners(useCaseLocation.getLocation())
    }
}