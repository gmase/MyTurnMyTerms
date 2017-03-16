package com.firstry.gmase.myterms.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.firstry.gmase.myterms.R
import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Product : SortedListAdapter.ViewModel {
    var name: String? = null
    var id: String? = null
    var base_price: Float? = null
    var permanencia: Int? = null
    var company: String? = null
    var services: ArrayList<ProductService>? = null

    fun companyLogo(): Int {
        val companyLogo: Int
        when (company) {
            "movistar" -> companyLogo = R.drawable.movistar
            "simyo" -> companyLogo = R.drawable.simyo
            "jazztel" -> companyLogo = R.drawable.jazztel
            "masmovil" -> companyLogo = R.drawable.masmovil
            "orange" -> companyLogo = R.drawable.orange
            "vodafone" -> companyLogo = R.drawable.vodafone
            "yoigo" -> companyLogo = R.drawable.yoigo
        //TODO pepefone...

            else -> companyLogo = R.drawable.simyo//TODO no logo
        }
        return companyLogo
    }

    fun priceString(): String {
        return base_price.toString() + '$'
    }
}

