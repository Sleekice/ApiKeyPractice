package com.example.apikeypractice.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apikeypractice.data.model.searchusers.SearchItemModel
import com.example.apikeypractice.data.repository.Repository
import com.example.apikeypractice.util.ResponseHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

        private val _searchData = MutableLiveData<ResponseHandling>()
        val searchData: LiveData<ResponseHandling> = _searchData

        fun setSearch(query: String) {
            viewModelScope.launch {
                _searchData.postValue(ResponseHandling.Loading)

                val result = repository.setSearch(query)
                if (result.isSuccessful) {
                    _searchData.postValue(
                        ResponseHandling.Success(
                            result.body() ?: SearchItemModel()
                        )
                    )
                } else {
                    _searchData.postValue(ResponseHandling.Failure(result.message()))
                }
            }
        }
}