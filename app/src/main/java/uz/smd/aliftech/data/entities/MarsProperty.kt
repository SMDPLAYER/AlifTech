package uz.smd.aliftech.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */
@Entity
data class MarsProperty(
    val url: String,
    val startDate: String,
    val endDate: String,
    @PrimaryKey
    val name: String,
    val icon: String,
    val objType: String,
    val loginRequired: Boolean
)