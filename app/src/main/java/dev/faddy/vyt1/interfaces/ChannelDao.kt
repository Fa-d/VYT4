package dev.faddy.vyt1.interfaces

import androidx.room.Dao

@Dao
interface ChannelDao {
    /* @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(channel: ChannelEntity)

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(channels: Array<ChannelEntity>)

     @Query("UPDATE channel_table SET channel_fav=:isFav WHERE channel_id = :id")
     fun update(isFav: Int?, id: Int)

     @Query("SELECT * FROM channel_table where channel_id = :channel_id")
     fun getChannelsByID(channel_id: Int): List<ChannelEntity>

     @Query("SELECT * FROM channel_table where channel_id = :channel_id LIMIT 1")
     fun getChannel(channel_id: Int): ChannelEntity

     @Query("SELECT * FROM channel_table where channel_fav = 1")
     fun getFavouriteChannels(): List<ChannelEntity>

     @Query("SELECT * from channel_table")
     fun getAllChannels(): MutableList<ChannelEntity>

     @Query("SELECT * from channel_table")
     fun getAll(): Flow<List<ChannelEntity>>

     @Query("DELETE from channel_table where channel_id = :channel_id")
     fun delete(channel_id: Int)*/
}