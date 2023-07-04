package com.example.entomology.presentation.viewmodels

import com.example.entomology.domain.repositories.IEntomologyPreferences
import com.example.entomology.utils.Constants.ITS_BAD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class RegistrosViewModelTest{

    @Mock
    private lateinit var entomologyPreferences : IEntomologyPreferences

   private lateinit var registroViewModel : RegistrosViewModel

    @Before
    fun onBefore() {
        registroViewModel = RegistrosViewModel(entomologyPreferences)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `class Must Be Exists`() = runTest {
        // check
        Assert.assertThat(ITS_BAD, registroViewModel, CoreMatchers.instanceOf(RegistrosViewModel::class.java))
    }



}