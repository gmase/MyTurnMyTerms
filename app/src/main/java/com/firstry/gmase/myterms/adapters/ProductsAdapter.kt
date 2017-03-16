package com.firstry.gmase.myterms.adapters

import android.content.Context
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.firstry.gmase.myterms.databinding.ProductBoxBinding
import com.firstry.gmase.myterms.model.Product
import com.firstry.gmase.myterms.model.Products
import com.firstry.gmase.myterms.view.ViewHolderProduct
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter
import java.util.*
import kotlin.reflect.KClass

/**
 * Created by Guille2 on 05/08/2016
 * Have fun
 */
class ProductsAdapter(context: Context, itemClass: KClass<Product>, mComparator: Comparator<Product>, val mListener: Listener) : SortedListAdapter<Product>(context, itemClass.java, mComparator) {
    interface Listener {
        fun onExampleModelClicked(model: Product)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewHolder<out Product> {
        res = parent.resources

        val binding = ProductBoxBinding.inflate(inflater, parent, false)
        return ViewHolderProduct(binding, mListener)
    }

    override fun areItemsTheSame(item1: Product, item2: Product): Boolean {
        return item1.name === item2.name
    }

    override fun areItemContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.toString() === newItem.toString()
    }
    private var res: Resources? = null

    }