package com.bryanollivie.appml.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bryanollivie.appml.R
import com.bryanollivie.appml.data.remote.ResultsItemDto
import com.bryanollivie.appml.databinding.ProductItemLayoutBinding
import com.bryanollivie.appml.ui.viewmodel.SharedViewModel
import com.bryanollivie.appml.util.EXCHANGE_RATE
import com.bryanollivie.appml.util.convertPesosArgentinosToBrazilianReais
import com.bryanollivie.appml.util.limitLengthWithEllipsis
import com.bryanollivie.appml.util.toArgentinianPesoFormat
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import okhttp3.HttpUrl.Companion.toHttpUrl

class ProductListAdapter(private val fragment:Fragment, private val sharedViewModel: SharedViewModel?, private val dataList: List<ResultsItemDto?>?) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemLayoutBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = dataList?.get(position)

        if (currentItem != null) {

            holder.binding.productItemTitleText.text =
                currentItem?.title?.limitLengthWithEllipsis(30)?.toUpperCase()
            holder.binding.productItemPriceBrText.text =
                fragment.context?.getString(
                    R.string.price_brazil,
                    currentItem?.price?.convertPesosArgentinosToBrazilianReais(EXCHANGE_RATE)
                )
            holder.binding.productItemPriceArText.text =
                fragment.context?.getString(
                    R.string.price_argentina,currentItem?.price?.toArgentinianPesoFormat())

            Picasso.get().load(currentItem.thumbnail).into(holder.binding.productItemImage)

            holder.binding.productItemLayout.setOnClickListener {

                sharedViewModel?.setProductItemClick(currentItem)
                NavHostFragment.findNavController(fragment)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }

    }

    override fun getItemCount(): Int = dataList!!.size

    class ProductViewHolder(val binding: ProductItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}
