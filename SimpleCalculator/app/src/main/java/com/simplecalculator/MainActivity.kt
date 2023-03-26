package com.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    var tvInput: TextView? = null
    var opnd: Int = 0
    var operator: Char? = null
    var isOp: Boolean = false
    var lastNum: Boolean = false
    var value0: Int = 0
    var value1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById<TextView>(R.id.tvInput)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)

        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)

        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)

        val btnZero = findViewById<Button>(R.id.btnZero)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnEqual = findViewById<Button>(R.id.btnEqual)


        btnOne.setOnClickListener {
            onDigit(1)
        }
        btnTwo.setOnClickListener {
            onDigit(2)
        }
        btnThree.setOnClickListener {
            onDigit(3)
        }

        btnFour.setOnClickListener {
            onDigit(4)
        }
        btnFive.setOnClickListener {
            onDigit(5)
        }
        btnSix.setOnClickListener {
            onDigit(6)
        }

        btnSeven.setOnClickListener {
            onDigit(7)
        }
        btnEight.setOnClickListener {
            onDigit(8)
        }
        btnNine.setOnClickListener {
            onDigit(9)
        }
        btnZero.setOnClickListener {
            onDigit(0)
        }

        btnAdd.setOnClickListener {
            onOperator('+')
        }
        btnSub.setOnClickListener {
            onOperator('-')
        }
        btnMultiply.setOnClickListener {
            onOperator('*')
        }
        btnDivide.setOnClickListener {
            onOperator('/')
        }

        btnClear.setOnClickListener {
            onClear()
        }
        btnEqual.setOnClickListener {
            onEqual()
        }


    }

    fun onDigit(num: Int) {
        opnd = opnd * 10 + num
        tvInput?.setText("" + opnd)
        lastNum = true
    }

    fun onOperator(op: Char) {
        if (lastNum) {
            operator = op
            lastNum = false
            value0 = opnd
            opnd = 0
        }
    }

    fun onEqual() {

        value1 = opnd
        when (operator) {
            '+' -> {
                opnd = value0 + value1
                tvInput?.setText("" + opnd)
            }
            '-' -> {
                opnd = value0 - value1
                tvInput?.setText("" + opnd)
            }
            '*' -> {
                opnd = value0 * value1
                tvInput?.setText("" + opnd)
            }
            '/' -> {

                tvInput?.setText("" + (value0.toDouble() / value1.toDouble()))
            }
            else -> tvInput?.setText("" + opnd)
        }
        opnd=0
        value0 = 0
        operator = null
    }

    fun onClear() {
        opnd = 0
        value0 = 0
        operator = null
        tvInput?.setText("0")
    }


}