package com.jovel.practica1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jovel.practica1_2.databinding.ActivityMainBinding
import java.text.DecimalFormat

private const val EURO = "Euro (EUR)"
private const val DOLAR = "Dólar Estadounidense (USD)"
private const val PESOS = "Peso Colombiano (COP)"
private const val preEURO = " EUR"
private const val preDOLAR = " USD"
private const val prePESOS = " COP"

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.turnIntoButton.setOnClickListener {

            val cantidad = mainBinding.amountEditText.text.toString()
            val divisa1 = mainBinding.currencyList1.selectedItem.toString()
            val divisa2 = mainBinding.currencyList2.selectedItem.toString()

            if (cantidad.isNotEmpty()) {
                if (divisa1 == PESOS && divisa2 == PESOS) {
                    mainBinding.amountTextView.text = cantidad + prePESOS
                }
                if (divisa1 == PESOS && divisa2 == DOLAR) {
                    mainBinding.amountTextView.text = (toFourDigits((cantidad.toFloat()*0.0003).toFloat())).toString() + preDOLAR
                }
                if (divisa1 == PESOS && divisa2 == EURO) {
                    mainBinding.amountTextView.text = (toFourDigits((cantidad.toFloat()*0.0002).toFloat())).toString() + preEURO
                }
                if (divisa1 == DOLAR && divisa2 == DOLAR) {
                    mainBinding.amountTextView.text = cantidad + preDOLAR
                }
                if (divisa1 == DOLAR && divisa2 == PESOS) {
                    mainBinding.amountTextView.text = (toFourDigits((cantidad.toFloat()*3554.19).toFloat())).toString() + prePESOS
                }
                if (divisa1 == DOLAR && divisa2 == EURO) {
                    mainBinding.amountTextView.text = (toFourDigits((cantidad.toFloat()*0.84).toFloat())).toString() + preEURO
                }
                if (divisa1 == EURO && divisa2 == EURO) {
                    mainBinding.amountTextView.text = cantidad + preEURO
                }
                if (divisa1 == EURO && divisa2 == PESOS) {
                    mainBinding.amountTextView.text = (toFourDigits((cantidad.toFloat()*4234.29).toFloat())).toString() + prePESOS
                }
                if (divisa1 == EURO && divisa2 == DOLAR) {
                    mainBinding.amountTextView.text = (toFourDigits((cantidad.toFloat()*1.19).toFloat())).toString() + preDOLAR
                }
            }
        }
    }
}