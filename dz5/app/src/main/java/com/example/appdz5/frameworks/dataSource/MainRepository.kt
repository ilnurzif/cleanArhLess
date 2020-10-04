package com.example.appdz5.frameworks.dataSource

import android.content.Context
import android.content.SharedPreferences
import com.example.appdz5.use_case.interactors.MainInteractor
import com.example.appdz5.use_case.repository.IMainRepository
import io.reactivex.Observable


class MainRepository constructor(val context:Context):IMainRepository {
   val startNumberNamePref:String="startNumber"

  fun readStartNumberM(): Int {
        val mySharedPreferences:SharedPreferences = context.getSharedPreferences(startNumberNamePref, Context.MODE_PRIVATE);
        var startNumber=mySharedPreferences.getInt(startNumberNamePref,0)
        saveActivityPreferences(startNumber)
        return startNumber
    }

    fun saveActivityPreferences(startNumb:Int) {
        val preferences: SharedPreferences = context.getSharedPreferences(startNumberNamePref,0)
        val editor = preferences.edit()
        val newStartNumber=startNumb+1
        editor.putInt(startNumberNamePref, newStartNumber)
        editor.commit()
    }

    override fun readStartNumber(startNumberObserver: MainInteractor.StartNumberObserver): Observable<Int> {
            return Observable.create<Int> {it ->
               val sn=readStartNumberM()
               it.onNext(sn)
               it.onComplete()
            }
    }
}