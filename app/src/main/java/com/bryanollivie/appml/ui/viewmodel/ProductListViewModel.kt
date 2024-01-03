package com.bryanollivie.appml.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bryanollivie.appml.R
import com.bryanollivie.appml.data.remote.ResponseDto
import com.bryanollivie.appml.data.remote.ResultsItemDto
import com.bryanollivie.appml.domain.repository.ProdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val prodRepository: ProdRepository,private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _dados = MutableStateFlow<Resource<ResponseDto>>(Resource.Loading())
    val dados: StateFlow<Resource<ResponseDto>> = _dados.asStateFlow()

    init {
        // Verificar se já existe uma consulta salva
       /* val filteredData: StateFlow<Resource<ResponseDto>> =savedStateHandle.getStateFlow<Resource<ResponseDto>>("query").flatMapLatest { query ->
            prodRepository.getSearchProd(query)
        }*/


        //tentar amanha
        //val savedQuery = savedStateHandle.get<String>("query") ?: defaultQuery
        //searchProductByQuery(savedQuery)
    }

    fun searchProductByQuery(query: String) {
        _dados.value = Resource.Loading(null)
        //FUNCIONA
        viewModelScope.launch {
            try {

                val search = prodRepository.getSearchProd(query)

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

        /*viewModelScope.launch {
            try {
                val savedQuery: String? = savedStateHandle.get("query")
                val savedResponse: ResponseDto? = savedStateHandle.get("query_response")
                Log.e("___savedQuery: ","${savedQuery}")
                //Log.e("___savedResponse: ","${savedResponse}")

                //val search = prodRepository.getSearchProd(query)



                if (savedQuery != null) {

                    if(savedResponse?.results?.size!! > 0) {
                        _dados.value = Resource.Success(savedResponse!!)
                    }else{
                        _dados.value = Resource.Error("Erro ao obter dados!", null)
                    }

                } else {

                    val newResponse = prodRepository.getSearchProd(query)
                    savedStateHandle.set("query", query)
                    savedStateHandle.set("query_response", newResponse)
                    Log.e("___SETQUERY: ","${query}")
                    //Log.e("___SETRESPONSE: ","${newResponse}")

                    if(newResponse?.results?.size!! > 0) {
                        _dados.value = Resource.Success(newResponse!!)
                    }else{
                        _dados.value = Resource.Error("Erro ao obter dados!", null)
                    }
                }


            } catch (e: Exception) {
                Log.e("Error:","${e.toString()}")
                _dados.value = Resource.Error(e.toString(), null)
            }
        }*/


    }

    suspend fun searchQueryProdList(query: String): LiveData<ResponseDto> {
        val savedQuery: String? = savedStateHandle.get("query")
        val savedResponse: ResponseDto? = savedStateHandle.get("query_response")

        Log.e("___savedQuery: ","${savedQuery}")
        Log.e("___savedResponse: ","${savedResponse}")

        if (savedQuery != null) {
            return    MutableLiveData(savedResponse)
        } else {

            val newResponse = prodRepository.getSearchProd(query)
                savedStateHandle.set("query", query)
                savedStateHandle.set("query_response", newResponse)
            Log.e("___SETQUERY: ","${query}")
            Log.e("___SETRESPONSE: ","${newResponse}")

            return MutableLiveData(newResponse)
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


