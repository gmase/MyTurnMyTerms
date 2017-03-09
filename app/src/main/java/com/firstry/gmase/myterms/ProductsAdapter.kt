package com.firstry.gmase.myterms

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.firstry.gmase.myterms.model.Companies
import com.firstry.gmase.myterms.model.ProductItem
import com.firstry.gmase.myterms.model.Products
import com.firstry.gmase.myterms.view.ViewHolderProduct


/**
 * Created by Guille2 on 05/08/2016
 * Have fun
 */
class ProductsAdapter(val fm: FragmentManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //private var dataToShow = AllQuestions.getVisible()
    private var res: Resources? = null

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val inflater = LayoutInflater.from(parent.context)
        res = parent.resources


//TODO placeholder
        val item1 = ProductItem(1, "Internet en casa", 20)
        val item2 = ProductItem(4, "Internet movil 4G de la hostia lo mejor del mercado ahora y siempre para ti y tus amigos", 60)
        val item3 = ProductItem(2, "todo", 100)
        val item4 = ProductItem(3, "Descuento de hasta 300€", -1)
        val list = listOf(item1, item2, item3, item4)
        val v2 = inflater.inflate(R.layout.product_box, parent, false)
        viewHolder = ViewHolderProduct(parent.context, v2, Products.p, fm)

        val tagList = viewHolder.itemView.findViewById(R.id.product_item_list) as ListView
        val listAdapter = ProductItemsAdapter(parent.context, list)
        // setting list adapter
        tagList.adapter = listAdapter

        val ut = Utils()
        ut.setListViewHeightBasedOnChildren(tagList)

        return viewHolder
    }// set the view's size, margins, paddings and layout parameters

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh1 = holder as ViewHolderProduct
        configureViewHolderProduct(vh1, position)
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
        val prod = Products.p[position]
        vh1.priceTV.text = String.format(res!!.getString(R.string.price_tag), prod.base_price!!.toInt())
        vh1.productTV.text = prod.name


        vh1.companyLogoIM.setImageDrawable(res!!.getDrawable(prod.companyLogo()))
        vh1.satisfactionIM.setImageDrawable(res!!.getDrawable(Companies.get(prod.company!!)!!.ratingIcon()))
    }

    override fun getItemCount(): Int {
        return Products.count()
    }

    override fun getItemViewType(position: Int): Int {
        return 1//dataToShow[position].type.ordinal
    }


/*
    fun delete(position: Int) {
        dbAdapter!!.saveResult(dataToShow[position].id, dataToShow[position].result, dataToShow[position].textResult)

        //Guardo los tags asociados a la respuesta marcada
        if (dataToShow[position].getCurrentAnswer().minusTags != null) {
            for (i in dataToShow[position].getCurrentAnswer().minusTags!!) {
                TagDictionary.get(i)!!.state = -1
                dbAdapter.saveTag(TagDictionary.get(i)!!)
            }
        }
        if (dataToShow[position].getCurrentAnswer().plusTags != null) {
            for (i in dataToShow[position].getCurrentAnswer().plusTags!!) {
                TagDictionary.get(i)!!.state = +1
                dbAdapter.saveTag(TagDictionary.get(i)!!)
            }
        }
        dataToShow.removeAt(position)
        notifyItemRemoved(position)
    }

    fun deleteByTag(position: Int, tag: Tag) {
        dbAdapter!!.saveResult(dataToShow[position].id, -2, res!!.getString(R.string.said_not_for_me))
        dbAdapter.saveTag(tag)
        dataToShow.removeAt(position)
        notifyItemRemoved(position)
    }
*/
}
