package dev.faddy.vyt1.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_table")
data class ChannelEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "channel_id") val channel_id: Int = 0,
    @ColumnInfo(name = "channel_image") val channelImage: String = "",
    @ColumnInfo(name = "channel_image_app") val channelImageApp: String = "",
    @ColumnInfo(name = "channel_fav") val isFavourite: Int = 0,
    @ColumnInfo(name = "channel_name") val channelName: String = "",
    @ColumnInfo(name = "category_name") val categoryName: String = "",
)
