package com.firstry.gmase.myterms.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.firstry.gmase.myterms.adapters.SortedListAdapter

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ProductService : SortedListAdapter.ViewModel {
    var name: String? = null
    var type: String? = null
    var rating: Int? = null
    var compulsory: Boolean? = null

    val src: String?
    //val ratingLetter: String
    val ratingIcon: String?

    fun src(): String {
        val src: String
        when (type) {
            "fibra óptica" -> src = "ic_wifi_tethering_black_24dp"
            "4G" -> src = "ic_call_black_24dp"
            "TV" -> src = "ic_tv_black_24dp"
            else -> {
                src = "ic_attach_money_black_24dp"
            }
        }
        return src
    }

    fun ratingIcon(): String {
        val ratingIcon: String
        when (rating) {
            in 0..30 -> ratingIcon = "ic_one_dots"
            in 31..60 -> ratingIcon = "ic_two_dots"
            in 61..90 -> ratingIcon = "ic_three_dots"
            in 91..100 -> ratingIcon = "ic_four_dots"
            else -> {
                ratingIcon = "ic_one_dots"
            }
        }
        return ratingIcon
    }


    init {
        when (type) {
            "fibra óptica" -> src = "ic_wifi_tethering_black_24dp"
            "4G" -> src = "ic_call_black_24dp"
            "TV" -> src = "ic_attach_money_black_24dp"
            else -> {
                src = null
            }
        }
//        when (rating) {
//            in 0..20 -> ratingLetter = "D"
//            in 21..40 -> ratingLetter = "C"
//            in 41..60 -> ratingLetter = "B"
//            in 61..80 -> ratingLetter = "A"
//            in 81..100 -> ratingLetter = "A+"
//            else -> {
//                ratingLetter = "D"
//            }
//        }
        when (rating) {
            in 0..30 -> ratingIcon = "ic_one_dots"
            in 31..60 -> ratingIcon = "ic_two_dots"
            in 61..90 -> ratingIcon = "ic_three_dots"
            in 91..100 -> ratingIcon = "ic_four_dots"
            else -> {
                ratingIcon = null
            }
        }

    }
}