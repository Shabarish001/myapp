package com.example.myapplication

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.storage.s3.AWSS3StoragePlugin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        try {
            // Add the Auth and Storage plugins
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.addPlugin(AWSS3StoragePlugin())

            // Initialize Amplify
            Amplify.configure(applicationContext)

            Log.i("AmplifyConfig", "Initialized Amplify")
        } catch (error: AmplifyException) {
            Log.e("AmplifyConfig", "Could not initialize Amplify", error)
        }
    }
}

