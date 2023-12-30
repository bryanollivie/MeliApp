package com.bryanollivie.appml.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bryanollivie.appml.R
import com.bryanollivie.appml.databinding.FragmentProductListBinding
import com.bryanollivie.appml.ui.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.ResourceBundle

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    //private lateinit var productListViewModel: ProductListViewModel
    private val productListViewModel: ProductListViewModel by viewModels()

    //private val _userData = MutableLiveData<Resource<UserEntity>>()
    //val userData: LiveData<Resource<UserEntity>> = _userData


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //productListViewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)
        productListViewModel.searchProductByQuery("Motorola")


        /*productListViewModel.dados.observe(viewLifecycleOwner, Observer { dados ->
            when (dados) {

                Log.e("Listview","${dados}")
                *//*is Resource.Success -> {
                    // Atualize a UI com os dados
                }
                is Resource.Loading -> {
                    // Mostre o indicador de carregamento
                }
                is Resource.Error -> {
                    // Mostre a mensagem de erro
                }*//*
            }
        })*/


        /*productListViewModel.userData.observe(viewLifecycleOwner) { resource ->

        }

        viewModel.getUser(userId)*/



        //navigation
        //renomear botoes
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}