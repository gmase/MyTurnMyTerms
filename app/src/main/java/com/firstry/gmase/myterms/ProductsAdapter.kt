package com.firstry.gmase.myterms

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

    }// set the view's size, margins, paddings and layout parameters

    // Replace the contents of a view (invoked by the layout manager)
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh1 = holder as ViewHolderProduct
        //configureViewHolderProduct(vh1, position)
        val model = Products.filtered()[position]
        vh1.bind(model)

//        when (holder.itemViewType) {
//            Type.YESNO.ordinal -> {
//                val vh1 = holder as ViewHolderYesNo
//                configureViewHolderYesNo(vh1, position)
//            }
//            Type.SLIDER.ordinal -> {
//                val vh2 = holder as ViewHolderProduct
//                configureViewHolderSlider(vh2, position)
//            }
//            else -> {
//                throw UnsupportedOperationException("Tipo Question no definido")
//            }
//        }
    }

    private fun configureViewHolderProduct(vh1: ViewHolderProduct, position: Int) {
        val prod = Products.filtered()[position]
        //vh1.priceTV.text = String.format(res!!.getString(R.string.price_tag), prod.base_price!!.toInt())
        //vh1.productTV.text = prod.name


        // vh1.companyLogoIM.setImageDrawable(res!!.getDrawable(prod.companyLogo()))
        //vh1.satisfactionIM.setImageDrawable(res!!.getDrawable(Companies.get(prod.company!!)!!.ratingIcon()))
    }

fun getItemCount(): Int {
        return Products.filtered().count()
    }

fun getItemViewType(position: Int): Int {
        return 1//dataToShow[position].type.ordinal
    }

