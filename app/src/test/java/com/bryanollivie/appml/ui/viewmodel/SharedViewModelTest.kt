package com.bryanollivie.appml.ui.viewmodel

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@Config(sdk = [31])
@RunWith(AndroidJUnit4::class)
class SharedViewModelTest {

    private var viewModel: SharedViewModel? = null

    @Before
    fun init() {
        viewModel = SharedViewModel(ApplicationProvider.getApplicationContext())

    }

    @Test
    fun sharedQuery_Invalid() {
        viewModel?.setQuery("Mesa")
        assertNull("Mesa",  null)

    }
}