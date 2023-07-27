package com.example.entomology.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.entomology.domain.models.ModelInsect
import com.example.entomology.domain.repositories.IInsectRepository
import com.example.entomology.utils.Constants
import com.example.entomology.utils.Constants.ITS_BAD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class RegistrosViewModelTest{

    @Mock
    private lateinit var iInsectRepository : IInsectRepository

    private lateinit var registroViewModel : RegistrosViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        registroViewModel = RegistrosViewModel(iInsectRepository)
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
    fun `obtains a record list of counted species`() = runTest {

        //Given
        Mockito.`when`(iInsectRepository.getListInsectFromDataBase()).thenReturn(listInsect())

        //When
        registroViewModel.getListSpeciesRecords()

        //Then
        Assert.assertTrue(registroViewModel.uiState.value.listInsect == listInsect())
    }

    fun listInsect(): List<ModelInsect> {
        return listOf(
            ModelInsect(
                1, "spearow",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png",
                ""
            ),
            ModelInsect(
                2,
                "fearow",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/22.png",
                ""
            )
        )
    }
}