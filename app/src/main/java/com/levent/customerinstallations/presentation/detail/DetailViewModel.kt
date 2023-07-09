package com.levent.customerinstallations.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.levent.customerinstallations.data.model.UserInvoices
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val userInvoices = savedStateHandle.get<UserInvoices>("invoice")
}