package com.andreguedes.espressotest.ui.login

import com.andreguedes.espressotest.R
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class LoginPresenterTest {

    lateinit var view: LoginContract.View
    lateinit var presenter: LoginContract.Presenter

    @Before
    fun setup() {
        view = mock()
        presenter = LoginPresenter(view)
    }

    @Test
    fun doLogin_withEmptyUsernameAndPassword_callsShowErrorMessage() {
        presenter.doLogin("", "")

        verify(view).showMessage(R.string.fields_msg_error)
        verify(view, never()).goToMain()
    }

    @Test
    fun doLogin_withEmptyUsername_callsShowErrorMessage() {
        presenter.doLogin("", "pass")

        verify(view).showMessage(R.string.username_msg_error)
        verify(view, never()).goToMain()
    }

    @Test
    fun doLogin_withEmptyPassword_callsShowErrorMessage() {
        presenter.doLogin("user", "")

        verify(view).showMessage(R.string.password_msg_error)
        verify(view, never()).goToMain()
    }

    @Test
    fun doLogin_withCorrectUsernameAndPassword_callsShowNextScreen() {
        presenter.doLogin("user", "pass")

        verify(view).goToMain()
    }

}
