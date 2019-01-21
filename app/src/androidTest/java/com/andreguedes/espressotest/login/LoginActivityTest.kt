package com.andreguedes.espressotest.login

import android.app.Activity
import android.app.Instrumentation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.andreguedes.espressotest.R
import com.andreguedes.espressotest.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(LoginActivity::class.java, false, true)

    @Test
    fun whenActivityIsLaunched_shouldDisplayInitialState() {
        onView(withId(R.id.edt_username)).check(matches(isDisplayed()))
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_sign_in)).check(matches(isDisplayed()))
    }

    @Test
    fun whenUsernameAndPasswordAreEmpty_andClickOnLoginButton_shouldDisplayMessage() {
        onView(withId(R.id.edt_username)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.edt_password)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.btn_sign_in)).perform(click())
        showAlert(R.string.fields_msg_error)
    }

    @Test
    fun whenUsernameIsEmpty_andClickOnLoginButton_shouldDisplayMessage() {
        onView(withId(R.id.edt_username)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.edt_password)).perform(typeText("pass"), closeSoftKeyboard())
        onView(withId(R.id.btn_sign_in)).perform(click())
        showAlert(R.string.username_msg_error)
    }

    @Test
    fun whenPasswordIsEmpty_andClickOnLoginButton_shouldDisplayMessage() {
        onView(withId(R.id.edt_username)).perform(typeText("user"), closeSoftKeyboard())
        onView(withId(R.id.edt_password)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.btn_sign_in)).perform(click())
        showAlert(R.string.password_msg_error)
    }

    private fun showAlert(msg: Int) {
        onView(withText(msg)).check(matches(isDisplayed()))
        onView(withText(R.string.ok)).perform(click())
    }

    @Test
    fun whenUsernameAndPasswordAreCorrect_andClickOnLoginButton_shouldShowNextScreen() {
        Intents.init()

        onView(withId(R.id.edt_username)).perform(typeText("user"), closeSoftKeyboard())
        onView(withId(R.id.edt_password)).perform(typeText("pass"), closeSoftKeyboard())

        val matcher = hasComponent(MainActivity::class.qualifiedName)
        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, null)
        intending(matcher).respondWith(result)

        onView(withId(R.id.btn_sign_in)).perform(click())

        intended(matcher)

        Intents.release()
    }

}
