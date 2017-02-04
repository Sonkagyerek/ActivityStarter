package com.marcinmoskala.kotlinapp


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

@LargeTest
@RunWith(AndroidJUnit4::class)
class ParcelableSerializableTest {

    @Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
    val activity: MainActivity get() = mActivityTestRule.activity

    @Test
    @Throws(InterruptedException::class)
    fun parcelableTest() {
        activity.runOnUiThread {
            activity.startDetailsActivity()
        }

        onView(withId(R.id.nameView)).check(matches(withText("Name: Marcin")))
        onView(withId(R.id.idView)).check(matches(withText("Id: 10")))
        onView(withId(R.id.gradeView)).check(matches(withText("Grade: A")))
    }

    @Test
    @Throws(InterruptedException::class)
    fun serializableTest() {
        activity.runOnUiThread {
            activity.startDetailsActivity()
        }

        onView(withId(R.id.nameView)).check(matches(withText("Name: Marcin Moskala")))
        onView(withId(R.id.idView)).check(matches(withText("Id: 20")))
        onView(withId(R.id.gradeView)).check(matches(withText("Grade: A")))
    }
}
