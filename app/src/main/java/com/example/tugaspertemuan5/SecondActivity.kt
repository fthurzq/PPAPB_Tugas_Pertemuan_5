package com.example.tugaspertemuan5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugaspertemuan5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            btnLogin.setOnClickListener {
                val username = intent.getStringExtra("EXTRA_NAME")
                val email = intent.getStringExtra("EXTRA_EMAIL")
                val phoneNumber = intent.getStringExtra("EXTRA_PHONE")
                val gender = intent.getStringExtra("EXTRA_GENDER")

            val intentToThirdActivity =
                Intent(this@SecondActivity, ThirdActivity::class.java)

                intentToThirdActivity.putExtra("EXTRA_NAME", username)
                intentToThirdActivity.putExtra("EXTRA_EMAIL", email)
                intentToThirdActivity.putExtra("EXTRA_PHONE", phoneNumber)
                intentToThirdActivity.putExtra("EXTRA_GENDER", gender)
            startActivity(intentToThirdActivity)
            }

        }
    }
}