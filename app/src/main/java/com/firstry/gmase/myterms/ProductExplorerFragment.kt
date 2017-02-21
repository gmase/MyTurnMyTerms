package com.firstry.gmase.myterms

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.provider.ContactsContract
import android.support.v4.widget.SimpleCursorAdapter
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ProgressBar
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator


/**
 * Created by Guille2 on 19/02/2017
 * Have fun
 */
    class ProductExplorerFragment : Fragment(){
    // This is the Adapter being used to display the list's data
    var mAdapter: SimpleCursorAdapter? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater!!.inflate(R.layout.fragment_main, container, false)
            val textView = rootView.findViewById(R.id.section_label) as TextView
            textView.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))
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

        recycler.itemAnimator = FadeInRightAnimator()


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