package com.example.registrationapp

import android.content.Intent
import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.registrationapp.api.ApiClient
import com.example.registrationapp.api.ApiClient.buildApiClient
import com.example.registrationapp.api.ApiInterface
import com.example.registrationapp.databinding.ActivityMainBinding
import com.example.registrationapp.models.RegistrationRequest
import com.example.registrationapp.models.RegistrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
   lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSpinner()
        clickRegister()

    }
    fun setUpSpinner(){
        //Casting of views
        //R stands for resources

        var nationalities= arrayOf("select nationality","Kenyan","Rwandan","South Sudanese","Ugandan")
        var nationalityAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_item,nationalities)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spNationality.adapter=nationalityAdapter

    }
    fun clickRegister(){
        binding.btnRegister.setOnClickListener {

            var error=false

            var name = binding.etName.text.toString()
            if (name.isEmpty()){
                error=true
                binding.etName.setError("Name is required")

            }
            var dob = binding.etDob.text.toString()
            if (dob.isEmpty()){
                error=true
                binding.etDob.setError("Date is required")
            }
            var password = binding.etPassword.text.toString()
            if (password.isEmpty()){
                error=true
                binding.etPassword.setError("ID is required")
            }

            var nationality = ""
            if (binding.spNationality.selectedItemPosition!=0){
                nationality=binding.spNationality.selectedItem.toString()
            }
            else{
                error=true
                Toast.makeText(baseContext,"Select nationality",Toast.LENGTH_LONG)
            }

            var phone = binding.etPhoneNo.text.toString()
            if (phone.isEmpty()){
                error=true
                binding.etPhoneNo.setError("Phone number is required")
            }
            var email = binding.etEmail.text.toString()
            if (email.isEmpty()){
               binding.etEmail.setError("Email is required")
            }

            var register = Registration(name,dob,password,nationality,phone,email)
            if(error!=true) {
                val intent = Intent(baseContext, LogInActivity::class.java)
                startActivity(intent)
            }
            if (!error){
                binding.pbRegistration.visibility=View.GONE
                var regRequest=RegistrationRequest(
                    name = name,
                    phoneNumber = phone,
                    email = email,
                    dateOfBirth = dob,
                    nationality=nationality.toUpperCase(),
                    password = password)

                var retrofit= buildApiClient(ApiInterface::class.java)
                val request=retrofit.registerStudent(regRequest)
                request.enqueue(object: Callback<RegistrationResponse>{
                    override fun onResponse(
                        call: Call<RegistrationResponse>,
                        response: Response<RegistrationResponse>
                    ) {
                        binding.pbRegistration.visibility=View.VISIBLE
                       if (response.isSuccessful){
                           Toast.makeText(baseContext,"Registration successful",Toast.LENGTH_LONG).show()
                       }
                        else{
                            Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
                       }
                    }

                    override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                     Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                        binding.pbRegistration.visibility=View.GONE
                    }
                })

            }

        }
    }
}
data class Registration (var name:String,var dob:String,var IdNo:String,var nationality:String,var phone:String,var email:String) {
}



