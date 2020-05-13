package com.sqisland.android.espresso.hermetic

import android.app.Application

/**
 * Subclass this class in the TestApplication so that we can use Mockito to mock the Clock
 */
open class GreetingApplication: Application() {
    //Create Dagger component
    open val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().clockModule(ClockModule).build()
    }
}