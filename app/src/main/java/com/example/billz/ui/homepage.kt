package com.example.billz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billz.R
import com.example.billz.databinding.ActivityHomepageBinding

class homepage : AppCompatActivity() {
    lateinit var binding: ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNav()
    }

    fun setUpBottomNav() {
        binding.bnvHome.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.summary -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,SummaryFragment())
                        .commit()
                    true

                }

                R.id.upcomming -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,UpcomingFragment())
                        .commit()
                    true
                }

                R.id.settings -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,SettingFragment())
                        .commit()
                    true

                }

                R.id.paid -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fcvHome,PaidFragment())
                        .commit()
                    true

                }
                else->{
                    false
                }
            }
        }

    }
}