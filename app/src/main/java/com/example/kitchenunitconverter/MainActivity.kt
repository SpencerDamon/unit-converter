package com.example.kitchenunitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kitchenunitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convertButton.setOnClickListener{ convertUnits() }
    }

    fun convertUnits () {
        val stringInTextField = binding.amountToConvert.text.toString()
        val amountToConvert = stringInTextField.toFloat()
        val selectedUnitId = binding.conversionOptions.checkedRadioButtonId
        val convertUnit = when (selectedUnitId) {
            R.id.option_ml_to_fl_oz -> 0.033814
            R.id.option_fl_oz_to_ml -> 29.574
            R.id.option_grams_to_ounces -> 0.353
            else -> 28.3495
        }
        var convertedAmount = convertUnit * amountToConvert

        val round = binding.roundUpSwitch.isChecked
        if (round) {
            convertedAmount = kotlin.math.round(convertedAmount)
        }
    }
}
