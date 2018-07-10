package com.shayan.android.kotlinexample.lazyinitialization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.shayan.android.kotlinexample.R

/**
 * Example of lazy initialization with delegated property
 * Inspired by https://medium.com/til-kotlin/how-kotlins-delegated-properties-and-lazy-initialization-work-552cbad8be60
 */
class LazyActivity : AppCompatActivity()
{
    // Here we define a read-only property which is later initialized
    // The 'lazy' keyword is a function that returns a delegated property. It receives a lambda function to initialize the
    // property when it's first accessed, then it will store the property for the future times
    private val helloTextView : TextView by lazy {
        findViewById<TextView>(R.id.tv_hello)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The initialization of helloTextView happens at this time
        helloTextView.setText(R.string.hello_world)
    }
}
