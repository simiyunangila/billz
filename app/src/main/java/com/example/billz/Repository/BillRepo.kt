package com.example.billz.Repository

import com.example.billz.BillApp
import com.example.billz.dataBase.BillsBD
import com.example.billz.model.Bill
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BillRepo {
    val db = BillsBD.getDataBase(BillApp.appContext)
    val billDao = db.billDao()


   suspend fun saveBill(bill: Bill){
        withContext(Dispatchers.IO){
            billDao.insertBill(bill)
        }
    }
}