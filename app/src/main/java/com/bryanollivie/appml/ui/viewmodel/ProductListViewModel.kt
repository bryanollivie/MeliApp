package com.bryanollivie.appml.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bryanollivie.appml.data.local.entity.User
import com.bryanollivie.appml.data.remote.ResponseDto
import com.bryanollivie.appml.domain.repository.ProdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ProductListViewModel @Inject constructor(private val prodRepository: ProdRepository/*,private val savedStateHandle: SavedStateHandle*/) : ViewModel() {

    private val _dados = MutableStateFlow<Resource<ResponseDto>>(Resource.Loading())
    val dados: StateFlow<Resource<ResponseDto>> = _dados.asStateFlow()

    fun searchProductByQuery(query: String) {

        _dados.value = Resource.Loading(null)

        viewModelScope.launch {
            try {

                val search = prodRepository.getSearchProd(query)

                /*withContext(Dispatchers.IO) {

                    saveLocalData()
                }

                //operação com banco de dados
                val dados = withContext(Dispatchers.IO) {

                     prodRepository.getLocalAllUsers()
                }

                Log.e("Users: ","${dados}")
                */

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

    private fun saveLocalData(){

        val user = User(userId = Random.nextInt(), firstName = "Bryanasdfadsfs", lastName = "Souza")
        val usersList = listOf(user)

        prodRepository.saveLocalUsers(usersList)

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


