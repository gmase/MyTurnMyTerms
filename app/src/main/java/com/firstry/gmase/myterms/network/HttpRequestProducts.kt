package com.firstry.gmase.myterms.network


import android.content.Context
import android.os.AsyncTask
import android.support.design.widget.Snackbar
import android.util.Base64
import android.util.Log
import android.widget.Toast
import ch.acra.acra.BuildConfig
import com.firstry.gmase.myterms.R
import org.acra.ACRA
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import com.firstry.gmase.myterms.network.HttpProducts

/**
 * Created by Guille2 on 06/11/2016
 * Have fun
 */
class HttpRequestProducts constructor() : AsyncTask<Void, Void, ResponseEntity<HttpProducts>>() {
    var context: Context? = null
    var userId: String? = null

    constructor(context: Context) : this() {
        this.context = context
    }

    private fun createHeaders(username: String, password: String): HttpHeaders {

        val headers = object : HttpHeaders() {
            init {
                val auth = username + ":" + password
                val encoded = String(Base64.encode(auth.toByteArray(charset("UTF-8")), Base64.NO_WRAP))
                val authHeader = "Basic " + encoded
                set("Authorization", authHeader)
            }
        }
        headers.add("Content-Type", "HttpSender.Type.JSON")
        headers.add("Accept", "text/html,application/xml,application/json,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5")

        return headers
    }

    override fun doInBackground(vararg params: Void): ResponseEntity<HttpProducts>? {
        Log.e("HttpRequest", "background")
        try {
            val restTemplate = RestTemplate()
            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())
            val httpHeaders = this.createHeaders("theressithadfativerecear", "29daeac24d76a4a228d7bef5261bd2058fc8bbce")


            //val login = if (mUsername != null) mUsername else if (isNull(config!!.formUriBasicAuthLogin())) null else config!!.formUriBasicAuthLogin()
            //val password = if (mPassword != null) mPassword else if (isNull(config!!.formUriBasicAuthPassword())) null else config!!.formUriBasicAuthPassword()

            val config = ACRA.getConfig()

            /*
            val request = HttpRequest(config)
            request.setConnectionTimeOut(config.connectionTimeout())
            request.setSocketTimeOut(config.socketTimeout())
            request.setLogin("theressithadfativerecear")
            request.setPassword("29daeac24d76a4a228d7bef5261bd2058fc8bbce")
            request.setHeaders(config.httpHeaders)*/

            val url = "https://gmase.cloudant.com/myterms"
            val content = "telecom_products"

            val response = restTemplate.exchange(url + "/" + content, HttpMethod.GET, HttpEntity<Any>(httpHeaders), HttpProducts::class.java)
/*

            val ret = HttpRetriever(config, HttpSender.Method.GET, HttpSender.Type.JSON, url, null)
            ret.setBasicAuth("theressithadfativerecear", "29daeac24d76a4a228d7bef5261bd2058fc8bbce")
            val content = HttpContent(contentId = userId + question!!.id, content = "{\"_id\":\"" + userId + question!!.id + "\",\"internalResult\":" + question!!.result + ",\"textResult\":\"" + question!!.textResult + "\",\"day\":" + AppDay.today() + "}")

            ret.retrieve(context!!, content)
            */

            return response
        } catch (e: Exception) {
            Log.e("HttpRequest", e.message, e)
        }
        return null
    }

    override fun onPostExecute(httpResponse: ResponseEntity<HttpProducts>) {
        /*Log.e("HttpRequest", httpResponse.getId())
        Log.e("HttpRequest", httpResponse.getContent())*/
        val toast = Toast.makeText(context, "done", Toast.LENGTH_SHORT)
        toast.show()
    }
}