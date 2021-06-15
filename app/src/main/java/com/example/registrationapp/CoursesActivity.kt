package com.example.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CoursesActivity : AppCompatActivity() {

    lateinit var btnNext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        castViews()
        clickCourses()
    }
   fun castViews(){
       btnNext=findViewById(R.id.btnNext)
   }
    fun clickCourses(){
        btnNext.setOnClickListener {
            val intent= Intent(baseContext,LogInActivity::class.java)
            startActivity(intent)
        }
    }
}