package com.shayan.android.kotlinexample.higherorderfunction

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * This is just an abstract example of how we could use higher order functions in a login page
 */
class LoginPage : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        initViews()
    }

    fun initViews()
    {
        checkInternetQuality({
            // Good internet connection
            enableLoginButton()
        }, {
            // Weak internet connection
            showInternetDisconnectionMessage()
        })
    }

    fun enableLoginButton()
    {

    }

    fun showInternetDisconnectionMessage()
    {

    }
}
