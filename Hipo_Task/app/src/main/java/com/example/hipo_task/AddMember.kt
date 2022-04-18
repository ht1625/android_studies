package com.example.hipo_task

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.hipo_task.model.member


class AddMember : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_member)

        val register = findViewById<Button>(R.id.btnRegister)
        register.setOnClickListener {

            val name = (findViewById<View>(R.id.name) as EditText).text.toString()
            val age = (findViewById<View>(R.id.age) as EditText).text.toString()
            val location = (findViewById<View>(R.id.location) as EditText).text.toString()
            val github = (findViewById<View>(R.id.github) as EditText).text.toString()
            val position = (findViewById<View>(R.id.position) as EditText).text.toString()
            val yearHipo = (findViewById<View>(R.id.year) as EditText).text.toString()

            //goto MainActivity
            val intent = Intent(this@AddMember, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("loc", location)
            intent.putExtra("git", github)
            intent.putExtra("pos", position)
            intent.putExtra("year", yearHipo)
            startActivity(intent)
        }
    }
}