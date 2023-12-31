package com.bryanollivie.appml.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bryanollivie.appml.R
import com.bryanollivie.appml.databinding.FragmentProductListBinding
import com.bryanollivie.appml.databinding.FragmentSecondBinding
import com.bryanollivie.appml.ui.viewmodel.ProductListViewModel
import com.bryanollivie.appml.ui.viewmodel.SharedViewModel
import com.bryanollivie.appml.util.EXCHANGE_RATE
import com.bryanollivie.appml.util.convertPesosArgentinosToBrazilianReais
import com.bryanollivie.appml.util.toArgentinianPesoFormat
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()
    val thumbnailUrl: String = "http://http2.mlstatic.com/D_730775-MLU69805928080_062023-I.jpg"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = sharedViewModel.getProductItemClick()

        if(!product.value?.id.isNullOrEmpty()){

            //binding.productDetailsImage
            binding.productDetailsText.text =
                "Produto: ${product.value?.title}\n" +
                        "Brazil: ${product.value?.price?.convertPesosArgentinosToBrazilianReais(
                            EXCHANGE_RATE
                        )}\n" +
                        "Argentina: ${product.value?.price?.toArgentinianPesoFormat()}\n"
            //Picasso.get().load(thumbnailUrl).into(binding.productDetailsImage)

            binding.buttonSecond.setOnClickListener {
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}