package com.firstry.gmase.myterms.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import com.firstry.gmase.myterms.databinding.ProductItemBinding
import com.firstry.gmase.myterms.model.Product
import com.firstry.gmase.myterms.model.ProductService
import com.firstry.gmase.myterms.view.ViewHolderProductService
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter
import java.util.*
import kotlin.reflect.KClass

/**
 * Created by Guille2 on 05/08/2016
 * Have fun
 */
class ProductServicesAdapter(context: Context, itemClass: KClass<ProductService>, mComparator: Comparator<ProductService>, val mListener: Listener, val prod: Product) : SortedListAdapter<ProductService>(context, itemClass.java, mComparator) {
    interface Listener {
        fun onExampleModelClicked(model: ProductService)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewHolder<out ProductService> {
        res = parent.resources

        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolderProductService(binding, mListener)
    }

    override fun areItemsTheSame(item1: ProductService, item2: ProductService): Boolean {
        return item1.name === item2.name
    }

    override fun areItemContentsTheSame(oldItem: ProductService, newItem: ProductService): Boolean {
        return oldItem.toString() === newItem.toString()
    }

    private var res: Resources? = null


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ListView.ViewHolder, position: Int) {
        val vh1 = holder
        //configureViewHolderProductService(vh1, position)

        //TODO
        val model = prod.services[position]
        vh1.bind(model)

//        when (holder.itemViewType) {
//            Type.YESNO.ordinal -> {
//                val vh1 = holder as ViewHolderYesNo
//                configureViewHolderYesNo(vh1, position)
//            }
//            Type.SLIDER.ordinal -> {
//                val vh2 = holder as ViewHolderProductService
//                configureViewHolderSlider(vh2, position)
//            }
//            else -> {
//                throw UnsupportedOperationException("Tipo Question no definido")
//            }
//        }
    }


    fun getItemCount(): Int {
        return prod.services.count()
    }
}
