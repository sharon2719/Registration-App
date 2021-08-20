package com.example.registrationapp.api

import com.example.registrationapp.models.LoginRequest
import com.example.registrationapp.models.LoginResponse
import com.example.registrationapp.models.RegistrationRequest
import com.example.registrationapp.models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>

    @POST("/students/register")
    fun logInStudent(@Body loginRequest:LoginRequest):Call<LoginResponse>

}