package com.firstry.gmase.myterms.model

import android.graphics.drawable.Drawable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.firstry.gmase.myterms.R
import com.firstry.gmase.myterms.adapters.SortedListAdapter
import android.databinding.BindingAdapter
import android.widget.ImageView

@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}


/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Product : SortedListAdapter.ViewModel, Comparable<Product> {
    override fun compareTo(other: Product): Int {
        return base_price!!.compareTo(other.base_price as Float)
    }

    var name: String? = null
    var id: String? = null
    var base_price: Float? = null
    var permanencia: Int? = null
    var company: String? = null
    var services: ArrayList<ProductService> = ArrayList()


    fun companyLogo(): Int {
        return Companies.get(company!!)!!.compmanyIcon()
    }

    fun companySatisfaction(): Int {
        return Companies.get(company!!)!!.ratingIcon()
    }

    fun priceString(): String {
        return base_price!!.toInt().toString() + '$'
    }
}

