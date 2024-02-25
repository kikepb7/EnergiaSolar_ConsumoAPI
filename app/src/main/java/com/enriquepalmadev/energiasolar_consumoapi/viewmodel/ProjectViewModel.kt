package com.enriquepalmadev.energiasolar_consumoapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Project
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProjectViewModel : ViewModel() {
    private val retrofitService = RetrofitServiceFactory.makeRetrofitService()

    private val _projects = MutableStateFlow<List<Project>>(emptyList())
    val projects: StateFlow<List<Project>> = _projects.asStateFlow()

    fun loadProjects(userId: Long) {
        viewModelScope.launch {
            try {
                val projects = retrofitService.getProjects(userId)
                _projects.value = projects
            } catch (e: Exception) {
                //
            }
        }
    }
}