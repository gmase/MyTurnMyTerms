package com.firstry.gmase.myterms

import android.app.Application
import org.acra.ACRA
import org.acra.ReportingInteractionMode
import org.acra.annotation.ReportsCrashes

@ReportsCrashes(
        formUri = "https://gmase.cloudant.com/acra-myterms/_design/acra-storage/_update/report",
        reportType = org.acra.sender.HttpSender.Type.JSON,
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        formUriBasicAuthLogin = "firlywhearightfultwomill",
        formUriBasicAuthPassword = "b3f6bca5bbc6d7f281b8e692bde5d13b80930640",
        // Your usual ACRA configuration
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text
)

/**
 * Created by Guille2 on 07/03/2017
 * Have fun
 */
class MyTerms : Application() {
    override fun onCreate() {
        // The following line triggers the initialization of ACRA
        super.onCreate()
        ACRA.init(this)
    }
}