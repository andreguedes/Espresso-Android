package com.andreguedes.espressotest.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import android.support.v7.app.AlertDialog
import com.andreguedes.espressotest.R

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        btn_sign_in.setOnClickListener {
            presenter.doLogin(edt_username.text.toString(), edt_password.text.toString())
        }
    }

    override fun showMessage(msg: Int) {
        AlertDialog.Builder(this)
            .setTitle(R.string.alert)
            .setMessage(msg)
            .setPositiveButton(R.string.ok) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    override fun goToMain() {
        Toast.makeText(this, "Go to next screen!", Toast.LENGTH_SHORT).show()
    }

}
