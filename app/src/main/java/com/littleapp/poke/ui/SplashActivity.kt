package com.littleapp.poke.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.littleapp.poke.databinding.ActivitySplashBinding
import com.littleapp.poke.ui.view.MainActivity
import com.littleapp.poke.utils.applyAppTheme
import com.littleapp.poke.utils.launchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        applyAppTheme()
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(2000.milliseconds)
            launchActivity<MainActivity>(finishCaller = true)
        }
    }
}