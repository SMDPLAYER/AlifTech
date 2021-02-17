package uz.smd.aliftech.data.service

import retrofit2.Call
import retrofit2.http.GET
import uz.smd.aliftech.data.entities.MarsProperty
import uz.smd.aliftech.util.retrofit.ResponseData


interface ApiService {

    @GET("service/v2/upcomingGuides/")
    fun getPosts(): Call<ResponseData<MarsProperty>>

}