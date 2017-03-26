package com.firstry.gmase.myterms.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by Guille2 on 08/03/2017
 * Have fun
 */

@JsonIgnoreProperties(ignoreUnknown = true)
object Products {
    var p: ArrayList<Product> = ArrayList()
    var f: Filters = Filters()
    fun count(): Int {
        return p.count()
    }
    fun filtered(): ArrayList<Product> {
        return f.filterAll(p)
    }
}