package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    val costPerHr = 1.50
    var numberOfHrs: Int = 0
    var totalCharges: Double = 0.00
    var lotChoice = ""





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Hours: EditText = findViewById(R.id.idTxtHours)
        val Group: Spinner = findViewById(R.id.spnGroup)
        val Charges: Button = findViewById(R.id.idCalcButton)
        val Result: TextView = findViewById(R.id.idChargeTotal)

        Charges.setOnClickListener {
            numberOfHrs = Hours.text.toString().toInt()
            val Currency = DecimalFormat("$###,###.00")
            val totalCharges = costPerHr * numberOfHrs.toDouble()
            lotChoice = Group.selectedItem.toString()

            val formattedCharges = Currency.format(totalCharges)
            Result.text = "Cost for parking in $lotChoice for $numberOfHrs hrs is $formattedCharges"
        }

    }
}
