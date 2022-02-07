package parra.daniel.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var maxValue = 100
    var minValue = 0
    var num: Int = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val guessed: Button = findViewById(R.id.guessed)
        val generate: Button = findViewById(R.id.generate)

        generate.setOnClickListener {
            num = Random.nextInt(minValue, maxValue)
            guessings.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else {
                guessings.setText("No puede ser, me ganaste")
            }
        }

        down.setOnClickListener {
            maxValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else {
                guessings.setText("No puede ser, me ganaste")
            }
        }

        guessed.setOnClickListener {
            if (!won) {
                guessings.setText("Adivine, tu numero es el " + num)
                guessed.setText("Volver a jugar")
                won = true
            } else {
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.visibility = View.GONE
                resetValues()
            }
        }

    }

    fun resetValues() {
        var maxValue = 100
        var minValue = 0
        var num: Int = 0
        var won = false
    }

    fun checkingLimits(): Boolean {
        return minValue != maxValue
    }



}