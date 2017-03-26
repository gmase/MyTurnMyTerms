package com.firstry.gmase.myterms.model

import android.os.Bundle


/**
 * Created by Guille2 on 09/03/2017
 * Have fun
 */
class Filters {
    var f: ArrayList<Filter> = ArrayList()
    fun add(type: Int, qualifier: String = "", quantifier: Float = 0f) {
        f.add(Filter(type, qualifier, quantifier))
    }

    fun remove(type: Int, qualifier: String = "", quantifier: Float = 0f) {
        //val index=find(type,qualifier,quantifier)
        val index = f.indexOfFirst { it.type == type && it.qualifier == qualifier && it.quantifier == quantifier }
        if (index != -1)
            f.removeAt(index)
    }

    fun find(type: Int, qualifier: String = "", quantifier: Float = 0f): Int {
        return f.indexOfFirst { it.type == type && it.qualifier == qualifier && it.quantifier == quantifier }
    }

    fun filterAll(prods: ArrayList<Product>): ArrayList<Product> {
        val filtered = prods.clone() as ArrayList<Product>
        val iterate = filtered.listIterator()
        var p: Product
        if (f.size > 0)
            while (iterate.hasNext()) {
                p = iterate.next()
                for (fil in f) {
                    if (!fil.pass(p)) {
                        iterate.remove()
                        break
                    }
                }
            }
        return filtered
    }

    class Filter(val type: Int, val qualifier: String = "", val quantifier: Float = 0f) {
        /*
        type:
        0 - Has service qualifier
        1 - qualifier service better than quantifier

          numbers.forEach({(number: Int) ->
                if (number > 0) {
                    sum = sum + number
                }
            })

         */
        fun pass(prod: Product): Boolean {
            when (type) {
                0 -> {
                    prod.services
                            .filter { it.type == qualifier }
                            .forEach { return true }
                }
                else -> {
                    return false
                }
            }

            return false
}
    }
}

