package com.example.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesActivity : AppCompatActivity() {

    lateinit var rvCourses: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        displayCourses()


    }
    fun displayCourses(){
        var coursesList= listOf<Course>(
            Course("Android","AND 101","Native Android Development","John Owuor"),
            Course("Python","PY 101","Backend Development","James Mwai"),
            Course("JavaScript","JS 101","Javascript for the web","Purity Maina"),
            Course("IoT","IOT 101","IOT for connectivity in the 21st century","Yassin Bare")


        )
        rvCourses=findViewById(R.id.rvCourses)
        var coursesAdapter=CoursesRVAdapter(coursesList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=coursesAdapter
    }

}