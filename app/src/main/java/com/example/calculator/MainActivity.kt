package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var button0: Button? = null
    var button1: Button? = null
    var button2: Button? = null
    var button3: Button? = null
    var button4: Button? = null
    var button5: Button? = null
    var button6: Button? = null
    var button7: Button? = null
    var button8: Button? = null
    var button9: Button? = null
    var buttonAdd: Button? = null
    var buttonSubstract: Button? = null
    var buttonMul: Button? = null
    var buttonDiv: Button? = null
    var buttonClear: Button? = null
    var buttonEqual: Button? = null
    var result: String? = null
    var tmp: String? = null
    var operator: String? = null
    var resultTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
        initControlListener()
    }

    private fun initControlListener() {
        button0!!.setOnClickListener { onNumberButtonClicked("0") }
        button1!!.setOnClickListener { onNumberButtonClicked("1") }
        button2!!.setOnClickListener { onNumberButtonClicked("2") }
        button3!!.setOnClickListener { onNumberButtonClicked("3") }
        button4!!.setOnClickListener { onNumberButtonClicked("4") }
        button5!!.setOnClickListener { onNumberButtonClicked("5") }
        button6!!.setOnClickListener { onNumberButtonClicked("6") }
        button7!!.setOnClickListener { onNumberButtonClicked("7") }
        button8!!.setOnClickListener { onNumberButtonClicked("8") }
        button9!!.setOnClickListener { onNumberButtonClicked("9") }
        buttonClear!!.setOnClickListener { onClearButtonClicked() }
        buttonSubstract!!.setOnClickListener { onOperatorButtonClicked("-") }
        buttonAdd!!.setOnClickListener { onOperatorButtonClicked("+") }
        buttonMul!!.setOnClickListener { onOperatorButtonClicked("X") }
        buttonDiv!!.setOnClickListener { onOperatorButtonClicked("/") }
        buttonEqual!!.setOnClickListener { onEqualButtonClicked() }
    }

    private fun onEqualButtonClicked() {
        var res = 0
        try {
            val number = Integer.valueOf(tmp)
            val number2 = Integer.valueOf(resultTextView!!.text.toString())
            when (operator) {
                "+" -> res = number + number2
                "/" -> res = number / number2
                "-" -> res = number - number2
                "X" -> res = number * number2
            }
           // tmp=tmp.toString()
            result = res.toString()
            resultTextView!!.text = result
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun onOperatorButtonClicked(operator: String) {
        tmp = resultTextView!!.text.toString()
        //resultTextView!!.text=tmp
        onClearButtonClicked()
        this.operator = operator


    }

    private fun onClearButtonClicked() {
        result = ""
        resultTextView!!.text = ""
    }

    private fun onNumberButtonClicked(pos: String) {
        result = resultTextView!!.text.toString()
        result = result + pos
        resultTextView!!.text = result
    }

    private fun initControl() {
        button0 = findViewById(R.id.button0) as Button
        button1 = findViewById(R.id.button1) as Button
        button2 = findViewById(R.id.button2) as Button
        button3 = findViewById(R.id.button3) as Button
        button4 = findViewById(R.id.button4) as Button
        button5 = findViewById(R.id.button5) as Button
        button6 = findViewById(R.id.button6) as Button
        button7 = findViewById(R.id.button7) as Button
        button8 = findViewById(R.id.button8) as Button
        button9 = findViewById(R.id.button9) as Button
        buttonAdd = findViewById(R.id.buttonAdd) as Button
        buttonClear = findViewById(R.id.buttonClear) as Button
        buttonSubstract = findViewById(R.id.buttonSub) as Button
        buttonMul = findViewById(R.id.buttonMul) as Button
        buttonDiv = findViewById(R.id.buttonDiv) as Button
        buttonEqual = findViewById(R.id.buttonEqual) as Button
        resultTextView = findViewById(R.id.text_view_result) as TextView

}
}