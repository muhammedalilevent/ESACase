package com.levent.customerinstallations.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levent.customerinstallations.data.model.UserInvoices
import com.levent.customerinstallations.domain.repository.InvoiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val invoiceRepository: InvoiceRepository) :
    ViewModel() {
    private val _userInvoices = MutableLiveData<UserInvoices>()
    val userInvoices: LiveData<UserInvoices> = _userInvoices

    init {
        getUserInvoices()
    }

    private fun getUserInvoices() = viewModelScope.launch {
        _userInvoices.value = invoiceRepository.getUserInvoices()
    }
}