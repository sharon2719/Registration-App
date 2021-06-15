package com.example.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var etDob:EditText
    lateinit var etIdNo:EditText
    lateinit var etNationality:EditText
    lateinit var etPhoneNo:EditText
    lateinit var etEmail:EditText
    lateinit var btnRegister:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        castViews()
        clickRegister()

    }
    fun castViews(){
        //Casting of views
        //R stands for resources
        etName = findViewById(R.id.etName)
        etDob = findViewById(R.id.etDate)
        etIdNo = findViewById(R.id.etIdNo)
        etNationality = findViewById(R.id.etNationality)
        etPhoneNo = findViewById(R.id.etPhoneNo)
        etEmail = findViewById(R.id.etEmail)
        btnRegister = findViewById(R.id.btnRegister)

    }
    fun clickRegister(){
        btnRegister.setOnClickListener {
            var name = etName.text.toString()
            if (name.isEmpty()){
                etName.setError("Name is required")

            }
            var dob = etDob.text.toString()
            if (dob.isEmpty()){
                etDob.setError("Date is required")
            }
            var idNo = etIdNo.text.toString()
            if (idNo.isEmpty()){
                etIdNo.setError("ID is required")
            }

            var nationality = etNationality.text.toString()
            if (nationality.isEmpty()){
                etNationality.setError("Nationality is required")
            }
            var phone = etPhoneNo.text.toString()
            if (phone.isEmpty()){
                etPhoneNo.setError("Phone number is required")
            }
            var email = etEmail.text.toString()
            if (email.isEmpty()){
                etEmail.setError("Email is required")
            }
//            Toast.makeText(baseContext, name, Toast.LENGTH_LONG).show()
//            Toast.makeText(baseContext, dob, Toast.LENGTH_LONG).show()
//            Toast.makeText(baseContext, idNo, Toast.LENGTH_LONG).show()
//            Toast.makeText(baseContext, nationality, Toast.LENGTH_LONG).show()
//            Toast.makeText(baseContext, phone, Toast.LENGTH_LONG).show()
//            Toast.makeText(baseContext, email, Toast.LENGTH_LONG).show()

//            var register = Registration(name,dob,idNo,nationality,phone,email)
//            Toast.makeText(baseContext,register.toString(),Toast.LENGTH_LONG).show()

            val intent=Intent(baseContext,CoursesActivity::class.java)
            startActivity(intent)



        }
    }
}
data class Registration (var name:String,var dob:String,var IdNo:String,var nationality:String,var phone:String,var email:String)



