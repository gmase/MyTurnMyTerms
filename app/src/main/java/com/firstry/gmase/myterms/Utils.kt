package com.firstry.gmase.myterms


import android.widget.ListView

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
class Utils {

    fun setListViewHeightBasedOnChildren(listView: ListView) {
        val listAdapter = listView.adapter ?: // pre-condition
                return

        var totalHeight = 0
        for (i in 0..listAdapter.count - 1) {
            val listItem = listAdapter.getView(i, null, listView)
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }

        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight * (listAdapter.count - 1)
        listView.layoutParams = params
        listView.requestLayout()
    }
}