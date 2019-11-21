package com.deepti.matches.application_card.viewmodel

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AppCardModelFactory(private val mApplication: Application,
                          private val activity: Activity) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppCardViewModel(activity,mApplication) as T
    }
}