package uz.smd.aliftech.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import uz.smd.aliftech.data.room.AppDatabase
import uz.smd.aliftech.data.room.dao.PostsDao
import uz.smd.aliftech.data.service.ApiService
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun getPostApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}