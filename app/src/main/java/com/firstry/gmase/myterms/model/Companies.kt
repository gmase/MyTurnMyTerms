package com.firstry.gmase.myterms.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by Guille2 on 08/03/2017
 * Have fun
 */

@JsonIgnoreProperties(ignoreUnknown = true)
object Companies {
    var c: ArrayList<Company> = ArrayList()

    fun count(): Int {
        return c.count()
    }

    fun get(nameIn: String): Company? {
        return c.firstOrNull { it.name == nameIn }
    }
}