package com.example.entomology.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.entomology.domain.repositories.IEntomologyPreferences
import com.example.entomology.presentation.models.RegistroUIState
import com.example.entomology.utils.Constants.EMPTY_STRING
import com.example.entomology.utils.Constants.ITS_BAD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
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
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class RegistrosViewModelTest{

    @Mock
    private lateinit var entomologyPreferences : IEntomologyPreferences

    private lateinit var registroViewModel : RegistrosViewModel
    private val dispatcher = StandardTestDispatcher()
    private val testScope = TestScope(dispatcher)

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

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
    @Test
    fun `when the view model is first created, it gets a gap in the entomologist information`() = runTest {
        //Given
        val user = arrayListOf<String>()
        user.add(EMPTY_STRING)
        user.add(EMPTY_STRING)
        Mockito.`when`(entomologyPreferences.getEntomology()).thenReturn(user)

        //When
        registroViewModel.getEntomology()

        //Then
        testScope.launch {
            registroViewModel.uiState.collect { uiState ->
                when (uiState) {
                    RegistroUIState.Loading -> {}
                    is RegistroUIState.Success -> {
                        println("el uiState.nameEntomology es :${uiState.nameEntomology == EMPTY_STRING}")
                        Assert.assertTrue(uiState.nameEntomology == EMPTY_STRING)
                        Assert.assertTrue(uiState.urlEntomology == EMPTY_STRING)
                    }
                }
            }
        }
    }
    @Test
    fun `when information is obtained from the entomologist`() = runTest {
        //Given
        val user = arrayListOf<String>()
        user.add("spearow")
        user.add("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png")

        Mockito.`when`(entomologyPreferences.getEntomology()).thenReturn(user)

        //When
        registroViewModel.getEntomology()

        //Then
        testScope.launch {
            registroViewModel.uiState.collect { uiState ->
                when (uiState) {
                    RegistroUIState.Loading -> {}
                    is RegistroUIState.Success -> {
                        assert(uiState.nameEntomology == user[0])
                        assert(uiState.urlEntomology == user[1])
                    }
                }
            }
        }
    }

}