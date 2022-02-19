package org.co1711rem1803.coforum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LogIn : AppCompatActivity() {

    private lateinit var signUPbtn : Button
    private lateinit var logInBtn : Button

    private lateinit var emailBox : EditText
    private lateinit var passwordBox : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        signUPbtn = findViewById(R.id.signUpBtn)
        logInBtn = findViewById(R.id.loginBtn)
        emailBox = findViewById(R.id.emailInput)


        signUPbtn.setOnClickListener{
            val intent = Intent(this@LogIn,Signup_page::class.java)
            startActivity(intent)
        }

        //Check Email Input For @mitwpu.edu.in  for cross checking
        logInBtn.setOnClickListener{
            val text = emailBox.text.toString()
            if(text.contains("@")) {
                var check = text.split("@")

                if(check[1] == "mitwpu.edu.in"){
                    Toast.makeText(this,check[1],Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this,"Incorrect email ",Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this,"Incorrect Email Format",Toast.LENGTH_LONG).show()
            }
        }
    }
}