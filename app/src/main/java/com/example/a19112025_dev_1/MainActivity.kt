package com.example.a19112025_dev_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a19112025_dev_1.fragments.RegisterFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main, RegisterFragment())
            .commit()
    }
}