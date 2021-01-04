package com.esther.covidmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LandingActivity : AppCompatActivity() {
    private val myScope = object: CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = Job()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}