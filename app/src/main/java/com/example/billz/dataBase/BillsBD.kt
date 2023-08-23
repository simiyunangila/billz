package com.example.billz.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.billz.model.Bill

@Database(entities = [Bill::class], version = 1)
abstract class BillsBD:RoomDatabase() {
    abstract fun billDao():BillDao

    companion object{
        var database:BillsBD?=null

        fun getDataBase(context: Context):BillsBD{

            if (database == null){
                database = Room
                    .databaseBuilder(context,BillsBD::class.java,"BillsBD")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as BillsBD
        }

    }
    }