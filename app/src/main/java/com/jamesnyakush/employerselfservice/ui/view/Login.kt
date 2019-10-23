package com.jamesnyakush.employerselfservice.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jamesnyakush.employerselfservice.R
import kotlinx.android.synthetic.main.login_activity.*

class Login : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        login_register.setOnClickListener(this)
        login_activity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login_register -> {
                startActivity(Intent(Login@ this, Register::class.java))
            }
            R.id.login_activity -> {
                startActivity(Intent(Login@ this, MainActivity::class.java))
            }
        }
    }
}
