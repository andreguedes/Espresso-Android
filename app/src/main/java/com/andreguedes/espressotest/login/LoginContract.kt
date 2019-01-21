package com.andreguedes.espressotest.login

interface LoginContract {

    interface View {
        fun showMessage(msg: Int)
        fun goToMain()
    }

    interface Presenter {
        fun doLogin(username: String, password: String)
    }

}
