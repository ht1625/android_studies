package com.example.card_flower

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_flower.view.*

class MainActivity : AppCompatActivity() {
    var flower_list=ArrayList<flowers>()
    var adapter:flower_adapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val detail_gul:String=R.string.detail_gul.toString()
        val detail_lale:String=R.string.detail_lale.toString()
        val detail_karanfil:String=R.string.detail_karanfil.toString()
        val detail_zambak:String=R.string.detail_zambak.toString()
        val detail_kasimpati:String=R.string.detail_kasimpati.toString()
        val detail_nergis:String=R.string.detail_nergis.toString()
        val detail_sumbul:String=R.string.detail_sumbul.toString()
        flower_list.add(flowers("GÜL",detail_gul,R.drawable.gul))
        flower_list.add(flowers("LALE",detail_lale,R.drawable.lale))
        flower_list.add(flowers("KARANFİL",detail_karanfil,R.drawable.karanfil))
        flower_list.add(flowers("ZAMBAK",detail_zambak,R.drawable.karanfil))
        flower_list.add(flowers("KASIMPATI",detail_kasimpati,R.drawable.zambak))
        flower_list.add(flowers("Nergis",detail_nergis,R.drawable.nergis))
        flower_list.add(flowers("SÜMBÜL",detail_sumbul,R.drawable.sumbul))

        adapter= flower_adapter(this,flower_list)
        list_card.adapter=adapter
    }

    class flower_adapter:BaseAdapter{
        var list_temp=ArrayList<flowers>()
        var context:Context?=null

        constructor(context: Context,list_temp:ArrayList<flowers>):super(){
            this.list_temp=list_temp
            this.context=context
        }

        override fun getCount(): Int {//boyutu kadar dönücek
            return list_temp.size
        }

        override fun getItem(p0: Int): Any {
            return list_temp[p0] //liste elemanlarına position vercek
        }

        override fun getItemId(p0: Int): Long {//dosyanın uzunluğu kadar dönücek
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pos_flower:flowers=list_temp[p0]
            var inflater:LayoutInflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var flower_card:View=inflater.inflate(R.layout.card_flower,null)
            flower_card.textView.text=pos_flower.title
            flower_card.imageView.setImageResource(pos_flower.img!!)
            flower_card.data.text=pos_flower.text

            flower_card.imageView.setOnClickListener{
                var intent=Intent(context,flower_detay::class.java)
                intent.putExtra("name",pos_flower.title)
                intent.putExtra("text",pos_flower.text)
                intent.putExtra("img",pos_flower.img!!)
                context!!.startActivity(intent)
            }
            return flower_card
        }

    }
}

