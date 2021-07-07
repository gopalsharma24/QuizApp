package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        firebaseAuth = FirebaseAuth.getInstance()


        signup_btn.setOnClickListener{
            signUp()
        }

    }

    private fun signUp(){
        val email: String = edt_your_email.text.toString()
        val psd: String = edt_your_password.text.toString()
        val cnf_psd:String = edt_confirm_password.text.toString()

        if (email.isEmpty() || psd.isEmpty() || cnf_psd.isEmpty())
        {
            Toast.makeText(this,"Enter Details",Toast.LENGTH_LONG).show()
            return
        }
        if (psd != cnf_psd)
        {
            Toast.makeText(this,"Password doesn't match",Toast.LENGTH_LONG).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email,psd)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    val intent = Intent(this,MainActivity2::class.java)
                    startActivity(intent)                }
                else{
                    Toast.makeText(this,"Error Creating User",Toast.LENGTH_LONG).show()

                }
        }

    }

}