package com.firstry.gmase.myterms.model

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
class ProductItem(type: Int, val text: String, rating: Int) {
    val src: String?
    //val ratingLetter: String
    val ratingIcon: String?

    init {
        when (type) {
            1 -> src = "ic_wifi_tethering_black_24dp"
            2 -> src = "ic_call_black_24dp"
            3 -> src = "ic_attach_money_black_24dp"
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