package com.firstry.gmase.myterms

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.provider.ContactsContract
import android.support.v4.content.CursorLoader
import android.support.v4.widget.SimpleCursorAdapter
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ProgressBar


/**
 * Created by Guille2 on 19/02/2017
 * Have fun
 */
    class ProductExplorerFragment : Fragment(), LoaderManager.LoaderCallbacks<Cursor> {
    // This is the Adapter being used to display the list's data
    var mAdapter: SimpleCursorAdapter? = null

    // These are the Contacts rows that we will retrieve
    val PROJECTION = arrayOf(ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME)

    // This is the select criteria
    val SELECTION = "((" +
            ContactsContract.Data.DISPLAY_NAME + " NOTNULL) AND (" +
            ContactsContract.Data.DISPLAY_NAME + " != '' ))"

    override fun onLoaderReset(loader: Loader<Cursor>?) {
        mAdapter!!.swapCursor(null)
    }

    override fun onLoadFinished(loader: Loader<Cursor>?, data: Cursor?) {
        mAdapter!!.swapCursor(data)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        return CursorLoader(context, ContactsContract.Data.CONTENT_URI,
                PROJECTION, SELECTION, null, null)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater!!.inflate(R.layout.fragment_main, container, false)
            val textView = rootView.findViewById(R.id.section_label) as TextView
            val listView= rootView.findViewById(R.id.list1) as ListView
            textView.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))

        // Create a progress bar to display while the list loads
        val progressBar = ProgressBar(context)
        progressBar.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER.toFloat())
        progressBar.isIndeterminate = true
        listView.emptyView = progressBar

        // Must add the progress bar to the root of the layout
        //val root = findViewById(android.R.id.content) as ViewGroup
        //root.addView(progressBar)

        // For the cursor adapter, specify which columns go into which views
        val fromColumns = arrayOf(ContactsContract.Data.DISPLAY_NAME)
        val toViews = intArrayOf(android.R.id.text1) // The TextView in simple_list_item_1

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        mAdapter = SimpleCursorAdapter(context,android.R.layout.simple_list_item_1, null,fromColumns, toViews, 0)
        listView.adapter = mAdapter

        // Prepare the loader.  Either re-connect with an existing one,
        // or start a new one.
        loaderManager.initLoader(0, null, this)

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