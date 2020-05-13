package com.sqisland.android.espresso.hermetic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Extract the DateTime dependence. Cast GreetingApplication class as application.
    //The testing framework has a mechanism to instantiate a different application during the test.
    //So, we put the DateTime() class into a different application
    val app = application as GreetingApplication
    val clock = app.provideClock()
    val now = clock.getClock()

    val greetingId = when (now.hourOfDay) {
      in 5..12 -> R.string.greeting_morning
      in 12..17 -> R.string.greeting_afternoon
      in 17..23 -> R.string.greeting_evening
      else -> R.string.greeting_night
    }

    val greetingView = findViewById<TextView>(R.id.greeting)
    greetingView.setText(greetingId)
  }
}