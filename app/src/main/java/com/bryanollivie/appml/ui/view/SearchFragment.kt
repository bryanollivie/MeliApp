package com.bryanollivie.appml.ui.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bryanollivie.appml.R
import com.bryanollivie.appml.databinding.FragmentSearchBinding
import com.bryanollivie.appml.ui.viewmodel.SharedViewModel
import com.bryanollivie.appml.util.AppUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.setOnTouchListener { _, _ ->
            AppUtils.hideKeyboard(requireContext(),binding.editTextSearch)
            false
        }

        binding.buttonSearch.setOnClickListener {

            if(AppUtils.validateField(binding.editTextSearch)){
                AppUtils.hideKeyboard(requireContext(),binding.editTextSearch)
                sharedViewModel.setString(binding.editTextSearch.text.toString())
                findNavController().navigate(R.id.action_SearchFragment_to_FirstFragment)
            }else{
                binding.editTextSearch.requestFocus()
                AppUtils.showKeyboard(requireContext(),binding.editTextSearch)
            }

        }
    }

}
