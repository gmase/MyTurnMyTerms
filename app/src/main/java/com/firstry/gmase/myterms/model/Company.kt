package com.firstry.gmase.myterms.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.firstry.gmase.myterms.R

/**
 * Created by Guille2 on 01/03/2017
 * Have fun
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Company {
    var name: String? = null
    var id: String? = null
    var rating: Int? = null
    fun ratingIcon(): Int {
        val img: Int
        when (rating) {
            0 -> img = R.drawable.ic_sentiment_very_dissatisfied_black_24dp
            1 -> img = R.drawable.ic_sentiment_dissatisfied_black_24dp
            2 -> img = R.drawable.ic_sentiment_neutral_black_24dp
            3 -> img = R.drawable.ic_sentiment_satisfied_black_24dp
            4 -> img = R.drawable.ic_sentiment_very_satisfied_black_24dp
            else -> img = R.drawable.ic_sentiment_neutral_black_24dp
        }
        return img
    }
}