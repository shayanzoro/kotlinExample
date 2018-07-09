package com.shayan.android.kotlinexample.higherorderfunction

const val GoogleDnsIp = "8.8.8.8"

/**
 * This is an async method, so the result can't be returned immediately
 */
fun checkInternetQuality(success: () -> Unit, failure: () -> Unit)
{
    val mExitValue: Int
    try
    {
        val runtime = Runtime.getRuntime()
        val mIpAddrProcess = runtime.exec("/system/bin/ping -c 1 $GoogleDnsIp")
        mExitValue = mIpAddrProcess.waitFor()

        return if (mExitValue == 0)
        {
            success.invoke()
        } else
        {
            failure.invoke()
        }
    } catch (e: Exception)
    {
        failure.invoke()
    }
}