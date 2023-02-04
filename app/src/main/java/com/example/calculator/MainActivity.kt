package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        callbackFun()

    }

    private fun callbackFun ()
    {
        binding.buttonClear.setOnClickListener {
            binding.input.text=""
            binding.output.text=""
        }
        binding.buttonAc.setOnClickListener {
            val removedLast= binding.input.text.toString().dropLast(1)
            binding.input.text=removedLast
        }
        binding.buttonBracket.setOnClickListener {
            binding.input.text=addToInputText("(")
        }
        binding.buttonBracketR.setOnClickListener {
            binding.input.text=addToInputText(")")
        }

        binding.button0.setOnClickListener {
            binding.input.text=addToInputText("0")
        }
        binding.button1.setOnClickListener {
            binding.input.text=addToInputText("1")
        }
        binding.button2.setOnClickListener {
            binding.input.text=addToInputText("2")
        }
        binding.button3.setOnClickListener {
            binding.input.text=addToInputText("3")
        }
        binding.button4.setOnClickListener {
            binding.input.text=addToInputText("4")
        }
        binding.button5.setOnClickListener {
            binding.input.text=addToInputText("5")
        }
        binding.button6.setOnClickListener {
            binding.input.text =addToInputText("6")
        }
        binding.button7.setOnClickListener {
            binding.input.text=addToInputText("7")
        }
        binding.button8.setOnClickListener {
            binding.input.text=addToInputText("8")
        }
        binding.button9.setOnClickListener {
            binding.input.text=addToInputText("9")
        }
        binding.ButtonDot.setOnClickListener {
            binding.input.text=addToInputText(".")
        }
        binding.buttonPlus.setOnClickListener {
            binding.input.text=addToInputText("+")
        }
        binding.buttonMultiply.setOnClickListener {
            binding.input.text=addToInputText("*")
        }
        binding.buttonSubtraction.setOnClickListener {
            binding.input.text=addToInputText("-")
        }
        binding.buttonDivision.setOnClickListener {
            binding.input.text=addToInputText("/")
        }
        binding.buttonEqual.setOnClickListener {
            showResult()
        }
    }


    private fun showResult() {
        try {
            val expression=getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN())
            {
                // show error message
                binding.output.text= " "
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.red))

            }else{
                //show Result
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this,R.color.green))

            }
        }catch (e: Exception)
        {

        }
    }

    private fun getInputExpression():String {
        var expression = binding.input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression

    }

    private fun addToInputText(buttonValue: String): String
    {
        return binding.input.text.toString()+ "" +buttonValue
    }
}