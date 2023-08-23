package com.example.billz.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billz.Repository.BillRepo
import com.example.billz.model.Bill
import kotlinx.coroutines.launch

class BillsViewModel:ViewModel() {
    val billsRepo = BillRepo()


    fun  saveBill(bill: Bill){
        viewModelScope.launch {
            billsRepo.saveBill(bill)
        }
    }
}