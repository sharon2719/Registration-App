package com.example.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.registrationapp.api.ApiClient
import com.example.registrationapp.api.ApiInterface
import com.example.registrationapp.databinding.ActivityInformationBinding
import com.example.registrationapp.databinding.ActivityMainBinding
import com.example.registrationapp.models.LoginRequest
import com.example.registrationapp.models.LoginResponse
import com.example.registrationapp.models.RegistrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var binding:ActivityInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_information)
    }
    fun clickRegister1(){
        binding.btnLogin.setOnClickListener {
            var error=false
            var email1 = binding.etEmail1.text.toString()
            if (email1.isEmpty()){
                binding.etEmail1.setError("Email is required")
            }

            var password1 = binding.etPassword1.text.toString()
            if (password1.isEmpty()){
                error=true
                binding.etPassword1.setError("ID is required")
            }
            var login=Login(email1,password1)
            if(error!=true) {
                val intent = Intent(baseContext, CoursesActivity::class.java)
                startActivity(intent)
            }
            if (!error){
                binding.pbLogin.visibility=View.GONE
                var logRequest=LoginRequest(
                    email=email1,
                    password = password1
                )
                var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
                val request=retrofit.logInStudent(logRequest)
                request.enqueue(object: Callback<LoginResponse>{
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if (response.isSuccessful){
                            Toast.makeText(baseContext,"Login successful", Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(baseContext,response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

                    }
                })
            }


        }
    }
    data class Login(var email1:String,var password1:String)
}