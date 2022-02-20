package org.co1711rem1803.coforum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LogIn : AppCompatActivity() {

    private lateinit var signUPbtn : Button
    private lateinit var logInBtn : Button

    private lateinit var emailBox : EditText
    private lateinit var passwordBox : EditText

    private lateinit var mAuth : FirebaseAuth
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide() //Hides Action Bar

        signUPbtn = findViewById(R.id.signUpBtn)
        logInBtn = findViewById(R.id.loginBtn)
        emailBox = findViewById(R.id.emailInput)
        passwordBox = findViewById(R.id.passwordInput)
        mAuth = FirebaseAuth.getInstance()

        signUPbtn.setOnClickListener{
            val intent = Intent(this@LogIn , Signup_page::class.java)
            startActivity(intent)
        }

        //Check Email Input For @mitwpu.edu.in  for cross checking
        logInBtn.setOnClickListener{
            val emailId = emailBox.text.toString()
            val password = passwordBox.text.toString()

            if(emailId=="" || password ==""){
                Toast.makeText(this,"Enter Email and Password",Toast.LENGTH_SHORT).show()
            }
            else {
                login(emailId, password)
            }
        }
    }
    //Log In Function to handle login a user
    private fun login(email:String,password:String){
        //Login Parameters
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@LogIn,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LogIn , "User DNE",Toast.LENGTH_SHORT).show()
                }
            }
    }
}