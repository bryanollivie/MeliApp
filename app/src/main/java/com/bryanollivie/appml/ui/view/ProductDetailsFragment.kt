package com.bryanollivie.appml.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bryanollivie.appml.R
import com.bryanollivie.appml.databinding.FragmentProductDetailsBinding
import com.bryanollivie.appml.ui.viewmodel.SharedViewModel
import com.bryanollivie.appml.util.EXCHANGE_RATE
import com.bryanollivie.appml.util.convertPesosArgentinosToBrazilianReais
import com.bryanollivie.appml.util.toArgentinianPesoFormat
import com.squareup.picasso.Picasso

class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = sharedViewModel.getProductItemClick()

        if(!product.value?.title.isNullOrEmpty()){

            Picasso.get().load(product.value?.thumbnail).into(binding.productDetailsImage)

            binding.productDetailsTextTitle.text = "${product.value?.title?.toUpperCase()}"
            binding.productDetailsTextPricebr.text = getString(
                R.string.price_brazil, product.value?.price?.convertPesosArgentinosToBrazilianReais(
                    EXCHANGE_RATE
                )
            )
            binding.productDetailsTextPricear.text = getString(R.string.price_argentina, product.value?.price?.toArgentinianPesoFormat())

            binding.buttonSecond.setOnClickListener {
                //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                Toast.makeText(context,
                    getString(R.string.compra_finalizada_com_sucesso), Toast.LENGTH_SHORT).show()

            }
        }else{
            Toast.makeText(context,
                getString(R.string.error_load), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}