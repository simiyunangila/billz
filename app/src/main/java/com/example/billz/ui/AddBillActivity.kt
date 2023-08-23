package com.example.billz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.example.billz.R
import com.example.billz.ViewModel.BillsViewModel
import com.example.billz.databinding.ActivityAddBillBinding
import java.util.UUID

class AddBillActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBillBinding
    val billsViewModel: BillsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBillBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setupFreqSpinner()
        setupDueDAteAdapter()
    }
    fun setupFreqSpinner(){
        val adapter = ArrayAdapter.createFromResource(this,R.array.frequencies,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spfrequency.adapter=adapter
    }
    fun setupDueDAteAdapter(){
        val weeklyAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item, arrayOf(1,2,3,4,5,6,7))
        weeklyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter = weeklyAdapter




        val build =UUID.randomUUID().toString()
    }
}