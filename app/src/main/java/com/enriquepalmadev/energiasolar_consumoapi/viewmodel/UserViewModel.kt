package com.enriquepalmadev.energiasolar_consumoapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val retrofitService = RetrofitServiceFactory.makeRetrofitService()

    private val _userId = MutableStateFlow<String?>(null)
    val userId: StateFlow<String?> = _userId

    private val _user = MutableStateFlow<Profile?>(null)
    val user: StateFlow<Profile?> = _user.asStateFlow()

    fun setUserId(userId: String?) {
        _userId.value = userId
    }

    fun loadUser(userId: Long) {
        viewModelScope.launch {
            try {
                val profile = retrofitService.getUser(userId)
                _user.value = profile
            } catch (e: Exception) {
                e.printStackTrace()
                _user.value = null
            }
        }
    }
}