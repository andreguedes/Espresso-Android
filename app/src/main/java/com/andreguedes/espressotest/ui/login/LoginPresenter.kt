package com.andreguedes.espressotest.ui.login

import com.andreguedes.espressotest.R

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    override fun doLogin(username: String, password: String) {
        if (username.isEmpty() && password.isEmpty()) {
            view.showMessage(R.string.fields_msg_error)
            return
        }
        if (username.isEmpty()) {
            view.showMessage(R.string.username_msg_error)
            return
        }
        if (password.isEmpty()) {
            view.showMessage(R.string.password_msg_error)
            return
        }
        view.goToMain()
    }

}
