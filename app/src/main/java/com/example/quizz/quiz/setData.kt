package com.example.quizz.quiz

object setData {

    const val score:String="score"


    fun getQuestion(): ArrayList<Question> {
        var ques: ArrayList<Question> = arrayListOf()

        var ques1 = Question(
            "Who is the Prime Minister Of India?",
            "Narendra Modi",
            "Rahul Gandhi",
            "Arvind Khejriwal",
            "Sonia Gandhi",
            1
        )
        var ques2 = Question(
            "Who is the Home Minister Of India?",
            "Amit Shah",
            "Rahul Gandhi",
            "Arvind Khejriwal",
            "Sonia Gandhi",
            1
        )
        var ques3 = Question(
            "Who is the Defence Minister Of India?",
            "Rajnath Singh",
            "Rahul Gandhi",
            "Arvind Khejriwal",
            "Sonia Gandhi",
            1
        )
        var ques4 = Question(
            "Who is the Education Minister Of India?",
            "Dharmendra Pradhan",
            "Rahul Gandhi",
            "Arvind Khejriwal",
            "Sonia Gandhi",
            1
        )
        var ques5 = Question(
            "Who is the Finance Minister Of India?",
            "Nirmala Sitharaman",
            "Rahul Gandhi",
            "Arvind Khejriwal",
            "Sonia Gandhi",
            1
        )
        ques.add (ques1)
        ques.add (ques2)
        ques.add (ques3)
        ques.add (ques4)
        ques.add (ques5)
        return ques
    }
}