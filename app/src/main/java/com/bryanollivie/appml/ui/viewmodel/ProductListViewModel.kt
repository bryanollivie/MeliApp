package com.bryanollivie.appml.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bryanollivie.appml.data.remote.ResponseDto
import com.bryanollivie.appml.domain.repository.ProdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val prodRepository: ProdRepository) : ViewModel() {
//class ProductListViewModel(private val prodRepository: ProdRepository) : ViewModel() {
//class ProductListViewModel : ViewModel() {

    private val _dados = MutableLiveData<Resource<ResponseDto>>()
    val dados: LiveData<Resource<ResponseDto>> = _dados
    fun searchProductByQuery(prod: String) {
        _dados.value = Resource.Loading(null)
        viewModelScope.launch {
            try {
                val search = prodRepository.getSearchProd(prod)
                _dados.value = Resource.Success(search!!)
            } catch (e: Exception) {
                Log.e("Error:","${e.toString()}")
                _dados.value = Resource.Error(e.toString(), null)
            }
        }
    }

}

sealed class Resource<T>(
        val data: T? = null,
        val message: String? = null
    ) {
        class Success<T>(data: T) : Resource<T>(data)
        class Loading<T>(data: T? = null) : Resource<T>(data)
        class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}


