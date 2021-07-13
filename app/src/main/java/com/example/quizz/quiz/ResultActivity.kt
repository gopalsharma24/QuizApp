package com.example.quizz.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizz.MainActivity2
import com.example.quizz.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getStringExtra(setData.score)
        val totalQuestion = intent.getStringExtra("total size")

        score_value.text="${score} / ${totalQuestion}"

        btnClose.setOnClickListener{
            startActivity(Intent(this,MainActivity2::class.java))
            finish()
        }
        btn_facebook.setOnClickListener{
            val intent = packageManager.getLaunchIntentForPackage("com.facebook.katana")
            startActivity(intent)
        }
        btn_mail.setOnClickListener{
            val intent = packageManager.getLaunchIntentForPackage("com.google.android.gm")
            startActivity(intent)


        }
        btn_twitter.setOnClickListener{
            val intent = packageManager.getLaunchIntentForPackage("com.twitter.android")
            startActivity(intent)
        }
        btn_instagram.setOnClickListener{
            val intent = packageManager.getLaunchIntentForPackage("com.instagram.android")
            startActivity(intent)
        }
    }
}