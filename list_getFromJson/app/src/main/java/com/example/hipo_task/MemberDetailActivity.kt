package com.example.hipo_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hipo_task.databinding.ActivityMemberDetailBinding

class MemberDetailActivity : AppCompatActivity() {

    private lateinit var BindingMemberDetail: ActivityMemberDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BindingMemberDetail = ActivityMemberDetailBinding.inflate(layoutInflater)
        setContentView(BindingMemberDetail.root)

        if (intent != null) {

            val intent = intent.extras
            val nameForDetailPage: String? = intent?.getString("nameForDetail")
            val ageForDetailPage: Int? = intent?.getInt("ageForDetail")
            val positionForDetailPage: String? = intent?.getString("positionForDetail")
            val githubForDetailPage: String? = intent?.getString("githubForDetail")
            val locationForDetailPage: String? = intent?.getString("locationForDetail")
            val yearsHipoForDetailPage: Int? = intent?.getInt("yearsInHipoForDetail")

            BindingMemberDetail.name.text = nameForDetailPage
            BindingMemberDetail.age.text = "Age: " + ageForDetailPage.toString()
            BindingMemberDetail.location.text = "Location: " + locationForDetailPage
            BindingMemberDetail.github.text = "Github: " + githubForDetailPage
            BindingMemberDetail.position.text =
                "Position/Years in Hipo: " + positionForDetailPage + "/" + yearsHipoForDetailPage.toString()

        }
    }
}