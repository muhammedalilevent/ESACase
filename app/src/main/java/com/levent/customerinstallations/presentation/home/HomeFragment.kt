package com.levent.customerinstallations.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.levent.customerinstallations.R
import com.levent.customerinstallations.common.viewBinding
import com.levent.customerinstallations.data.model.UserInvoices
import com.levent.customerinstallations.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userInvoices.observe(viewLifecycleOwner) { invoice ->
            Log.e("HomeFragment", "onViewCreated: $invoice")

            val adapter = LocationAdapter(invoice.list) { installationNumber ->
                actionDetail(installationNumber, invoice)
            }
            binding.recyclerView.adapter = adapter
        }

    }

    private fun actionDetail(installationNumber: String, userInvoices: UserInvoices) {
        val newData =
            userInvoices.copy(list = userInvoices.list.filter { it.installationNumber == installationNumber },
                invoices = userInvoices.invoices.filter { it.installationNumber == installationNumber })
        findNavController().navigate(HomeFragmentDirections.actionHomeToDetail(newData))
    }

}