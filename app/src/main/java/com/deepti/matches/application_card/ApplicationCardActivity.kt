package com.deepti.matches.application_card

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.deepti.matches.R
import com.deepti.matches.application_card.viewmodel.AppCardModelFactory
import com.deepti.matches.application_card.viewmodel.AppCardViewModel
import com.deepti.matches.databinding.ActivityApplicationCardBinding
import com.deepti.matches.utils.Alerts
import com.deepti.matches.utils.CustomeProgressDialog

class ApplicationCardActivity : AppCompatActivity() {

    private var binding: ActivityApplicationCardBinding? = null
    private var viewmodel: AppCardViewModel? = null
    private var progressDialog: CustomeProgressDialog? = null
    private var listAdapter: ApplicationAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_application_card)
        viewmodel = ViewModelProviders.of(this, AppCardModelFactory(this.application,
            this) ).get(AppCardViewModel::class.java)
        binding!!.viewmodel = viewmodel
        initObservables()
    }

    private fun initObservables() {
        viewmodel?.progressDialog?.observe(this, Observer {
            if (it!!) progressDialog?.show() else progressDialog?.dismiss()
        })

        viewmodel?.getList?.observe(this, Observer { listData ->
            if (listData != null){
                val recyclerView = binding!!.list
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.setHasFixedSize(true)

                listAdapter = ApplicationAdapter(listData)
                recyclerView.adapter = listAdapter
                recyclerView.adapter!!.notifyDataSetChanged()

            }else{
                Alerts.alert(this,"No Data found")
            }
        })
    }
}

