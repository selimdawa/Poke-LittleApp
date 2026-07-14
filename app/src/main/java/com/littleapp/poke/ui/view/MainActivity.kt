package com.littleapp.poke.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.littleapp.poke.databinding.ActivityMainBinding
import com.littleapp.poke.utils.applyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        applyAppTheme()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}