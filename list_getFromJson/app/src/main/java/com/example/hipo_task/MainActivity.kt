package com.example.hipo_task

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hipo_task.model.member
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.MemberList)
        val usersList: ArrayList<member> = ArrayList()

        try {
            val obj = JSONObject(getJSONFromAssets()!!)
            val usersArray = obj.getJSONArray("members")

            for (i in 0 until usersArray.length()) {
                val user = usersArray.getJSONObject(i)
                val name = user.getString("name")
                val age = user.getInt("age")
                val location = user.getString("location")
                val github = user.getString("github")
                val hipo = user.getJSONObject("hipo")
                val position = hipo.getString("position")
                val years_in_hipo = hipo.getInt("years_in_hipo")

                val userDetails = member(name, age, location, github, position, years_in_hipo)

                usersList.add(userDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        if (intent != null) {
            val intent = intent.extras
            val name: String? = intent?.getString("name")
            val age: Int? = intent?.getString("age")?.toInt()
            val position: String? = intent?.getString("pos")
            val github: String? = intent?.getString("git")
            val location: String? = intent?.getString("loc")
            val year: Int? = intent?.getString("year")?.toInt()

            val add_member: member = member(name, age, location, github, position, year)

            if (name != null) {
                usersList!!.add(add_member)
                val btnRegister = findViewById<Button>(R.id.add_member)
                btnRegister.visibility = View.GONE
            }
            /*getIntent().removeExtra("name")
            getIntent().removeExtra("age")
            getIntent().removeExtra("pos")
            getIntent().removeExtra("loc")
            getIntent().removeExtra("git")
            getIntent().removeExtra("year")*/
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        var itemAdapter = MemberAdapter(this, usersList)
        recyclerView.adapter = itemAdapter

        val goto_AddMember = findViewById<Button>(R.id.add_member)
        goto_AddMember.setOnClickListener {
            val intent = Intent(this, AddMember::class.java)
            startActivity(intent)
        }

        val search = findViewById<SearchView>(R.id.search_member)
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                val newList: ArrayList<member> = ArrayList()
                for (user in usersList) {
                    if (user.name?.contains(newText) == true || user.position?.contains(newText) == true) {
                        newList.add(user)
                    }
                }
                itemAdapter = MemberAdapter(this@MainActivity, newList)
                recyclerView.adapter = itemAdapter
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                return false
            }

        })
    }

    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("hipo.json")
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}