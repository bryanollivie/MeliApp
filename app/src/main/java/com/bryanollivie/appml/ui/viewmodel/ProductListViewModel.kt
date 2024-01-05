package com.bryanollivie.appml.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bryanollivie.appml.data.remote.dto.ResponseDto
import com.bryanollivie.appml.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {

    private val _dados = MutableStateFlow<Resource<ResponseDto>>(Resource.Loading())
    val dados: StateFlow<Resource<ResponseDto>> = _dados.asStateFlow()

    fun searchProductByQuery(query: String) {

        _dados.value = Resource.Loading(null)

        viewModelScope.launch {

            try {

                val search = withContext(Dispatchers.IO) {
                    appRepository.getAllProductsBySearchWithCache(query)
                }

                if(search?.results?.size!! > 0) {
                    _dados.value = Resource.Success(search!!)
                }else{
                    _dados.value = Resource.Error("Erro ao obter dados!", null)
                }

            } catch (e: Exception) {
                Log.e("Error:","${e.toString()}")
                _dados.value = Resource.Error(e.toString(), null)
            }
        }

    }

    fun searchRemoteProductByQuery(query: String) {

        _dados.value = Resource.Loading(null)

        viewModelScope.launch {

            try {

                //val search = appRepository.getSearchProd(query)
                val search = withContext(Dispatchers.IO) {
                    appRepository.getAllRemoteProductsBySearch(query)
                }

                if(search?.results?.size!! > 0) {
                    _dados.value = Resource.Success(search!!)
                }else{
                    _dados.value = Resource.Error("Erro ao obter dados!", null)
                }

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


