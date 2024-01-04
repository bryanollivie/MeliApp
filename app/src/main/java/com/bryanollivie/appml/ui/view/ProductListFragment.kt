package com.bryanollivie.appml.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bryanollivie.appml.R
import com.bryanollivie.appml.databinding.FragmentProductListBinding
import com.bryanollivie.appml.ui.viewmodel.ProductListViewModel
import com.bryanollivie.appml.ui.viewmodel.Resource
import com.bryanollivie.appml.ui.viewmodel.SharedViewModel
import com.bryanollivie.appml.util.hideErrorLayout
import com.bryanollivie.appml.util.showErrorLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment  : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    //private lateinit var productListViewModel: ProductListViewModel
    private val productListViewModel : ProductListViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var adapter = ProductListAdapter(this,null,emptyList())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //productListViewModel = ViewModelProvider(this)[ProductListViewModel::class.java]
        //val queryString = sharedViewModel.getQuery().toString().isNullOrBlank()
        //if(!sharedViewModel.getQuery().toString().isNullOrBlank()){
            updateUI()
            getData()
        //}



    }



    private fun getData() {
        if (productListViewModel.dados.value.data == null) {
            sharedViewModel.getQuery().observe(viewLifecycleOwner, Observer { query ->
                productListViewModel.searchProductByQuery(query)
            })
        }else{
            updateUI()
        }

    }

    private fun updateUI() {

        binding.productRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.productRecyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted {

            productListViewModel.dados.collect { search ->
                when (search) {
                    is Resource.Success -> {

                        // Atualizar UI com os dados do usuário
                        hideErrorLayout()
                        adapter = ProductListAdapter(this@ProductListFragment, sharedViewModel, search.data?.results)
                        binding.productRecyclerView.adapter = adapter
                        binding.progressBar.visibility = View.GONE
                        binding.productRecyclerView.visibility = View.VISIBLE

                    }
                    is Resource.Loading -> {

                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Resource.Error -> {

                        binding.productRecyclerView.visibility = View.GONE
                        binding.progressBar.visibility = View.GONE
                        showErrorLayout(getString(R.string.search_error)
                        ) {
                            findNavController().navigate(R.id.action_FirstFragment_to_SearchFragment)

                        }

                    }
                }
            }

            /* productListViewModel.dados.observe(viewLifecycleOwner) { search ->
            when (search) {
                is Resource.Success -> {

                    // Atualizar UI com os dados do usuário
                    adapter = ProductListAdapter(this,sharedViewModel,search.data?.results)
                    binding.productRecyclerView.adapter = adapter
                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Loading -> {

                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Error -> {

                    binding.progressBar.visibility = View.GONE

                }

                else -> {
                    //tela de erro
                }
            }
        }*/
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}