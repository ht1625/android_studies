package com.example.hipo_task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hipo_task.databinding.ActivityAddMemberBinding

class MemberAdditionActivity : AppCompatActivity() {

    private lateinit var BindingAddMember: ActivityAddMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         BindingAddMember = ActivityAddMemberBinding.inflate(layoutInflater)
        setContentView(BindingAddMember.root)

        BindingAddMember.btnRegister.setOnClickListener {

            val name = BindingAddMember.name.text.toString()
            val age = BindingAddMember.age.text.toString()
            val location = BindingAddMember.location.text.toString()
            val github = BindingAddMember.github.text.toString()
            val position = BindingAddMember.position.text.toString()
            val yearHipo = BindingAddMember.year.text.toString()

            //goto MainActivity
            val intent = Intent(this@MemberAdditionActivity, MainActivity::class.java)
            intent.putExtra("nameForRegistery", name)
            intent.putExtra("ageForRegistery", age)
            intent.putExtra("locationForRegistery", location)
            intent.putExtra("githubForRegistery", github)
            intent.putExtra("positionForRegistery", position)
            intent.putExtra("yearsInHipoForRegistery", yearHipo)
            startActivity(intent)
        }
    }
}