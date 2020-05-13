package com.sqisland.android.espresso.hermetic

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.joda.time.DateTime
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Rule @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun evening() {
        val clock = Mockito.mock(Clock::class.java)
        val app = InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext().applicationContext as TestApplication
        app.component = DaggerTestComponent.builder().clock(clock).build()

        Mockito.`when`(clock.getClock()).thenReturn(DateTime().withHourOfDay(20))

        activityRule.launchActivity(null)

        onView(withId(R.id.greeting))
                .check(matches(withText(R.string.greeting_evening)))
    }
}