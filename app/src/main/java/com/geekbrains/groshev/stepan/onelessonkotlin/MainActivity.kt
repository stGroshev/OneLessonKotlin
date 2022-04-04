package com.geekbrains.groshev.stepan.onelessonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)
        val textViewTwo: TextView = findViewById(R.id.textViewTwo)
        val textViewParagraph: TextView = findViewById(R.id.textViewParagraph)
        var count = 0
        button.setOnClickListener {
            count++
            when (count) {
                1 -> {
                    textViewParagraph.text = getString(R.string.paragraph_5_a)
                    textView.text = getString(R.string.pressedTheButton) + getEmojiByUnicode(0x1F609)
                    val test = TestData(getString(R.string.nameTeacher), getString(R.string.surnameTeacher))
                    textViewTwo.text = test.name + " " + test.surname + ","
                    button.text = getString(R.string.further)
                }
                2 -> {
                    textViewParagraph.text = getString(R.string.paragraph_5_b)
                    textViewTwo.text =
                        "Свойства объекта: a = " + TestTwo.a.toString() + "; b = " + TestTwo.b.toString() + "."
                    val testThree = TestTwo.copy()
                    textView.text =
                        "Свойства клона: a = " + testThree.a.toString() + "; b = " + testThree.b.toString() + "."
                }
                else -> {
                    textViewParagraph.text = ""
                    textViewTwo.text = ""
                    textView.text = "Пункты из дз закончились" + getEmojiByUnicode(0x1F622)
                    button.text = getString(R.string.end)
                }
            }
        }
    }

    object TestTwo {
        val a = 20
        val b = 30
        fun copy(a: Int = this.a, b: Int = this.b) = TestTwo
    }
}

fun getEmojiByUnicode(unicode: Int): String =
    String(Character.toChars(unicode)) // нашел эту функцию на stackoverflow =)

