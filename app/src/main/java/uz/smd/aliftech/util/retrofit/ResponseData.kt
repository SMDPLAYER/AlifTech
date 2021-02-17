package uz.smd.aliftech.util.retrofit

/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */


data class ResponseData<T>(
    val data: List<T>?=null,
    val total: String
)


