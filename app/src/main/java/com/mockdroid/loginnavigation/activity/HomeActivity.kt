package com.mockdroid.loginnavigation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.mockdroid.loginnavigation.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navController = Navigation.findNavController(this, R.id.home_nav_host_fragment)
        NavigationUI.setupWithNavController(bottom_navigation, navController)
    }
}