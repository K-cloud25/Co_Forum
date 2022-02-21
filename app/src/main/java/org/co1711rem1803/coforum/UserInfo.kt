package org.co1711rem1803.coforum

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class UserInfo : AppCompatActivity() {

    private lateinit var userName : EditText

    private lateinit var datePickerBtn : Button
    private lateinit var saveBtn : Button

    private lateinit var dateTextdisplay : TextView

    private lateinit var realT_DB : DatabaseReference
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        supportActionBar?.hide()

        userName = findViewById(R.id.userName)
        datePickerBtn = findViewById(R.id.datePickerBtn)
        dateTextdisplay = findViewById(R.id.dateDisplay)
        saveBtn = findViewById(R.id.saveBtn)

        firebaseAuth = FirebaseAuth.getInstance()

        //Calender Object and 3 variable to store day month year
        val calender = Calendar.getInstance()
        var day = calender.get(Calendar.DAY_OF_MONTH)
        var month = calender.get(Calendar.MONTH)
        var year = calender.get(Calendar.YEAR)

        datePickerBtn.setOnClickListener{
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,mYear,mMonth,mDay ->
                dateTextdisplay.setText("" + mDay+"/"+ mMonth + "/"+mYear)
            },year,month,day)

            dpd.show()
        }

        saveBtn.setOnClickListener {
            val Dobstring = "$day/$month/$year"
            addUserToDB("Email",firebaseAuth.currentUser?.uid!!,"ABC",userName.text.toString(),Dobstring)
        }
    }

    private fun addUserToDB(_emailID:String,_uid:String,_fullName:String,_userName:String,_dateOfBirth : String){
        realT_DB = FirebaseDatabase.getInstance().getReference()
        realT_DB.child("user").child(_uid).setValue(User(_emailID,_uid,_fullName, _userName, _dateOfBirth))
    }
}