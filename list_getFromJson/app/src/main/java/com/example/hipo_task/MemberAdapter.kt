package com.example.hipo_task

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hipo_task.model.member
import kotlinx.android.synthetic.main.row_member.view.*

class MemberAdapter(var context: MainActivity, val items: ArrayList<member>) :
    RecyclerView.Adapter<MemberAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.row_member,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)
        holder.tv_name.text = item.name + " \n " + item.position

        holder.tv_name.setOnClickListener { v ->
            val intent = Intent(v.context, MemberDetail::class.java)
            intent.putExtra("nameForDetail", item.name)
            intent.putExtra("ageForDetail", item.age)
            intent.putExtra("locationForDetail", item.location)
            intent.putExtra("githubForDetail", item.github)
            intent.putExtra("positionForDetail", item.position)
            intent.putExtra("yearsInHipoForDetail", item.years_in_hipo)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_name = view.name
    }
}