package com.deepti.matches.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deepti.matches.model.CandidateList
import com.deepti.matches.model.TopList

@Dao
interface CandidateDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(candidate: TopList)

    @Query("SELECT status FROM CandidateDetails where email LIKE :emailData")
    fun getStatus(emailData: String) : LiveData<TopList>
}