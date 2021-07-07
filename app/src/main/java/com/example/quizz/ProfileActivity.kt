package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.quiz_mini.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        mAuth = FirebaseAuth.getInstance()
        val currentUser=mAuth.currentUser

        name.text=currentUser?.displayName
        userName.text = currentUser?.email
        Glide.with(this).load(currentUser?.photoUrl).into(profile_image)

        val allStat: ArrayList<StatData> = ArrayList()
        allStat.add(StatData("Achievement",R.drawable.achiever))
        allStat.add(StatData("Perfectionist",R.drawable.perfectionist))
        allStat.add(StatData("Scholar",R.drawable.scholar))
        allStat.add(StatData("Champion",R.drawable.champion))
        allStat.add(StatData("Focused",R.drawable.perfectionist))

        val recyclerAdapter= StatAdapter(allStat)
        statView.adapter = recyclerAdapter

    }
}