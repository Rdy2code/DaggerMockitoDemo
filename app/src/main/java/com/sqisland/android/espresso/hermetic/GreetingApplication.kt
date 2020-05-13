package com.sqisland.android.espresso.hermetic

import android.app.Application

/**
 * Subclass this class in the TestApplication so that we can use Mockito to mock the Clock
 */
open class GreetingApplication: Application() {
    open fun provideClock(): Clock = Clock()
}