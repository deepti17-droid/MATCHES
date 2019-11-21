package com.deepti.matches.database

import androidx.room.TypeConverter
import com.deepti.matches.model.Name
import com.deepti.matches.model.TopList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    /**
     * Convert a a list of Images to a Json
     */
    @TypeConverter
    fun fromResultJson(stat: List<TopList>): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun toResultList(jsonImages: String): List<TopList> {
        val notesType = object : TypeToken<List<TopList>>() {}.type
        return Gson().fromJson<List<TopList>>(jsonImages, notesType)
    }

    /**
     * Convert a a list of Images to a Json
     */
    @TypeConverter
    fun fromNameJson(stat: Name): String {
        return Gson().toJson(stat)
    }

    /**
     * Convert a json to a list of Images
     */
    @TypeConverter
    fun toNameList(jsonImages: String): Name {
        val notesType = object : TypeToken<Name>() {}.type
        return Gson().fromJson<Name>(jsonImages, notesType)
    }
}