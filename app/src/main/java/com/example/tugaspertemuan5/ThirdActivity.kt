package com.example.tugaspertemuan5

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugaspertemuan5.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val TAG = "ThirdActivity"

    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username =intent.getStringExtra("EXTRA_NAME")
        val email =intent.getStringExtra("EXTRA_EMAIL")
        val phoneNumber =intent.getStringExtra("EXTRA_PHONE")
        val gender =intent.getStringExtra("EXTRA_GENDER")

        with(binding){
            tampilanUsername.setText(username)
            tampilanEmail.setText(email)
            tampilanTelephone.setText(phoneNumber)
            tampilanGender.setText(gender)
        }
    }
}