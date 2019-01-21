package com.andreguedes.espressotest.login

import com.andreguedes.espressotest.R
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Test

class LoginPresenterTest {

    @Test
    fun doLogin_withEmptyUsernameAndPassword_callsShowErrorMessage() {
        val view = mock<LoginContract.View>()
        val presenter = LoginPresenter(view)

        presenter.doLogin("", "")

        verify(view).showMessage(R.string.fields_msg_error)
    }

    @Test
    fun doLogin_withEmptyUsername_callsShowErrorMessage() {
        val view = mock<LoginContract.View>()
        val presenter = LoginPresenter(view)

        presenter.doLogin("", "pass")

        verify(view).showMessage(R.string.username_msg_error)
    }

    @Test
    fun doLogin_withEmptyPassword_callsShowErrorMessage() {
        val view = mock<LoginContract.View>()
        val presenter = LoginPresenter(view)

        presenter.doLogin("user", "")

        verify(view).showMessage(R.string.password_msg_error)
    }

    @Test
    fun doLogin_withCorrectUsernameAndPassword_callsShowNextScreen() {
        val view = mock<LoginContract.View>()
        val presenter = LoginPresenter(view)

        presenter.doLogin("user", "pass")

        verify(view).goToMain()
    }

}