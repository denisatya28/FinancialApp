package com.example.financialapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.financialapp.R

class HomeActivity : AppCompatActivity() {
    private lateinit var tvHome : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var username: String? = intent.getStringExtra("username")

        tvHome.setText(username)
    }
}