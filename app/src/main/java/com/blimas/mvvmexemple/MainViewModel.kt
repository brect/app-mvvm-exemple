package com.blimas.mvvmexemple

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var mRespository = PersonVO()

    private var mTextWelcome = MutableLiveData<String>()
    var textWelcome = mTextWelcome

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTextWelcome.value = "Olá, usuário"
    }

    fun login(text: String) {
        val ret = mRespository.login(text)
        mLogin.value = ret
    }

}