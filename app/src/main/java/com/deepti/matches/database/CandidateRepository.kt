package com.deepti.matches.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.deepti.matches.model.CandidateList
import com.deepti.matches.model.TopList

class CandidateRepository(application: Application) {

    private val candDao: CandidateDao
    private val candDataDao: CandidateDataDao
    private val listLiveData: LiveData<List<TopList>>
    private val status: LiveData<TopList>

    init {
        val habitRoomDatabase = CandidateDatabase.buildDatabase(application)
        candDao = habitRoomDatabase.candDao()
        candDataDao = habitRoomDatabase.candDataDao()
        listLiveData = candDao.getAllCandidate()
        status = candDataDao.getStatus("")
    }

    fun getAllCandidates(): LiveData<List<TopList>> {
        return listLiveData
    }

    fun getStatus(email : String): LiveData<TopList> {
        return status
    }

    fun insert(list: ArrayList<TopList>) {
        insertAsyncTask(candDao).execute(list)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: CandidateDao) :
        AsyncTask<ArrayList<TopList>, Void, Void>() {

        override fun doInBackground(vararg params: ArrayList<TopList>): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}