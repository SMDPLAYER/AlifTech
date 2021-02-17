package uz.smd.aliftech.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.smd.aliftech.data.entities.MarsProperty
import uz.smd.aliftech.data.room.dao.PostsDao

@Database(entities = [MarsProperty::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPostsDao(): PostsDao


    companion object {
        @Volatile
       lateinit  var INSTANCE: AppDatabase

        fun init(context: Context): AppDatabase {
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}