package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var editPanjang: EditText
    private lateinit var editLebar: EditText
    private lateinit var editTinggi: EditText
    private lateinit var hasil: TextView
    private lateinit var btnHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editPanjang = findViewById(R.id.editPanjang)
        editLebar = findViewById(R.id.editLebar)
        editTinggi = findViewById(R.id.editTinggi)
        hasil = findViewById(R.id.hasil)
        btnHitung = findViewById(R.id.btnHitung)

        btnHitung.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val panjang = editPanjang.text.toString().trim()
        val lebar = editLebar.text.toString().trim()
        val tinggi = editTinggi.text.toString().trim()

        val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
        hasil.text = "$volume"
    }
}