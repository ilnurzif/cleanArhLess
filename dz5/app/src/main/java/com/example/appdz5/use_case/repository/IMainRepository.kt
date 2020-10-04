package com.example.appdz5.use_case.repository

import com.example.appdz5.use_case.interactors.MainInteractor
import io.reactivex.Observable

interface IMainRepository {
    fun readStartNumber(startNumberObserver: MainInteractor.StartNumberObserver): Observable<Int>
}