package com.example.entomology.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.entomology.domain.repositories.IEntomologyPreferences
import com.example.entomology.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class EntomologoViewModelTest{

    @Mock
    private lateinit var entomologyPreferences : IEntomologyPreferences

    private lateinit var entomologoViewModel: EntomologoViewModel
    private val dispatcher = StandardTestDispatcher()
    private val testScope = TestScope(dispatcher)

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        entomologoViewModel = EntomologoViewModel(entomologyPreferences)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `class Must Be Exists`() = runTest {
        // check
        Assert.assertThat(Constants.ITS_BAD, entomologoViewModel, CoreMatchers.instanceOf(EntomologoViewModel::class.java))
    }
    @Test
    fun `when the view model is first created, it gets a gap in the entomologist information`() = runTest {
        //Given
        val user = arrayListOf<String>()
        user.add(Constants.EMPTY_STRING)
        user.add(Constants.EMPTY_STRING)
        Mockito.`when`(entomologyPreferences.getEntomology()).thenReturn(user)

        //When
        entomologoViewModel.getEntomology()

        //Then
        Assert.assertTrue(entomologoViewModel.uiState.value.nameEntomology == Constants.EMPTY_STRING)
        Assert.assertTrue(entomologoViewModel.uiState.value.urlEntomology == Constants.EMPTY_STRING)
    }
    @Test
    fun `when information is obtained from the entomologist`() = runTest {
        //Given
        val user = arrayListOf<String>()
        user.add("spearow")
        user.add("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png")

        Mockito.`when`(entomologyPreferences.getEntomology()).thenReturn(user)

        //When
       entomologoViewModel.getEntomology()

        //Then
        testScope.launch {
            entomologoViewModel.uiState.collect { uiState ->
                assert(uiState.nameEntomology == user[0])
                assert(uiState.urlEntomology == user[1])
            }
        }
    }

}