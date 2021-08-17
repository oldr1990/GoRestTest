package com.github.goresttest.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.github.goresttest.model.room.PostRoom
import com.github.goresttest.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RepositoryInterface
): ViewModel() {
    var pagingFlow: Flow<PagingData<PostRoom>>? = null
    fun getPosts(){
        try{
            viewModelScope.launch {
                pagingFlow = repository.searchPosts()
            }
        }catch (e:Exception) {
            Log.e("Tag", e.message.toString())
        }
    }
}