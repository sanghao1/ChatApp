package com.example.ChatApp

import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ChatApp.Fragments.HeartFragment
import com.example.ChatApp.Fragments.HomeFragment
import com.example.ChatApp.Fragments.ProfileFragment
import com.example.ChatApp.Fragments.SearchFragment
import com.example.instargramclone.R
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import org.w3c.dom.Text
import java.security.PrivateKey

class MainActivity : AppCompatActivity() {

    internal var selectedFragment: Fragment? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {

               selectedFragment=HomeFragment()
            }
            R.id.nav_search -> {

                selectedFragment=SearchFragment()
            }
            R.id.nav_add_post -> {

                selectedFragment=HomeFragment()
            }
            R.id.nav_heart -> {


                selectedFragment=HeartFragment()
            }
            R.id.nav_profile -> {


                selectedFragment=ProfileFragment()
            }
        }
        if(selectedFragment != null){
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
              selectedFragment!!
            ).commit()

        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }
}