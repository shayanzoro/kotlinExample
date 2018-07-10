package com.shayan.android.kotlinexample.lazyinitialization

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class CustomLazyImpl<T>(private val initializer: () -> T) : ReadOnlyProperty<Any, T>
{
    private var view: T? = null

    override fun getValue(thisRef: Any, property: KProperty<*>): T
    {
        if (view == null)
        {
            view = initializer.invoke()
        }

        return view as T
    }
}
