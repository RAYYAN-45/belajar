package id.ac.pnm.konversisuhu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val InputNilai = findViewById<EditText>(R.id.Inputnilai)
        val Hasil = findViewById<TextView>(R.id.Hasil)
        val BtnCelciustoReamur = findViewById<Button>(R.id.BtnCelciustoReamur)
        val BtnReamurtoCelcius = findViewById<Button>(R.id.BtnReamurtoCelcius)
        val BtnCelciustoFahrenheit = findViewById<Button>(R.id.BtnCelciustoFahrenheit)
        val BtnFahrenheittoCelcius = findViewById<Button>(R.id.BtnFahrenheittoCelcius)
        val BtnFahrenheittoReamur = findViewById<Button>(R.id.BtnFahrenheittoReamur)
        val BtnReamurtoFahrenheit = findViewById<Button>(R.id.BtnReamurtoFahrenheit)

        fun CelciustoReamur(Celcius: Double): Double{
            return Celcius * 4 / 5
        }

        fun ReamurtoCelcius(Reamur: Double): Double{
            return Reamur * 5 / 4
        }

        fun Celciustofahrenheit(Celcius: Double): Double {
            return Celcius * 9 / 5 + 32
        }

        fun FahrenheittoCelcius(Fahrenheit: Double): Double{
            return (Fahrenheit - 32) * 5/9
        }

        fun FahrenheittoReamur(Fahrenheit: Double): Double{
            return (Fahrenheit - 32) * 4 / 9
        }

        fun ReamurtoFahrenheit(Reamur: Double): Double{
            return Reamur * 9 / 4 + 32
        }

        fun Konversi(resultUnit: String, rumus: (Double)-> Double){
            val nilaiInput = InputNilai.text.toString().toDoubleOrNull()

            if (nilaiInput!=null){
                val result = rumus(nilaiInput)
                Hasil.text = String.format("%.1f %s", result, resultUnit)
            }
            else {
                Hasil.text = "0"
            }
        }

        BtnCelciustoReamur.setOnClickListener {
            Konversi(resultUnit = "°R", ::CelciustoReamur)
        }

        BtnReamurtoCelcius.setOnClickListener {
            Konversi(resultUnit = "°C", ::ReamurtoCelcius)
        }

        BtnCelciustoFahrenheit.setOnClickListener {
                Konversi(resultUnit = "°F", ::Celciustofahrenheit)
        }

        BtnFahrenheittoCelcius.setOnClickListener {
                Konversi(resultUnit = "°C", ::FahrenheittoCelcius)
        }

        BtnFahrenheittoReamur.setOnClickListener {
                Konversi(resultUnit = "°R", ::FahrenheittoReamur)
        }

        BtnReamurtoFahrenheit.setOnClickListener {
                Konversi(resultUnit = "°F", ::ReamurtoFahrenheit)
        }

    }
}