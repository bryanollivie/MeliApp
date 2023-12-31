package com.bryanollivie.appml.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bryanollivie.appml.data.remote.ResultsItemDto
import com.bryanollivie.appml.databinding.FragmentProductListBinding
import com.bryanollivie.appml.ui.viewmodel.ProductListViewModel
import com.bryanollivie.appml.ui.viewmodel.Resource
import com.bryanollivie.appml.ui.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var adapter = ProductListAdapter(this,null,emptyList())


    private lateinit var productListViewModel: ProductListViewModel
    //private val productListViewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productListViewModel = ViewModelProvider(this)[ProductListViewModel::class.java]

        binding.productRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.productRecyclerView.adapter = adapter

        productListViewModel.dados.observe(viewLifecycleOwner) { search ->
            when (search) {
                is Resource.Success -> {
                    // Atualizar UI com os dados do usuário
                    adapter = ProductListAdapter(this,sharedViewModel,search.data?.results)
                    binding.productRecyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                        /*this.context?.let {
                            ProductListAdapter(this,sharedViewModel,search.data?.results)
                        }*/

                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Loading -> {
                    // Exibir indicador de carregamento
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Error -> {
                    // Exibir mensagem de erro
                    binding.progressBar.visibility = View.GONE

                }

                else -> {}
            }
        }

        sharedViewModel.getString().observe(viewLifecycleOwner, Observer { string ->
            productListViewModel.searchProductByQuery(string)
        })

    }

    /*fun updateData(newItems: List<ResultsItemDto>) {
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}