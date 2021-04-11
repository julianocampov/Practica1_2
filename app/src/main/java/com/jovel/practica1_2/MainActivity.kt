package com.jovel.practica1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jovel.practica1_2.databinding.ActivityMainBinding

private const val EURO = "Euro (EUR)"
private const val DOLAR = "Dólar Estadounidense (USD)"
private const val PESOS = "Peso Colombiano (COP)"

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
                    mainBinding.amountTextView.text = cantidad + "  COP"
                }
                if (divisa1 == PESOS && divisa2 == DOLAR) {
                    mainBinding.amountTextView.text = (cantidad.toFloat() * 0.0003).toString() + "  USD"
                }
                if (divisa1 == PESOS && divisa2 == EURO) {
                    mainBinding.amountTextView.text = (cantidad.toFloat() * 0.0002).toString() + "  EUR"
                }
                if (divisa1 == DOLAR && divisa2 == DOLAR) {
                    mainBinding.amountTextView.text = cantidad + "  USD"
                }
                if (divisa1 == DOLAR && divisa2 == PESOS) {
                    mainBinding.amountTextView.text = (cantidad.toFloat() * 3554.19).toString() + "  COP"
                }
                if (divisa1 == DOLAR && divisa2 == EURO) {
                    mainBinding.amountTextView.text = (cantidad.toFloat() * 0.84).toString() + "  EUR"
                }
                if (divisa1 == "Euro (EUR)" && divisa2 == EURO) {
                    mainBinding.amountTextView.text = cantidad + "  EUR"
                }
                if (divisa1 == EURO && divisa2 == "Peso Colombiano (COP)") {
                    mainBinding.amountTextView.text = (cantidad.toFloat() * 4234.29).toString() + "  COP"
                }
                if (divisa1 == EURO && divisa2 == "Dólar Estadounidense (USD)") {
                    mainBinding.amountTextView.text = (cantidad.toFloat() * 1.19).toString() + "  USD"
                }
            }
        }
    }
}