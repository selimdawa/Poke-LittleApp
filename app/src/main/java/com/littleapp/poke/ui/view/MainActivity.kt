package com.littleapp.poke.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.littleapp.poke.R
import com.littleapp.poke.Unit.THEME
import com.littleapp.poke.domain.SelectedListener

class MainActivity : AppCompatActivity(), SelectedListener {

    var context = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(context)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSelected(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}