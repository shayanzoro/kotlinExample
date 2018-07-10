package com.shayan.android.kotlinexample.lazyinitialization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.shayan.android.kotlinexample.R

/**
 * Example of lazy initialization and delegated property
 * Inspired by https://medium.com/til-kotlin/how-kotlins-delegated-properties-and-lazy-initialization-work-552cbad8be60
 * and https://medium.com/rocket-fuel/kotlin-by-property-delegation-create-reusable-code-f2bc2253e227
 */
class LazyActivity : AppCompatActivity()
{
    // Here we define a read-only property which is later initialized
    // The 'lazy' keyword is a function that returns a delegated property. It receives a lambda function to initialize the
    // property when it's first accessed, then it will store the property for the future times
    private val helloTextView : TextView by lazy {
        findViewById<TextView>(R.id.tv_hello)
    }

    // This is the custom implementation of lazy initialization by defining a delegated property
    private val appNameTextView: TextView by CustomLazyImpl {
        findViewById<TextView>(R.id.tv_app_name)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // The initialization of helloTextView happens at this time
        helloTextView.setText(R.string.hello_world)
        // The initialization of appNameTextView happens at this time
        appNameTextView.setText(R.string.app_name)
    }
}
