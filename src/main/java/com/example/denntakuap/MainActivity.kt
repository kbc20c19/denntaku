package com.example.denntakuap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun onClickNumber(v: View?) {
            var btn = v as Button
            var inputNumber = btn.text as String
            if ("00".equals(inputNumber)) {
                value1 = (value1 ?: 0) * 100
            } else {
                value1 = (value1 ?: 0) * 10
            }
            value1 = value1!! + inputNumber.toInt()
            display(String.format("%s %s %s",
                    value2?.toString() ?: "",
                    operator,
                    value1.toString()))
        }

        fun onClickOperator(v: View?) {
            if (value1 != null) {
                var value2 = value1
                value1 = 0
                operator = (v as Button).text.toString()
                display(String.format("%s %s %s",
                        value2.toString(),
                        operator,
                        ""))
            }
        }

        fun onClickEqual(v: View?) {
            if (value1 == null || value2 == null || operator == null) {
                return
            }
            if ("＋".equals(operator)) {
                //足算
                value1 = value2!! + value1!!
            } else if ("−".equals(operator)) {
                //引算
                value1 = value2!! - value1!!
            } else if ("×".equals(operator)) {
                //乗算
                value1 = value2!! * value1!!
            } else if ("÷".equals(operator)) {
                //除算
                value1 = value2!! / value1!!
            }
            display(value1.toString())
            value2 = 0
            operator = ""
        }
    }
    private fun display(value: String) {
        var display = findViewById<TextView>(R.id.display)
        display.text = value.toString()
    }




}

