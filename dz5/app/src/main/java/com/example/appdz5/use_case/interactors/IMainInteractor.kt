package com.example.appdz5.use_case.interactors

import io.reactivex.Observable

interface IMainInteractor {
    fun showmessage():Observable<String>
}