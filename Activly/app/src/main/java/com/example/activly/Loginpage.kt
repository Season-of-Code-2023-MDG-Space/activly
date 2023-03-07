package com.example.activly


//import android.R
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Loginpage : AppCompatActivity() {
    var name: EditText? = null
    var branch: EditText? = null
    var yr: EditText? = null
    var num: EditText? = null
    var email: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        name = findViewById<EditText>(R.id.editTextTextPersonName)
        branch = findViewById<EditText>(R.id.editTextTextPersonName2)
        yr = findViewById<EditText>(R.id.editTextNumber)
        num=findViewById<EditText>(R.id.editTextNumber2)
        email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        var btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
            var ans : Boolean = checkDataEntered()
            if(ans==true){
                val intent = Intent(this,PreferenceActivity::class.java)
                startActivity(intent)
            }
        })
    }

    fun isEmail(text: EditText?): Boolean {
        val email: CharSequence = text!!.text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isEmpty(text: EditText?): Boolean {
        val str: CharSequence = text!!.text.toString()
        return TextUtils.isEmpty(str)
    }

    fun checkDataEntered() : Boolean {
        var flag : Boolean=true;
        var nu = findViewById<EditText>(R.id.editTextNumber2)
        var a = nu.text.toString().length
        var b = (a==10)
        if (isEmpty(name)) {
            name!!.error = "Name is required!"
            val t = Toast.makeText(this, "You must enter your name to register!", Toast.LENGTH_SHORT)
            t.show()
            flag=false
        }
        if (isEmpty(branch)) {
            branch!!.error = "Branch is required!"
            flag=false
        }
        if (isEmpty(yr)) {
            yr!!.error = "Year is required!"
            flag=false
        }
        if (isEmail(email) == false) {
            email!!.error = "Enter valid email!"
            flag=false
        }
        if (isEmpty(num)) {
            num!!.error = "Number is required!"
            flag=false
        }
        if(b==false){
            Toast.makeText(this, "Number should be of 10 digit.", Toast.LENGTH_SHORT).show()
            flag=false
        }
        return flag
    }
}