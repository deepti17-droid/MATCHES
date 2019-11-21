package com.deepti.matches.application_card.viewmodel

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deepti.matches.database.CandidateRepository
import com.deepti.matches.model.CandidateList
import com.deepti.matches.model.TopList
import com.deepti.matches.network.Retro
import com.deepti.matches.utils.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppCardViewModel(var activity: Activity, application: Application) :
    AndroidViewModel(application) {

    var progressDialog: SingleLiveEvent<Boolean>? = null
    var getList: MutableLiveData<ArrayList<TopList>>? = null
    private val candRepository: CandidateRepository
    internal val allList: LiveData<List<TopList>>

    init {
        getList = MutableLiveData()
        progressDialog = SingleLiveEvent()
        candRepository = CandidateRepository(application)
        allList = candRepository.getAllCandidates()
        callList()
    }

    fun insert(candidate: ArrayList<TopList>) {
        candRepository.insert(candidate)
    }

    private fun callList() {
        progressDialog?.value = true
        val service = Retro().getAPInstance()
        val version = service.candidateList()

        version.enqueue(object : Callback<CandidateList> {
            override fun onFailure(call: Call<CandidateList>, t: Throwable) {
                progressDialog?.value = false
            }
            override fun onResponse(call: Call<CandidateList>, response: Response<CandidateList>) {
                progressDialog?.value = false
                getList!!.value = response.body()?.results!!
                insert(getList!!.value!!)
            }
        })
    }
}