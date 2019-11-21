package com.deepti.matches.utils

import android.widget.ImageView
import com.deepti.matches.R
import com.squareup.picasso.Picasso

object Common {

    fun loadImg(path : String , imgView : ImageView){
        val picasso = Picasso.get()
        picasso.load(path)
            .placeholder(R.drawable.applicationicon)
            .resize(60, 60)
            .into(imgView)
    }
}