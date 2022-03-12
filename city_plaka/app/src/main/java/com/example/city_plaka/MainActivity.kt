package com.example.city_plaka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.city_plaka.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            if(binding.edit.text.isNotEmpty()){
                var plaka=binding.edit.text.toString().toInt()
                when(plaka){
                    33->{
                        binding.textView.text="Mersin"
                    }
                    34->{
                        binding.textView.text="İstanbul"
                    }
                    7->{
                        binding.textView.text="Antalya"
                    }
                    18->{
                        binding.textView.text="Çankırı"
                    }
                    25->{
                        binding.textView.text="Erzurum"
                    }
                    37->{
                        binding.textView.text="Kastamonu"
                    }
                    80->{
                        binding.textView.text="Osmaniye"
                    }
                    70->{
                        binding.textView.text="Karaman"
                    }
                    64->{
                        binding.textView.text="Uşak"
                    }
                    58->{
                        binding.textView.text="Sivas"
                    }
                    else->{
                        binding.textView.text="Bulunamadı"
                    }
                }

            }else{
                binding.textView.text = "Plaka kodu giriniz!"
            }
        }
    }
}