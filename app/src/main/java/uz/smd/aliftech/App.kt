package uz.smd.aliftech

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.smd.aliftech.data.room.AppDatabase

/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */
@HiltAndroidApp
class App:Application(){
    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }
}