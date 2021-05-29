package com.zhuravlev.foodviewer.repository.banner

import com.zhuravlev.foodviewer.model.Banner

interface UseCaseBanner {
    fun getBanner(): List<Banner>
}