package com.firstry.gmase.myterms

import android.databinding.DataBindingUtil
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.firstry.gmase.myterms.adapters.ProductItemsAdapter
import com.firstry.gmase.myterms.adapters.ProductsAdapter
import com.firstry.gmase.myterms.databinding.FragmentMainBinding
import com.firstry.gmase.myterms.databinding.ProductBoxBinding
import com.firstry.gmase.myterms.model.Product
import com.firstry.gmase.myterms.model.Filters
import com.firstry.gmase.myterms.model.Products
import java.util.*


/**
 * Created by Guille2 on 19/02/2017
 * Have fun
 */
class ProductExplorerFragment : Fragment(), ProductExtendedDialog.OnTagSelectedListener {
    override fun OnTagSelectedListener(position: Int, InputTag: String) {
        /*val mRV = findViewById(R.id.my_recycler_view) as RecyclerView
        if (inputTag == resources.getString(R.string.other)) {
            (mRV.adapter as CardsAdapter).deleteByTag(position, Tag(tagId = "zzz"))
        } else (mRV.adapter as CardsAdapter).deleteByTag(position, TagDictionary.getByPhrase(inputTag)!!)*/
    }

    // This is the Adapter being used to display the list's data
    // var mAdapter: SimpleCursorAdapter? = null

    private val ALPHABETICAL_COMPARATOR = Comparator<Product> { a, b -> a.name!!.compareTo(b.name!!) }
    private val PRICE_COMPARATOR = Comparator<Product> { a, b -> a.base_price!!.compareTo(b.base_price!!) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val rootView = inflater!!.inflate(R.layout.fragment_main, container, false)

        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val rootView = binding.root

        val phoneButton= rootView.findViewById(R.id.phone_filter) as ImageButton
        val internetButton= rootView.findViewById(R.id.internet_filter) as ImageButton
        val tvButton= rootView.findViewById(R.id.tv_filter) as ImageButton
        val devicesButton= rootView.findViewById(R.id.devices_filter) as ImageButton

        //Secondary buttons
        val mobile4GButton = rootView.findViewById(R.id.mobile_4g) as Button
        val mobileDataButton = rootView.findViewById(R.id.mobile_data) as ImageButton


        val mAdapter = ProductsAdapter(context, Product::class, PRICE_COMPARATOR, object : ProductsAdapter.Listener {
            override fun onExampleModelClicked(model: Product) {
                //val message = getString(R.string.model_clicked_pattern, model.getText())
                //Snackbar.make(mBinding.getRoot(), message, Snackbar.LENGTH_SHORT).show()
            }
        })

        binding.recyclerProducts.layoutManager = LinearLayoutManager(context)
        //binding.recyclerProducts.adapter = mAdapter as RecyclerView.Adapter<*>
        binding.recyclerProducts.adapter = mAdapter
        mAdapter.edit()
                .replaceAll(Products.filtered())
                .commit()

        // Create a progress bar to display while the list loads
        val progressBar = ProgressBar(context)
        progressBar.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER.toFloat())
        progressBar.isIndeterminate = true

/*
        val binding2: ProductBoxBinding = DataBindingUtil.inflate(inflater, R.layout.product_box, container, false)
        val mAdapter2 = ProductItemsAdapter(context, Products.p[1].services)
        binding2.productItemList.adapter = mAdapter2*/


        //val recycler=rootView.findViewById(R.id.recycler_products) as RecyclerView
        // recycler.setHasFixedSize(false)

        /*
        val mLayoutManager = ObjLayoutManager(context)
        recycler.layoutManager = mLayoutManager
        recycler.adapter = mAdapter
        recycler.itemAnimator = FadeInRightAnimator() as RecyclerView.ItemAnimator?
        */


        var phoneFilter = false
        var internetFilter=false
        var tvFilter=false
        var giftsFilter=false

        var mobileDataFilter = false
        var mobile4GFilter = false

        phoneButton.setOnClickListener { view ->
            if (phoneFilter) {
                phoneButton.background.clearColorFilter()
                Products.f.remove(0, "4G")

                mobile4GButton.visibility = Button.GONE
                mobileDataButton.visibility = ImageButton.GONE

            }
            else {
                phoneButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.phone_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
                Products.f.add(0, "4G")

                mobile4GButton.visibility = Button.VISIBLE
                mobileDataButton.visibility = ImageButton.VISIBLE

            }
            phoneFilter=!phoneFilter


            mAdapter.edit()
                    .replaceAll(Products.filtered())
                    .commit()
        }

        internetButton.setOnClickListener { view ->
            if (internetFilter) {
                internetButton.background.clearColorFilter()
                Products.f.remove(0, "landline")
            }
            else {
                internetButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.internet_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
                Products.f.add(0, "landline")
            }
            internetFilter=!internetFilter
            mAdapter.edit()
                    .replaceAll(Products.filtered())
                    .commit()
        }

        tvButton.setOnClickListener { view ->
            if (tvFilter) {
                tvButton.background.clearColorFilter()
                Products.f.remove(0, "TV")
            }
            else {
                tvButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.tv_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
                Products.f.add(0, "TV")
            }
            tvFilter=!tvFilter
            mAdapter.edit()
                    .replaceAll(Products.filtered())
                    .commit()
        }

        devicesButton.setOnClickListener { view ->
            if (giftsFilter)
                devicesButton.background.clearColorFilter()
            else {
                devicesButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.gifts_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
            giftsFilter=!giftsFilter
            mAdapter.edit()
                    .replaceAll(Products.filtered())
                    .commit()
        }

        //secondary buttons
        mobileDataButton.setOnClickListener { view ->
            if (mobileDataFilter)
                mobileDataButton.background.clearColorFilter()
            else {
                mobileDataButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.mobile_tons_data), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
            mobileDataFilter = !mobileDataFilter
            mAdapter.edit()
                    .replaceAll(Products.filtered())
                    .commit()
        }

        mobile4GButton.setOnClickListener { view ->
            if (mobile4GFilter)
                mobile4GButton.background.clearColorFilter()
            else {
                mobile4GButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.mobile_4g), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
            mobile4GFilter = !mobile4GFilter
            mAdapter.edit()
                    .replaceAll(Products.filtered())
                    .commit()
        }

        return rootView
        }


    companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): ProductExplorerFragment {
                //TODO distintas llamadas para cargar un fagment u otro
                val fragment = ProductExplorerFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }