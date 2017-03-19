package com.firstry.gmase.myterms.view

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.firstry.gmase.myterms.adapters.ProductsAdapter
import com.firstry.gmase.myterms.R
import com.firstry.gmase.myterms.adapters.SortedListAdapter
import com.firstry.gmase.myterms.databinding.ProductBoxBinding
import com.firstry.gmase.myterms.model.Product
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Guille2 on 19/08/2016
 * SortedListAdapter.ViewHolder<ExampleModel>
 * Have fun
 */

class ViewHolderProduct(val mBinding: ProductBoxBinding, val listener: ProductsAdapter.Listener) : SortedListAdapter.ViewHolder<Product>(mBinding.root) {
    override fun performBind(item: Product) {
        mBinding.productModel = (item)
    }

    var context: Context? = null
    /*
    var prods: MutableList<Product>
    var priceTV: TextView
    var productTV: TextView
    var companyLogoIM: ImageView
    var satisfactionIM: ImageView
    */

    var default: String? = null

    init {
        //prods = ArrayList<Product>()
        /*prods=products
        priceTV = itemView!!.findViewById(R.id.product_price) as TextView
        productTV = itemView.findViewById(R.id.product_name) as TextView
        companyLogoIM = itemView.findViewById(R.id.company_icon) as ImageView
        satisfactionIM = itemView.findViewById(R.id.satisfaction_icon) as ImageView
        */
    }
/*
    constructor(binding: ProductBoxBinding) : this() {
        super(binding.getRoot());
        mBinding = binding
    }*/
/*
    constructor(context: Context, dataShow: MutableList<Product>, fm: FragmentManager) : this() {
        this.context = context
        prods = dataShow
    }*/

    /*
    override fun onClick(view: View) {
        val position: Int = layoutPosition // gets item position
        /*
        AllQuestions.setResult(questions.get(index = position).id, questions.get(index = position).getAnswerValue(textSlider.text.toString()), textSlider.text.toString(), AppDay.today())
        AllQuestions.computeTotals()
        rv.delete(position)
        */
    }*/

}


