package com.sqisland.android.espresso.hermetic

import dagger.Component
import dagger.Module
import dagger.Provides

/**
 * Have Dagger generate an inject function that will inject a clock into MainActivity
 */
@Component(modules = [ClockModule::class])
interface ApplicationComponent {
    fun injectClock (mainActivity: MainActivity)
}

@Module
object ClockModule {
    @Provides
    fun provideClock(): Clock {
        return Clock()
    }
}