package com.example.appdz5.frameworks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appdz5.R
import com.example.appdz5.frameworks.dataSource.MainRepository
import com.example.appdz5.interface_adapter.presenters.IMainPresenter
import com.example.appdz5.interface_adapter.presenters.MainPresenter
import com.example.appdz5.interface_adapter.view.IMainView
import com.example.appdz5.use_case.interactors.MainInteractor

class MainActivity : AppCompatActivity(), IMainView {
    lateinit var mainPresenter: IMainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainRepository=MainRepository(this)
        mainPresenter=MainPresenter(MainInteractor(mainRepository),this)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.onStart()
    }

    override fun showMessage(msg: String) {
       Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}