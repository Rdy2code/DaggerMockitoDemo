package com.sqisland.android.espresso.hermetic

import org.mockito.Mockito

open class TestApplication: GreetingApplication() {

    //Change the clock to a Mockito clock. This says only instantiate the clock when we need it
    private val clock: Clock by lazy {
        Mockito.mock(Clock::class.java)
    }

    //When this function is called the variable clock will be instantiated
    override fun provideClock(): Clock = clock
}