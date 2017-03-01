package com.firstry.gmase.myterms

import android.content.res.Resources
import android.graphics.Color
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import java.util.*

/**
 * Created by Guille2 on 05/08/2016.
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
        val list = listOf("A+", "B", "C", "D", "A", "A")
        val v2 = inflater.inflate(R.layout.product_box, parent, false)
        viewHolder = ViewHolderProduct(parent.context, v2, this, fm)
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

    override fun getItemCount(): Int {
        return 6
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
