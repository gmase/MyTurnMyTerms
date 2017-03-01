package com.firstry.gmase.myterms

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import com.firstry.gmase.myterms.model.ProductItem

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
class ProductItemsAdapter : ListAdapter {
    private var _context: Context? = null
    private var _elementos: List<ProductItem>? = null


    constructor(context: Context, elementos: List<ProductItem>) {
        this._context = context
        this._elementos = elementos
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1

        if (convertView == null) {
            val infalInflater = this._context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.product_item, null)
        }

        val txtListChild = convertView!!.findViewById(R.id.description) as TextView
        txtListChild.text = _elementos!![p0].text

        val rating = convertView.findViewById(R.id.rating) as TextView
        rating.text = _elementos!![p0].ratingLetter


        if (_elementos!![p0].src != null) {
            val icon = convertView.findViewById(R.id.item_icon) as ImageView
            val iconId = this._context!!.resources.getIdentifier(_elementos!![p0].src, "drawable", this._context!!.packageName)
            icon.setImageResource(iconId)
        }

        //android:src="@drawable/datos_movil"

        return convertView
    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {

    }

    override fun getItemViewType(p0: Int): Int {
        return 1
    }

    override fun getItem(p0: Int): Any {
        return _elementos!![p0]
    }

    override fun getViewTypeCount(): Int {
        return 2
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {

    }

    override fun getCount(): Int {
        return _elementos!!.count()
    }

    override fun isEnabled(p0: Int): Boolean {
        return true
    }

    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun isEmpty(): Boolean {
        return false
    }
}