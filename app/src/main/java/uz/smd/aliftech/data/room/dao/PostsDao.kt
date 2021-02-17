package uz.smd.aliftech.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import uz.smd.aliftech.data.entities.MarsProperty

@Dao
interface PostsDao : BaseDao<MarsProperty> {
    @Query("SELECT * FROM MarsProperty")
    fun getAll(): LiveData<List<MarsProperty>>

    @Query("Delete from MarsProperty")
    fun clearPosts()
}