package com.enriquepalmadev.energiasolar_consumoapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Panel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PanelViewModel : ViewModel() {
    private val retrofitService = RetrofitServiceFactory.makeRetrofitService()

    private val _panels = MutableStateFlow<List<Panel>>(emptyList())
    val panels: StateFlow<List<Panel>> = _panels.asStateFlow()

    fun loadPanels() {
        viewModelScope.launch {
            try {
                val panels = retrofitService.getPanels()
                _panels.value = panels
            } catch (e: Exception) {
                e.printStackTrace()
                _panels.value = emptyList()
            }
        }
    }
}