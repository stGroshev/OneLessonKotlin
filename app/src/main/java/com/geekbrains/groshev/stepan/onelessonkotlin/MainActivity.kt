package com.geekbrains.groshev.stepan.onelessonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.geekbrains.groshev.stepan.onelessonkotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{
            textView.text = "Вы нажали кнопку " + getEmojiByUnicode(0x1F609)
        }
    }
}
fun getEmojiByUnicode(unicode: Int): String = String(Character.toChars(unicode)) // нашел данную функцию на stackoverflow
