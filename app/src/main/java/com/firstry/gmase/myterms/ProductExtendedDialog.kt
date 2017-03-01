package com.firstry.gmase.myterms

import android.support.v4.app.DialogFragment
import java.util.*

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
class ProductExtendedDialog : DialogFragment() {
    var mListener: OnTagSelectedListener? = null
    var position: Int? = null
    var list: ArrayList<String>? = null

    interface OnTagSelectedListener {
        fun OnTagSelectedListener(position: Int, InputTag: String)
    }

}