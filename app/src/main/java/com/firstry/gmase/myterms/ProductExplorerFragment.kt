package com.firstry.gmase.myterms

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.provider.ContactsContract
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator
import android.R.attr.duration
import android.support.design.widget.Snackbar
import android.widget.Toast


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
    var mAdapter: SimpleCursorAdapter? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_main, container, false)
        //val textView = rootView.findViewById(R.id.section_label) as TextView

        val phoneButton= rootView.findViewById(R.id.phone_filter) as ImageButton
        val internetButton= rootView.findViewById(R.id.internet_filter) as ImageButton
        val tvButton= rootView.findViewById(R.id.tv_filter) as ImageButton
        val devicesButton= rootView.findViewById(R.id.devices_filter) as ImageButton

        /*textView.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))
        if (arguments.getInt(ARG_SECTION_NUMBER)==1)
            textView.text= getString(R.string.filters)*/
        val recycler=rootView.findViewById(R.id.recycler_products) as RecyclerView

        // Create a progress bar to display while the list loads
        val progressBar = ProgressBar(context)
        progressBar.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER.toFloat())
        progressBar.isIndeterminate = true

        // Must add the progress bar to the root of the layout
        //val root = findViewById(android.R.id.content) as ViewGroup
        //root.addView(progressBar)

        // For the cursor adapter, specify which columns go into which views
        val fromColumns = arrayOf(ContactsContract.Data.DISPLAY_NAME)
        val toViews = intArrayOf(android.R.id.text1) // The TextView in simple_list_item_1


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recycler.setHasFixedSize(false)
        // use a linear layout manager
        val mLayoutManager = ObjLayoutManager(context)
        recycler.layoutManager = mLayoutManager
        //var modelAdapeter: MyModeldApter? = null
        //val mAdapter = ProductsAdapter(modelAdapeter, supportFragmentManager)
        val mAdapter = ProductsAdapter( fragmentManager)
        recycler.adapter = mAdapter

        recycler.itemAnimator = FadeInRightAnimator() as RecyclerView.ItemAnimator?


        var phoneFilter = false
        var internetFilter=false
        var tvFilter=false
        var giftsFilter=false
        phoneButton.setOnClickListener { view ->
            if (phoneFilter)
                phoneButton.background.clearColorFilter()
            else {
                phoneButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.phone_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
            phoneFilter=!phoneFilter
        }

        internetButton.setOnClickListener { view ->
            if (internetFilter)
                internetButton.background.clearColorFilter()
            else {
                internetButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                //val toast = Toast.makeText(context, getString(R.string.internet_selected), Toast.LENGTH_SHORT)
                //toast.show()
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.internet_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
            internetFilter=!internetFilter
        }

        tvButton.setOnClickListener { view ->
            if (tvFilter)
                tvButton.background.clearColorFilter()
            else {
                tvButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.tv_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
            tvFilter=!tvFilter
        }

        devicesButton.setOnClickListener { view ->
            if (giftsFilter)
                devicesButton.background.clearColorFilter()
            else {
                devicesButton.background.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY)
                Snackbar.make(view, getString(R.string.i_want) + getString(R.string.gifts_selected), Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
            giftsFilter=!giftsFilter
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