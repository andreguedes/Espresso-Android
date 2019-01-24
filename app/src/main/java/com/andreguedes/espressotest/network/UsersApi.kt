package com.andreguedes.espressotest.network

import android.database.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {

    @GET
    fun getUsers(@Query("page") page: Int, @Query("results") results: Int): Observable<Any>

}
