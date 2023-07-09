package com.levent.customerinstallations.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levent.customerinstallations.data.model.Location
import com.levent.customerinstallations.databinding.ItemLocationBinding

class LocationAdapter(private val invoice: List<Location>, private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<LocationAdapter.InvoiceViewHolder>() {
    inner class InvoiceViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Location) {
            binding.btnDetail.setOnClickListener {
                onClick.invoke(item.installationNumber)

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationAdapter.InvoiceViewHolder {
        val binding =
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InvoiceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationAdapter.InvoiceViewHolder, position: Int) =
        holder.bind(invoice[position])


    override fun getItemCount(): Int = invoice.count()
}