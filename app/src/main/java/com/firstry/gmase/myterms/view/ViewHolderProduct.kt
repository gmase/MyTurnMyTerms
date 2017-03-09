package com.firstry.gmase.myterms.view

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.firstry.gmase.myterms.R
import com.firstry.gmase.myterms.model.Product
import java.util.*

/**
 * Created by Guille2 on 19/08/2016
 * Have fun
 */

class ViewHolderProduct(var mView: View) : RecyclerView.ViewHolder(mView), View.OnClickListener {
    var context: Context? = null
    var prods: MutableList<Product>

    var priceTV: TextView
    var productTV: TextView
    var companyLogoIM: ImageView
    var satisfactionIM: ImageView

    var default: String? = null

    init {
        prods = ArrayList<Product>()
        priceTV = mView.findViewById(R.id.product_price) as TextView
        productTV = mView.findViewById(R.id.product_name) as TextView
        companyLogoIM = mView.findViewById(R.id.company_icon) as ImageView
        satisfactionIM = mView.findViewById(R.id.satisfaction_icon) as ImageView
    }

    constructor(context: Context, mView: View, dataShow: MutableList<Product>, fm: FragmentManager) : this(mView) {
        this.context = context
        prods = dataShow
        /*done.setOnClickListener(this)

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                sliderValue = p1
                textSlider.text = AllQuestions.getId(questions.get(index = layoutPosition).id).getTemptingAnswer(sliderValue).text
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
        })
        optionsButtom.setOnClickListener {
            //todo
            val yourDialog = QuestionDialog()
            val args = Bundle()
            val lista: List<String>?
            lista = ArrayList<String>()
            for (i in questions.get(index = position).depend!!) {
                if (i.state == -1)
                    lista.add(i.YesPhrase)
                else
                    lista.add(i.NoPhrase)
            }
            //lista = questions.get(index = position).depend?.getPhrases()

            lista.add(default as String)
            args.putStringArrayList("lista", lista as ArrayList<String>?)
            args.putInt("position", position)
            yourDialog.arguments = args
            yourDialog.show(fm, "some_optional_tag")
        }
        */
    }

    override fun onClick(view: View) {
        val position: Int = layoutPosition // gets item position
        /*
        AllQuestions.setResult(questions.get(index = position).id, questions.get(index = position).getAnswerValue(textSlider.text.toString()), textSlider.text.toString(), AppDay.today())
        AllQuestions.computeTotals()
        rv.delete(position)
        */
    }

}


