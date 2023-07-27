package com.example.entomology.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.entomology.databinding.FragmentListaRegistrosBinding
import com.example.entomology.presentation.viewmodels.RegistrosViewModel
import com.example.entomology.presentation.views.adapter.InsectAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class ListaRegistrosFragment : Fragment() {

    private val viewModelRegistros by viewModels<RegistrosViewModel>()

    private lateinit var binding: FragmentListaRegistrosBinding
    private lateinit var adapter: InsectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaRegistrosBinding.inflate(inflater, container, false)
        showRecords()
        return binding.root
    }

    private fun showRecords(){
        initRecyclerView()
        viewModelRegistros.getListSpeciesRecords()
    }

    private fun initRecyclerView() {
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModelRegistros.uiState.collect{ uiState ->
                    if(!uiState.loading){
                        if(uiState.msgError != "") {
                            Toast.makeText(activity,
                                "El error es: ${uiState.msgError}",
                                Toast.LENGTH_SHORT).show()
                        } else if(uiState.listInsect.isNotEmpty()) {
                            true.displayListsAndButtons()
                            adapter = InsectAdapter(uiState.listInsect)
                            binding.recyclerInsect.layoutManager = LinearLayoutManager(context)
                            binding.recyclerInsect.adapter = adapter
                        }
                    }
                }
            }
        }
    }

    private fun Boolean.displayListsAndButtons() {
        binding.recyclerInsect.isVisible = this
        binding.RecordsButton.isVisible = this
        binding.ReportingButton.isVisible = this
    }

}

