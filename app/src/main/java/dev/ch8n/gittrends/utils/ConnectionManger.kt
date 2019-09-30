package dev.ch8n.gittrends.utils

import android.net.ConnectivityManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.Interceptor
import okhttp3.Response


class ConnectionManger(private val connectivityManager: ConnectivityManager):ConnectionProvider {

    private val connectStatus = MutableLiveData<Boolean>(false)

    override fun getConnectionInterceptor() = Interceptor { chain ->
        val request = chain.request()
        val isConnected:Boolean = connectivityManager.activeNetworkInfo?.isConnected == true
        connectStatus.postValue(isConnected)
        chain.proceed(request)
    }

    override var networkStatus =  connectStatus as LiveData<Boolean>
        private set

}

interface ConnectionProvider {
    fun getConnectionInterceptor():Interceptor
    val networkStatus : LiveData<Boolean>
}