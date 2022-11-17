package dev.faddy.vyt1.di

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import dev.faddy.vyt1.BuildConfig
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application(), Configuration.Provider {
    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return if (BuildConfig.DEBUG) {
            Configuration.Builder().setWorkerFactory(workerFactory)
                .setMinimumLoggingLevel(android.util.Log.DEBUG).build()
        } else {
            Configuration.Builder().setWorkerFactory(workerFactory)
                .setMinimumLoggingLevel(android.util.Log.ERROR).build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}