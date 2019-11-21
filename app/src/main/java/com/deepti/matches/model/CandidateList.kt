package com.deepti.matches.model

import androidx.room.*
import com.deepti.matches.database.Converters

@Entity(tableName = "CandidateList")
data class CandidateList(
    @PrimaryKey(autoGenerate = true) var id: Int,

    val results: List<TopList> = emptyList()
)

@Entity(tableName = "CandidateDetails")
data class TopList(@ColumnInfo(name = "gender")val gender: String? = "",
                   @TypeConverters(Converters::class) val name: Name = Name(0,"","",""),
                   @Embedded @ColumnInfo(name = "location")val location: Location = Location(0),
                   @PrimaryKey @ColumnInfo(name = "email")val email: String = "",
                   @Embedded val login: Login = Login(0,"","",""),
                   @Embedded val dob: DOB = DOB(0,"",0),
                   @Embedded val registered: Registered = Registered(0,"",0),
                   @ColumnInfo(name = "phone")val phone: String? = "",
                   @ColumnInfo(name = "cell")val cell: String? = "",
                   @ColumnInfo(name = "id")val id: ID,
                   @Embedded val picture: Picture = Picture(0,"","",""),
                   @ColumnInfo(name = "nat")val nat: String? = "",
                   @ColumnInfo(name = "status")val status: Int? = 0
)

data class Name(@PrimaryKey(autoGenerate = true) var id1: Int,
                @ColumnInfo(name = "title")val title: String? = "",
                @ColumnInfo(name = "first")val first: String? = "",
                @ColumnInfo(name = "last")val last: String? = "")

data class Location(@PrimaryKey(autoGenerate = true) var id2: Int,
                    @Embedded @ColumnInfo(name = "street")val street : Street = Street(0,0,""),
                    @ColumnInfo(name = "city")val city: String? = "",
                    @ColumnInfo(name = "state")val state: String? = "",
                    @ColumnInfo(name = "country")val country: String? = "",
                    @ColumnInfo(name = "postcode")val postcode: Int = 0,
                    @ColumnInfo(name = "coordinates")val coordinates: Coordinate= Coordinate(0,"",""),
                    @ColumnInfo(name = "timezone")val timezone : Timezone= Timezone(0,"",""))

data class Street(@PrimaryKey(autoGenerate = true) var id3: Int,
                  @ColumnInfo(name = "number")val number: Int? = 0,
                  @ColumnInfo(name = "name")val name: String? = "")

data class Coordinate(@PrimaryKey(autoGenerate = true) var id4: Int,
                      @ColumnInfo(name = "latitude")val latitude: String? = "",
                      @ColumnInfo(name = "longitude")val longitude: String? = "")

data class Timezone(@PrimaryKey(autoGenerate = true) var id5: Int,
                    @ColumnInfo(name = "offset")val offset: String? = "",
                    @ColumnInfo(name = "description")val description: String? = "")

data class Login(@PrimaryKey(autoGenerate = true) var id6: Int,
                 @ColumnInfo(name = "uuid")val uuid: String? = "",
                 @ColumnInfo(name = "username")val username: String? = "",
                 @ColumnInfo(name = "password")val password: String? = "",
                 @ColumnInfo(name = "salt")val salt: String? = "",
                 @ColumnInfo(name = "md5")val md5: String? = "",
                 @ColumnInfo(name = "sha1")val sha1: String? = "",
                 @ColumnInfo(name = "sha256")val sha256: String? = "")

data class DOB(@PrimaryKey(autoGenerate = true) var id7: Int,
               @ColumnInfo(name = "date")val date: String? = "",
               @ColumnInfo(name = "age")val age: Int? = 0)

data class Registered(@PrimaryKey(autoGenerate = true) var id8: Int,
                      @ColumnInfo(name = "date")val date: String? = "",
                      @ColumnInfo(name = "age")val age: Int? = 0)

data class ID(@PrimaryKey(autoGenerate = true) var id9: Int,
              @ColumnInfo(name = "name")val name: String? = "",
              @ColumnInfo(name = "value")val value: String? = "")

data class Picture(@PrimaryKey(autoGenerate = true) var id22: Int,
                   @ColumnInfo(name = "large")val large: String? = "",
                   @ColumnInfo(name = "medium")val medium: String? = "",
                   @ColumnInfo(name = "thumbnail")val thumbnail: String? = "")