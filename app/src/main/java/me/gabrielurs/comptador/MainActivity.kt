package me.gabrielurs.comptador

import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private val INITIAL_TIME = 3
    private val TAG = MainActivity::class.java.simpleName;
    internal lateinit var tapMeButton: Button
    internal lateinit var timeTextView: TextView
    internal lateinit var counterTextView: TextView
    internal var counter = 0
    internal var time = INITIAL_TIME

    internal  var appStarted = false
    internal lateinit var countdownTimer : CountDownTimer
    // internal val initialCountDownTimer: Long = 60000
    internal val initialCountDownTimer: Long = time.toLong()*1000
    internal val intervalCountDownTimer: Long = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Hola mon! onCreate")
        Log.d(TAG,counter.toString())
        Log.d(TAG,time.toString())


        initCountdown();

        tapMeButton = findViewById(R.id.tapMeButton)
        timeTextView = findViewById(R.id.timeTextView)
        counterTextView = findViewById(R.id.counterTextView)
        // TODO Actualitzar o definir valor inicial del contextTextview -> counterTextView = score -> 0
        // TODO en algun momoent haurem d'executar incrementCounter
        tapMeButton.setOnClickListener{
            if(!appStarted){
                startGame();

            }
            incrementCounter()
            //TODO -> iniciar el comptador
        }
        //timeTextView.text = time.toString();
        timeTextView.text = getString(R.string.timeTextView, time)
    }

    private fun startGame() {
        countdownTimer.start()
        appStarted=true
    }

    private fun initCountdown(){
        countdownTimer = object : CountDownTimer(initialCountDownTimer, intervalCountDownTimer){
            override fun onTick(milliUntilFinished: Long) {
                val timeLeft = milliUntilFinished / 1000
                timeTextView.text = timeLeft.toString();
            }

            override fun onFinish() {
                endGame()
            }
        }

    }
    private fun incrementCounter(){
        counter += 1;
        counterTextView.text = counter.toString();
    }

    private fun endGame(){
        Toast.makeText(this,getString(R.string.endGame,counter), Toast.LENGTH_LONG).show()
        resetGame()
    }

    private fun resetGame(){
       //TODO
        counter = 0
       counterTextView = findViewById(R.id.counterTextView)
        time = INITIAL_TIME
        timeTextView.text = time.toString()
        initCountdown();
        appStarted = false;
    }
}