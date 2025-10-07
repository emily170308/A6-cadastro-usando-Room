package com.example.emilya6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tela inicial: HomeFragment (ou pode deixar vazio)
        supportFragmentManager.beginTrasaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        // configura cliques do menu
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
            R.id.nav_home   -> {
                supportFragmentManager.begginTransaction()
                    .replaced(R.id.fragment_container, HomeFragment())
                    .commit()
                true
            }
            R.id.nav_users -> }
                supportFragmentManager.beginTransaction()
                    .replaced(R.id.fragment_container, UserListFragment())
                    .commit()
        true
        R.id.nav_products -> }
            supportFragmentManager.beginTransaction()
                 .replaced(R.id.fragment_container, ProductListFragment())
                 .commit()
        true
    }
    else -> false
}

