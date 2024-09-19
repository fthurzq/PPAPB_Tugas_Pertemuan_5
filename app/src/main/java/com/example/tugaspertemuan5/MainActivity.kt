package com.example.tugaspertemuan5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugaspertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding =ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){
            btnRegister.setOnClickListener {
                val username = inputUsername.text.toString()
                val email = inputEmail.text.toString()
                val phoneNumber = inputNoHp.text.toString()
                val selectedGenderId = genderGroup.checkedRadioButtonId
                val gender = when (selectedGenderId) {
                    R.id.radio_male -> "Male"
                    R.id.radio_female -> "Female"
                    else -> "Not selected"
                }

                    val intentToSecondActivity =
                    Intent(this@MainActivity, SecondActivity::class.java)

                intentToSecondActivity.putExtra("EXTRA_NAME", username)
                intentToSecondActivity.putExtra("EXTRA_EMAIL", email)
                intentToSecondActivity.putExtra("EXTRA_PHONE", phoneNumber)
                intentToSecondActivity.putExtra("EXTRA_GENDER", gender)
                startActivity(intentToSecondActivity)
            }
        }
    }
}