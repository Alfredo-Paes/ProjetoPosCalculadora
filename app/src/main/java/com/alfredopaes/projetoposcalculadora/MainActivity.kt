package com.alfredopaes.projetoposcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.alfredopaes.projetoposcalculadora.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val btn0 = binding.btn0
        val btn1 = binding.btn1
        val btn2 = binding.btn2
        val btn3 = binding.btn3
        val btn4 = binding.btn4
        val btn5 = binding.btn5
        val btn6 = binding.btn6
        val btn7 = binding.btn7
        val btn8 = binding.btn8
        val btn9 = binding.btn9
        val btnClear = binding.btnClear
        val btnAddition = binding.btnAddition
        val btnSubtraction = binding.btnSubtraction
        val btnDivision = binding.btnDivision
        val btnMultiplication = binding.btnMultiplication
        val btnDot = binding.btnDot
        val btnBackSpace = binding.btnBackspace
        val btnEqual = binding.btnEqual

        btn0.setOnClickListener {
            addExpression("0", true)
        }
        btn1.setOnClickListener {
            addExpression("1", true)
        }
        btn2.setOnClickListener {
            addExpression("2", true)
        }
        btn3.setOnClickListener {
            addExpression("3", true)
        }
        btn4.setOnClickListener {
            addExpression("4", true)
        }
        btn5.setOnClickListener {
            addExpression("5", true)
        }
        btn6.setOnClickListener {
            addExpression("6", true)
        }
        btn7.setOnClickListener {
            addExpression("7", true)
        }
        btn8.setOnClickListener {
            addExpression("8", true)
        }
        btn9.setOnClickListener {
            addExpression("9", true)
        }
        btnDot.setOnClickListener {
            addExpression(".", true)
        }
        btnClear.setOnClickListener {
            clear()
        }
        btnBackSpace.setOnClickListener {
            backSpace()
        }
        btnEqual.setOnClickListener {
            equal()
        }
        btnAddition.setOnClickListener {
            addExpression("+", false)
        }
        btnSubtraction.setOnClickListener {
            addExpression("-", false)
        }
        btnMultiplication.setOnClickListener {
            addExpression("*", false)
        }
        btnDivision.setOnClickListener {
            addExpression("/", false)
        }
    }

    private fun clear() {
        val result = binding.result
        val expression = binding.expression
        expression.text = ""
        result.text = ""
    }

    private fun backSpace() {
        val result = binding.result
        val expression = binding.expression
        val string = expression.text.toString()

        if (string.isNotBlank()) {
            expression.text = string.substring(0, string.length-1)
        }
        result.text = ""
    }

    private fun equal() {
        val result = binding.result
        val expression = binding.expression

        try {
            val expressionBuilder = ExpressionBuilder(expression.text.toString()).build()
            val resultEvaluate = expressionBuilder.evaluate()
            val longResult = resultEvaluate.toLong()

            if (resultEvaluate == longResult.toDouble()) result.text = longResult.toString()
            else result.text = resultEvaluate.toString()

        } catch (e: Exception) {
            Log.i("Error", "$e")
        }
    }



    private fun addExpression(string: String, clearData: Boolean) {
        val result = binding.result
        val expression = binding.expression

        if (result.text.isNotEmpty()) expression.text = ""

        if (clearData) {
            result.text = ""
            expression.append(string)
        } else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }




}