package com.example.quizz.quiz

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizz.R
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private var currentPosition: Int = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOption: Int = 0
    private var score:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionsList = setData.getQuestion()

        setQuestion()

        optionOne.setOnClickListener {
            selectedOption(optionOne, 1)
        }

        optionTwo.setOnClickListener {
            selectedOption(optionTwo, 2)
        }

        optionThree.setOnClickListener {
            selectedOption(optionThree, 3)
        }

        optionFour.setOnClickListener {
            selectedOption(optionFour, 4)
        }

        btnNext.setOnClickListener {

            if (selectedOption != 0)
            {
                val question = questionsList!![currentPosition - 1]
                if (selectedOption == question.answer) {
                    score++
                }
                if (currentPosition == questionsList!!.size)
                {
                    btnNext.text = "Finish"
                }
            }
            else
            {
                currentPosition++
                if (currentPosition <= questionsList!!.size)
                {
                    setQuestion()
                }
                else
                {
                    var intent = Intent(this,ResultActivity::class.java)
                    intent.putExtra(setData.score,score.toString())
                    intent.putExtra("total size",questionsList!!.size.toString())
                    startActivity(intent)
                    finish()
                }
            }
            selectedOption = 0
            currentPosition++
            if (currentPosition <= questionsList!!.size)
            {
                setQuestion()
            }
        }

    }


    fun setQuestion() {
        val question = questionsList!![currentPosition - 1]
        setOption()

        progressBar.progress = currentPosition
        progressBar.max = questionsList!!.size
        txtProgress.text = "${currentPosition}" + "/" + "${questionsList!!.size}"
        question_txt.text = question.ques
        optionOne.text = question.option1
        optionTwo.text = question.option2
        optionThree.text = question.option3
        optionFour.text = question.option4

    }

    fun setOption() {
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, optionOne)
        optionList.add(1, optionTwo)
        optionList.add(2, optionThree)
        optionList.add(3, optionFour)

        for (opt in optionList) {
            opt.setTextColor(Color.parseColor("#000000"))
            opt.background = ContextCompat.getDrawable(this, R.drawable.option_item_bg)
            opt.typeface = Typeface.DEFAULT

        }

    }

    fun selectedOption(view: TextView, opt: Int) {
        setOption()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.option_item_selected)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }

}