package uz.smd.aliftech.model

import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.smd.aliftech.data.entities.MarsProperty
import uz.smd.aliftech.data.room.dao.PostsDao
import uz.smd.aliftech.data.service.ApiService
import uz.smd.aliftech.util.retrofit.enqueue
import javax.inject.Inject

/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */
class MyRepository @Inject constructor(private val api: ApiService, private val dao: PostsDao) {

    fun getData(): LiveData<List<MarsProperty>> {
        api.getPosts().enqueue {
            it.onData {
                GlobalScope.launch{
                    dao.insertAll(it.data!!)
                }
            }
            it.onMessage {

            }
            it.onFailure {

            }
        }
        return dao.getAll()
    }
}