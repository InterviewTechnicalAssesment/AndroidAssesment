package com.mandiri.movieapps

import android.app.Application
import com.facebook.stetho.Stetho
import com.mandiri.movieapps.di.networkModule
import com.mandiri.movieapps.di.persistenceModule
import com.mandiri.movieapps.di.repositoryModule
import com.mandiri.movieapps.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

@Suppress("unused")
class MainActivity : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainActivity)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Stetho.initializeWithDefaults(this)
    }
}
