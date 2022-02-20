package org.co1711rem1803.coforum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class Signup_page : AppCompatActivity() {

    private lateinit var signUPbtn : Button

    private lateinit var emailBox : EditText
    private lateinit var passwordBox : EditText
    private lateinit var fullName : EditText

    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        supportActionBar?.hide() //Hides action Bar

        val spinner: Spinner = findViewById(R.id.Year_spinner)

        emailBox = findViewById(R.id.emailID)
        passwordBox = findViewById(R.id.passwordEmail)
        signUPbtn = findViewById(R.id.signUpBtn)
        fullName = findViewById(R.id.FullNameInput)
        mAuth = FirebaseAuth.getInstance()

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.Year,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        signUPbtn.setOnClickListener{
            val email = emailBox.text.toString()
            val password=passwordBox.text.toString()

            //Code Logic to check for mitwpu.edu.in Login Only
            if(email.contains("@")){
                var checkString = email.split("@")

                if(checkString[1]=="mitwpu.edu.in"){
                    signUp(email,password)          //Email is made with cllg ID
                }
                else{
                    Toast.makeText(this@Signup_page , "Enter College ID",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@Signup_page , "Incorrect Email",Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Funtion To Make Sign UP a User
    private fun signUp(email:String, password:String){
        //Sign in Instructions and Parameters

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    //Jump to User InterAction Page

                    val intent = Intent(this@Signup_page , UserInfo::class.java)
                    startActivity(intent)

                } else {
                    //Initiate Sign UP Error
                    Toast.makeText(this@Signup_page, "SignUP Error",Toast.LENGTH_SHORT).show()
                }
            }
    }
}