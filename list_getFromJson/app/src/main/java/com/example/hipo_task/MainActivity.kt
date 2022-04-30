package com.example.hipo_task

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hipo_task.databinding.ActivityMainBinding
import com.example.hipo_task.model.Member
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private lateinit var BindingMain: ActivityMainBinding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(BindingMain.root)

        val recyclerViewMainActivity = BindingMain.MemberList
        val usersList: ArrayList<Member> = ArrayList()

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

                val userDetails = Member(name, age, location, github, position, years_in_hipo)

                usersList.add(userDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        if (intent != null) {
            val intent = intent.extras
            val nameForAddMember: String? = intent?.getString("nameForRegistery")
            val ageForAddMember: Int? = intent?.getString("ageForRegistery")?.toInt()
            val positionForAddMember: String? = intent?.getString("positionForRegistery")
            val githubForAddMember: String? = intent?.getString("githubForRegistery")
            val locationForAddMember: String? = intent?.getString("locationForRegistery")
            val yearsInHipoForAddMember: Int? =
                intent?.getString("yearsInHipoForRegistery")?.toInt()

            if (nameForAddMember != null || ageForAddMember != null || locationForAddMember != null || githubForAddMember != null || positionForAddMember != null || yearsInHipoForAddMember != null) {
                val add_member: Member = Member(
                    nameForAddMember,
                    ageForAddMember,
                    locationForAddMember,
                    githubForAddMember,
                    positionForAddMember,
                    yearsInHipoForAddMember
                )
                usersList!!.add(add_member)
                BindingMain.addMember.visibility = View.GONE
            }
        }

        recyclerViewMainActivity.layoutManager = LinearLayoutManager(this)
        var itemAdapter = MemberAdapter(this, usersList)
        recyclerViewMainActivity.adapter = itemAdapter

        BindingMain.addMember.setOnClickListener {
            val intent = Intent(this, MemberAdditionActivity::class.java)
            startActivity (intent)
        }

        BindingMain.searchMember.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                val newList: ArrayList<Member> = ArrayList()
                for (user in usersList) {
                    if (user.name?.contains(newText) == true || user.position?.contains(newText) == true) {
                        newList.add(user)
                    }
                }
                itemAdapter = MemberAdapter(this@MainActivity, newList)
                recyclerViewMainActivity.adapter = itemAdapter
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