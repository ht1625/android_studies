package com.example.hipo_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add_member.*
import kotlinx.android.synthetic.main.activity_member_detail.*
import kotlinx.android.synthetic.main.activity_member_detail.age
import kotlinx.android.synthetic.main.activity_member_detail.github
import kotlinx.android.synthetic.main.activity_member_detail.location
import kotlinx.android.synthetic.main.activity_member_detail.name
import kotlinx.android.synthetic.main.activity_member_detail.position

class MemberDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_detail)

        if (intent != null) {

            val intent = intent.extras
            val name: String? = intent?.getString("name")
            val age: Int? = intent?.getInt("age")
            val position: String? = intent?.getString("pos")
            val github: String? = intent?.getString("git")
            val location: String? = intent?.getString("loc")
            val year: Int? = intent?.getInt("year")

            val name_TextView = findViewById<TextView>(R.id.name)
            val age_TextView = findViewById<TextView>(R.id.age)
            val localtion_TextView = findViewById<TextView>(R.id.location)
            val github_TextView = findViewById<TextView>(R.id.github)
            val position_TextView = findViewById<TextView>(R.id.position)

            name_TextView.text = name
            age_TextView.text = "Age: " + age.toString()
            localtion_TextView.text = "Location: " + location
            github_TextView.text = "Github: " + github
            position_TextView.text = "Position/Years in Hipo: " + position + "/" + year.toString()

        }
    }
}