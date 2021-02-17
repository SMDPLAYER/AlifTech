package uz.smd.aliftech.util.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.smd.aliftech.R

/**
 * Created by Siddikov Mukhriddin on 12/29/20
 */

sealed class Result<T> {
    data class Success<T>(val call: Call<T>, val response: Response<T>) : Result<T>()
    data class Failure<T>(val call: Call<T>, val error: Throwable) : Result<T>()
}

inline fun <reified T> Call<ResponseData<T>>.enqueue(crossinline block: (ResultData<ResponseData<T>>) -> Unit) {
    enqueue(object : Callback<ResponseData<T>> {
        override fun onFailure(call: Call<ResponseData<T>>, error: Throwable) {
            block(ResultData.failure(error))
        }

        override fun onResponse(call: Call<ResponseData<T>>, response: Response<ResponseData<T>>) {
            val res = response.body()
            when {
                res == null -> block(ResultData.resource(R.string.empty_body))
                res.data == null -> block(ResultData.resource(R.string.empty_body))
                else -> {
                    block(ResultData.data(res))
                }
            }
        }
    })
}