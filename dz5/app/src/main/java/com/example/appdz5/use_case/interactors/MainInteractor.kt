package com.example.appdz5.use_case.interactors

import com.example.appdz5.use_case.repository.IMainRepository
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainInteractor constructor(val repository:IMainRepository) : IMainInteractor  {

     fun getStartNumber() {
         repository.readStartNumber(StartNumberObserver(this)).doOnNext(showmessage())
     }

     override fun showmessage(): Observable<String> {
  //       getStartNumber()
         return Observable.create<String> {}
     }

     class StartNumberObserver constructor(val mainInteractor: IMainInteractor): Observer<Int> {
         override fun onSubscribe(d: Disposable) {
         }

         override fun onNext(t: Int) {
         //   if (t==2||((t-2) % 4==0)) {
                mainInteractor.showmessage().doOnNext { "Поставьте лайк в google play" }
                mainInteractor.showmessage().doOnComplete{}
          //  }
         }
         override fun onError(e: Throwable) { }
         override fun onComplete() {}
     }

 }