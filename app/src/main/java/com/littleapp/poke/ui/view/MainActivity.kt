package com.littleapp.poke.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.littleapp.poke.databinding.ActivityMainBinding
import com.littleapp.poke.utils.THEME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
