package com.example.arg_exam

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.arg_exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            if(binding.editTextNumber.text.isNotEmpty() && binding.editTextNumber3.text.isNotEmpty()){
                var midterm=binding.editTextNumber.text.toString().toDouble()
                var final = binding.editTextNumber3.text.toString().toDouble()
                var result =( midterm + final )/2
                var show=""
                if(result>=50){
                    show="You pass. Exam avg:"
                    binding.result.setTextColor(getColor(R.color.green))
                }else{
                    show="You cant pass. Exam avg:"
                    binding.result.setTextColor(getColor(R.color.red))
                }
                show+=result.toString()
                binding.result.setText(show)
            }else{
                binding.result.setText("Enter Your Exams")
            }
        }
    }
}