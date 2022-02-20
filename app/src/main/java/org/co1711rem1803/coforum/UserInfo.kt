package org.co1711rem1803.coforum

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class UserInfo : AppCompatActivity() {

    private lateinit var datePickerBtn : Button
    private lateinit var dateTextdisplay : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        supportActionBar?.hide()

        datePickerBtn = findViewById(R.id.datePickerBtn)
        dateTextdisplay = findViewById(R.id.dateDisplay)
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
    }
}