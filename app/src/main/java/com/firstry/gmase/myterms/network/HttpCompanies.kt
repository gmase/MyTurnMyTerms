package com.firstry.gmase.myterms.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.firstry.gmase.myterms.model.Company

/**
 * Created by Guille2 on 07/03/2017
 * Have fun
 */
@JsonIgnoreProperties(ignoreUnknown = true)

class HttpCompanies {
    //val p: JSONArray
    var companies: ArrayList<Company> = ArrayList()
}