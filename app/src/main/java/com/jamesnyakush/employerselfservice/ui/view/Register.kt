package com.jamesnyakush.employerselfservice.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jamesnyakush.employerselfservice.R
import kotlinx.android.synthetic.main.register_activity.*

class Register : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        register_login.setOnClickListener(this)
        register_activity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.register_login -> {
                startActivity(Intent(Register@ this, Login::class.java))
            }
            R.id.register_activity -> {
                startActivity(Intent(Register@ this, MainActivity::class.java))
            }


        }
    }

}
