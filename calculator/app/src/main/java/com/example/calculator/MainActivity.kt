package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn_add(view: View){
        var btn_choose = view as Button
        var text_default_val:String = show_text.text.toString()
        when(btn_choose.id){
            zero.id->{
                text_default_val+="0"
            }
            one.id->{
                text_default_val+="1"
            }
            two.id->{
                text_default_val+="2"
            }
            three.id->{
                text_default_val+="3"
            }
            four.id->{
                text_default_val+="4"
            }
            five.id->{
                text_default_val+="5"
            }
            six.id->{
                text_default_val+="6"
            }
            seven.id->{
                text_default_val+="7"
            }
            eight.id->{
                text_default_val+="8"
            }
            none.id->{
                text_default_val+="9"
            }
            sign.id-> {
                text_default_val = "-" + text_default_val
            }
            point.id->{
                text_default_val+="."
            }
        }
        show_text.setText(text_default_val)
    }

    var process=""
    var old_number=""
    var new_process=true

    fun btn_process(view: View){
        var btn_choose = view as Button
        when(btn_choose.id){
            plus.id->{
                process="+"
            }
            minus.id->{
                process="-"
            }
            slash.id->{
                process="/"
            }
            x.id->{
                process="*"
            }
        }
        old_number=show_text.text.toString()
        new_process=false
        show_text.setText("")
    }

    fun equal_btn(view: View){
        var new_number=show_text.text.toString()
        var result:Double?=null
        when(process){
            "+"->{
                result=old_number.toDouble()+new_number.toDouble()
            }
            "-"->{
                result=old_number.toDouble()-new_number.toDouble()
            }
            "*"->{
                result=old_number.toDouble()*new_number.toDouble()
            }
            "/"->{
                result=old_number.toDouble()/new_number.toDouble()
            }
        }
        show_text.setText(result.toString())
        new_process=true
    }

    fun btn_delete(view: View){
        show_text.setText("")
        new_process=true
    }

    fun btn_percentage(view: View){
        var result=show_text.text.toString().toDouble()/100
        show_text.setText(result.toString())
        new_process=true
    }

    fun btn_one_number(view: View){
        var result=1/show_text.text.toString().toDouble()
        show_text.setText(result.toString())
        new_process=true
    }
}