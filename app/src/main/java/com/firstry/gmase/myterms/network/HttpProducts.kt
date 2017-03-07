package com.firstry.gmase.myterms.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.firstry.gmase.myterms.model.Product
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by Guille2 on 07/03/2017
 * Have fun
 */
@JsonIgnoreProperties(ignoreUnknown = true)

class HttpProducts {
    //val products: JSONArray
    var products: ArrayList<Product> = ArrayList()
    /*
    init {
        var i=0
        while (i<products.length())
        {
            val obj=products[i] as JSONObject
            productList.add(Product(obj.getString("name"),obj.getString("id"),obj.getDouble("base_price").toFloat(),obj.getInt("permanencia")))
            i++
        }
    }
    */

}