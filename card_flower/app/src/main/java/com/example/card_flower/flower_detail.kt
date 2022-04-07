package com.example.card_flower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_flower_detail.*

class flower_detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_detail)

        var bundle:Bundle= intent.extras!!
        var name: String? =bundle.getString("name")
        var text:String? =bundle.getString("text")
        var img:Int =bundle.getInt("img")

        textView2.text=name
        textView3.text=text
        imageView2.setImageResource(img)
    }
}
