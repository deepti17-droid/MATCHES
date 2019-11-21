package com.deepti.matches.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deepti.matches.model.CandidateList
import com.deepti.matches.model.TopList

@Dao
interface CandidateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(candidate: ArrayList<TopList>)

    @Query("SELECT * FROM CandidateList")
    fun getAllCandidate() : LiveData<List<TopList>>
}