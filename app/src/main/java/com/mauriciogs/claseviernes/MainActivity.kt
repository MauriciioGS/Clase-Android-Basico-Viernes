package com.mauriciogs.claseviernes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.mauriciogs.claseviernes.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        val view = binding.root
        setContentView(view)
        inicializa()
    }

    private fun inicializa() {
        lifecycleScope.launchWhenStarted {
            binding.progressCircular.isVisible = true
            delay(3000)
            binding.progressCircular.isVisible = false
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, PrimerFragment())
                .commit()
        }


    }
}