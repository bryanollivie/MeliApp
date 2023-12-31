package com.bryanollivie.appml.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.bryanollivie.appml.data.remote.ResultsItemDto
import dagger.hilt.android.lifecycle.HiltViewModel


class SharedViewModel: ViewModel() {

    private val selectedString = MutableLiveData<String>()
    private val productItemClick = MutableLiveData<ResultsItemDto>()

    //SelectedString
    fun setString(string: String) {
        selectedString.value = string
    }
    fun getString(): LiveData<String> {
        return selectedString
    }

    //ProductItemClick
    fun setProductItemClick(product: ResultsItemDto) {
        productItemClick.value = product
    }
    fun getProductItemClick(): LiveData<ResultsItemDto> {
        return productItemClick
    }
}