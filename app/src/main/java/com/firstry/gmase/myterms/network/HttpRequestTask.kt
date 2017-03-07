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
class HttpRequestTask constructor() : AsyncTask<Void, Void, ResponseEntity<HttpProducts>>() {
    var context: Context? = null
    //var question: Question? = null
    var userId: String? = null

    constructor(context: Context) : this() {
        this.context = context
    }

    private fun createHeaders(username: String, password: String): HttpHeaders {


        /*
        if (login != null && password != null) {
            val credentials = login + ':' + password
            val encoded = String(Base64.encode(credentials.toByteArray(charset(UTF8)), Base64.NO_WRAP))
            urlConnection.setRequestProperty("Authorization", "Basic " + encoded)
        }

        urlConnection.connectTimeout = connectionTimeOut
        urlConnection.readTimeout = socketTimeOut

        // Set Headers
        urlConnection.setRequestProperty("User-Agent", String.format("Android ACRA %1\$s", BuildConfig.VERSION_NAME)) //sent ACRA version to server
        urlConnection.setRequestProperty("Accept",
                "text/html,application/xml,application/json,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*;q=0.5")
        urlConnection.setRequestProperty("Content-Type", type.contentType)
        */

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
        var url = "http://rest-service.guides.spring.io/greeting"
        try {
            //todo estas 3 lineas sobran
            val restTemplate = RestTemplate()
            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())
            val HttpResponse = restTemplate.getForObject(url, HttpResponse::class.java)

            //var restTemplate = RestTemplate()
            //ResponseEntity<MyClass> response;
            val httpHeaders = this.createHeaders("theressithadfativerecear", "29daeac24d76a4a228d7bef5261bd2058fc8bbce")


            //val login = if (mUsername != null) mUsername else if (isNull(config!!.formUriBasicAuthLogin())) null else config!!.formUriBasicAuthLogin()
            //val password = if (mPassword != null) mPassword else if (isNull(config!!.formUriBasicAuthPassword())) null else config!!.formUriBasicAuthPassword()

            val config = ACRA.getConfig()

            val request = HttpRequest(config)
            request.setConnectionTimeOut(config.connectionTimeout())
            request.setSocketTimeOut(config.socketTimeout())
            request.setLogin("theressithadfativerecear")
            request.setPassword("29daeac24d76a4a228d7bef5261bd2058fc8bbce")
            request.setHeaders(config.httpHeaders)

            url = "https://gmase.cloudant.com/myterms"
            val content = "telecom_products"
            //val response: ResponseEntity<HttpProducts>
            //val response=request.send((context, url, HttpMethod.GET, reportAsString, mType!!)

            val response = restTemplate.exchange("https://gmase.cloudant.com/myterms/telecom_products", HttpMethod.GET, HttpEntity<Any>(httpHeaders), HttpProducts::class.java)


            val ret = HttpRetriever(config, HttpSender.Method.GET, HttpSender.Type.JSON, url, null)
            ret.setBasicAuth("theressithadfativerecear", "29daeac24d76a4a228d7bef5261bd2058fc8bbce")
            //val content = HttpContent(contentId = userId + question!!.id, content = "{\"_id\":\"" + userId + question!!.id + "\",\"internalResult\":" + question!!.result + ",\"textResult\":\"" + question!!.textResult + "\",\"day\":" + AppDay.today() + "}")

            //ret.retrieve(context!!, content)

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