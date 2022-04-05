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
        textViewParagraph.background = getDrawable(R.color.white)
        var count = 0
        button.setOnClickListener {
            count++
            when (count) {
                1 -> {
                    textViewParagraph.text = getString(R.string.paragraph_5_a)
                    textViewParagraph.background = getDrawable(R.color.liteGrey)
                    textView.text =
                        getString(R.string.pressedTheButton) + getEmojiByUnicode(0x1F609)
                    val test = TestData(
                        getString(R.string.nameTeacher),
                        getString(R.string.surnameTeacher)
                    )
                    textViewTwo.text = test.name + " " + test.surname + ","
                    textViewTwo.background = getDrawable(R.color.liteGrey)
                    button.text = getString(R.string.further)
                }
                2 -> {
                    textViewParagraph.text = getString(R.string.paragraph_5_b)
                    textViewParagraph.background = getDrawable(R.color.liteGrey)
                    textViewTwo.text =
                        "Свойства объекта: a = " + TestTwo.a.toString() + "; b = " + TestTwo.b.toString() + "."
                    val testThree = TestTwo.copy()
                    textView.text =
                        "Свойства клона: a = " + testThree.a.toString() + "; b = " + testThree.b.toString() + "."
                }
                3 -> {
                    textViewParagraph.text = getString(R.string.paragraph_5_c)
                    textViewParagraph.background = getDrawable(R.color.liteGrey)
                    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    var test = ""
                    var testTwo = ""
                    numbers.forEach { test = "$test $it" }
                    textViewTwo.text = "Массив: $test"
                    numbers.forEach { testTwo = "$testTwo" + it * 2 + " " }
                    textView.text = "Массив Х2: $testTwo"
                }
                4 -> {
                    textViewParagraph.text = ""
                    textViewParagraph.background = getDrawable(R.color.white)
                    textViewTwo.text = ""
                    textViewTwo.background = getDrawable(R.color.white)
                    textView.text = "Пункты из дз закончились" + getEmojiByUnicode(0x1F622)
                    button.text = getString(R.string.exit)
                }
                else -> {
                    finish()
                }
            }
        }
    }

    object TestTwo {
        val a = 20
        val b = 30
        fun copy(/*a: Int = this.a, b: Int = this.b*/) = TestTwo
    }
}

fun getEmojiByUnicode(unicode: Int): String =
    String(Character.toChars(unicode)) // нашел эту функцию на stackoverflow =)
