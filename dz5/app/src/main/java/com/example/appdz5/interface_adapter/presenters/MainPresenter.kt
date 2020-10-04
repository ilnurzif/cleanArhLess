package com.example.appdz5.interface_adapter.presenters

import com.example.appdz5.interface_adapter.view.IMainView
import com.example.appdz5.use_case.interactors.IMainInteractor
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainPresenter constructor(val mainInteractor: IMainInteractor, val mainView: IMainView): IMainPresenter {

    override fun onStart() {
       // mainInteractor.getStartNumber().subscribe(
         //   StartNumberObserver(mainView))
        mainInteractor.showmessage().subscribe(StartNumberObserver(mainView))
    }

    override fun onStop() {

    }

    override fun onUserAction() {

    }

    class StartNumberObserver constructor(val view:IMainView): Observer<String> {
        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(str: String) {
         //   if (t==2||((t-2) % 4==0))
                view.showMessage(str)
        }
        override fun onError(e: Throwable) { }
        override fun onComplete() {}
    }

}