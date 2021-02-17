package uz.smd.aliftech.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.smd.aliftech.data.room.AppDatabase
import uz.smd.aliftech.data.room.dao.PostsDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): AppDatabase = AppDatabase.INSTANCE

    @Provides
    @Singleton
    fun getPostsDao(database: AppDatabase): PostsDao = database.getPostsDao()

}