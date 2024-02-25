package com.enriquepalmadev.energiasolar_consumoapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enriquepalmadev.energiasolar_consumoapi.data.RetrofitServiceFactory
import com.enriquepalmadev.energiasolar_consumoapi.data.model.Report
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReportViewModel : ViewModel() {
    private val retrofitService = RetrofitServiceFactory.makeRetrofitService()

    private val _userId = MutableStateFlow<String?>(null)
    val userId: StateFlow<String?> = _userId

    private val _reports = MutableStateFlow<List<Report>>(emptyList())
    val reports: StateFlow<List<Report>> = _reports.asStateFlow()

    fun loadReports(userId: Long) {
        viewModelScope.launch {
            try {
                val reports = retrofitService.getReports(userId)
                _reports.value = reports
            } catch (e: Exception) {
                e.printStackTrace()
                _reports.value = emptyList()
            }
        }
    }
}