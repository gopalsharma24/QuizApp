package com.example.quizz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.quizz.fragments.CategoryFragment
import com.example.quizz.fragments.MainFragment
import com.example.quizz.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val homeFragment = MainFragment()
        val profileFragment = ProfileFragment()
        val quizFragment = CategoryFragment()

        makeCurrentFragment(homeFragment)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
                R.id.quiz -> makeCurrentFragment(quizFragment)


            }
            true
        }


    }

    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameView,fragment)
            commit()
        }
}