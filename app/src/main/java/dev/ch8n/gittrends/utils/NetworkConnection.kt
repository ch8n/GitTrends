package dev.ch8n.gittrends.utils

import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.Interceptor
import okhttp3.Response

class ConnectionInterceptor(
    private val connectivityManager: ConnectivityManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val isConnected:Boolean = connectivityManager.activeNetworkInfo?.isConnected == true
        connectStatus.postValue(isConnected)
        return chain.proceed(request)
    }

    companion object {

        private val connectStatus = MutableLiveData<Boolean>(false)

        var networkStatus =  connectStatus as LiveData<Boolean>
            private set
    }



}
