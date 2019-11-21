package com.deepti.matches.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deepti.matches.model.CandidateList
import com.deepti.matches.model.Name
import com.deepti.matches.model.TopList

@Database(
    entities = [CandidateList::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class CandidateDatabase : RoomDatabase() {

    abstract fun candDao(): CandidateDao
    abstract fun candDataDao(): CandidateDataDao

    companion object {
        @Volatile private var instance: CandidateDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            CandidateDatabase::class.java, "candidate.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}