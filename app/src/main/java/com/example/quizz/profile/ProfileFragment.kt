package com.example.quizz.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.example.quizz.R
import com.example.quizz.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*



class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var mAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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


        btnSignOut.setOnClickListener{
            mAuth.signOut()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    }


