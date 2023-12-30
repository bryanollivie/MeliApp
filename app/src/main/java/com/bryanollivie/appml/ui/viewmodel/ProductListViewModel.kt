package com.bryanollivie.appml.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bryanollivie.appml.domain.repository.ProdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val prodRepository: ProdRepository) : ViewModel() {
//class ProductListViewModel(private val prodRepository: ProdRepository) : ViewModel() {
//class ProductListViewModel : ViewModel() {


    private val _dados = MutableLiveData<String>()
    var dados: LiveData<String>  = _dados
/*
    private val _userData = MutableLiveData<Resource<UserEntity>>()
    val userData: LiveData<Resource<UserEntity>> = _userData*/

    // Função para obter um usuário
    /*suspend fun getSearchProd(prod: String) {
        val product = prodRepository.getSearchProd(prod)
       Log.e("produto", "${product.results?.size}")
        //emit(user)
    }*/

    fun searchProductByQuery(prod: String) {
        viewModelScope.launch(Dispatchers.IO){
            //_userData.postValue(Resource.loading(null))
            prodRepository.getSearchProd(prod).let { result ->
                if (result.results?.isEmpty() !=false) {
                    Log.e("produto", "${result.results?.size}")
                    //_userData.postValue(Resource.success(result.getOrNull()))
                } else {
                    //_userData.postValue(Resource.error(result.exceptionOrNull()?.message ?: "Unknown Error", null))
                }
            }
        }
    }

    /*fun searchProductByQuery(prodQuery:String)=viewModelScope.launch(Dispatchers.IO){

            when(it){
                is Resource.Success ->{
                    coinValue.value = CoinState(coinDetail = it.data)
                }
                is ResponseState.Loading ->{
                    coinValue.value = CoinState(isLoading = true)
                }
                is ResponseState.Error ->{
                    coinValue.value = CoinState(error = it.message?:"An Unexpected Error")
                }

        }
    }*/
}

    sealed class Resource<T>(
        val data: T? = null,
        val message: String? = null
    ) {
        class Success<T>(data: T) : Resource<T>(data)
        class Loading<T>(data: T? = null) : Resource<T>(data)
        class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    }


