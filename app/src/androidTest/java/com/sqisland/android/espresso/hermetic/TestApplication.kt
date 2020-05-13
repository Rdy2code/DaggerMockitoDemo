package com.sqisland.android.espresso.hermetic

import org.mockito.Mockito

open class TestApplication: GreetingApplication() {
    override lateinit var component: ApplicationComponent
}