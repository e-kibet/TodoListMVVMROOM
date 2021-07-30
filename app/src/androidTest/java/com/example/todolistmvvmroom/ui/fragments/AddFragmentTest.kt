package com.example.todolistmvvmroom.ui.fragments

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.todolistmvvmroom.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddFragmentTest : TestCase(){
    private lateinit var scenario: FragmentScenario<AddFragment>

    @Before
    fun setup(){
        scenario = launchFragmentInContainer (themeResId = R.style.Theme_TodoListMVVMROOM )
        scenario.moveToState(Lifecycle.State.STARTED)
    }

   @Test
   fun testAdd(){
       var title = "WELCOME"
       var description = "descr"
       onView(withId(R.id.title)).perform(typeText(title))
       onView(withId(R.id.description)).perform(typeText(description))
       Espresso.closeSoftKeyboard()
       onView(withId(R.id.submit_button)).perform(click())
   }

}