package com.example.otp_validation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.otp_validation.R
import android.widget.EditText
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stage = IntArray(1)
        val emailValidate = findViewById<EditText>(R.id.emailValidate)
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        stage[0] = 1
        val opt_page = findViewById<Button>(R.id.nxt_otppage)


        opt_page.setOnClickListener {
            if (ValidateEmailAddress(emailValidate)) {
                findViewById<View>(R.id.stageOne).visibility = View.GONE
                findViewById<View>(R.id.stageTwo).visibility = View.VISIBLE
                stage[0]++
            }
        }
    }

    private fun ValidateEmailAddress(emailValidate: EditText): Boolean {
        val email = emailValidate.editableText.toString().trim { it <= ' ' }
        return if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Email Verified", Toast.LENGTH_LONG).show()
            true
        } else {
            Toast.makeText(this, "Email Invalid", Toast.LENGTH_LONG).show()
            false
        }
    }
}