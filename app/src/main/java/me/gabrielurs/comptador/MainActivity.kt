package me.gabrielurs.comptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton: Button
    internal lateinit var timeTextView: TextView
    internal lateinit var counterTextView: TextView
    internal var counter = 0
    internal var time = 60


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.tapMeButton)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)
        // TODO Actualitzar o definir valor inicial del contextTextview -> counterTextView = score -> 0
        // TODO en algun momoent haurem d'executar incrementCounter
        tapMeButton.setOnClickListener{
            incrementCounter()
            //TODO -> iniciar el comptador
        }
        //timeTextView.text = time.toString();
        timeTextView.text = getString(R.string.timeTextView, time)
    }
    private fun incrementCounter(){
        counter += 1;
        counterTextView.text = counter.toString();
    }
}