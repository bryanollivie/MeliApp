package com.bryanollivie.appml.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bryanollivie.appml.data.remote.dto.ResultsItemDto
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val application: Application?) : ViewModel() {

    private val selectedString = MutableLiveData<String>()
    private val productItemClick = MutableLiveData<ResultsItemDto>()

    fun setQuery(string: String) {
        selectedString.value = string
    }
    fun getQuery(): MutableLiveData<String> {
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