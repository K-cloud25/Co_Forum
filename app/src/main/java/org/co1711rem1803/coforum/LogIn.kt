package org.co1711rem1803.coforum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogIn : AppCompatActivity() {

    private lateinit var signUPbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        signUPbtn = findViewById(R.id.signUpBtn)

        signUPbtn.setOnClickListener{
            val intent = Intent(this@LogIn,Signup_page::class.java)
            startActivity(intent)
        }

    }
}