package com.firstry.gmase.myterms.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Product {
    var name: String? = null
    var id: String? = null
    var base_price: Float? = null
    var permanencia: Int? = null
}

