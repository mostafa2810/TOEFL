package com.eltrend.toefl

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast


import com.eltrend.toefl.R
import com.google.android.gms.ads.*

class Main2Activity : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        MobileAds.initialize(this,"ca-app-pub-6572711285388576~1324320260")
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-6572711285388576/5370542338"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val cm= baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        if (networkInfo!= null && networkInfo.isConnected){

            if (networkInfo.type == ConnectivityManager.TYPE_WIFI){
                Toast.makeText(baseContext,"Connected Via WIFI Network", Toast.LENGTH_LONG).show()
            }

            if (networkInfo.type == ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(baseContext,"Connected Via MOBILE Network", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(baseContext,"No internet Connection", Toast.LENGTH_LONG).show()
            this.finish()
        }

     var textView = findViewById<View>(R.id.cr1) as TextView
       textView.setOnClickListener{
           mInterstitialAd.adListener = object: AdListener() {
               override fun onAdClosed() {
                   // Code to be executed when the interstitial ad is closed.
                   mInterstitialAd.loadAd(AdRequest.Builder().build())
                   startActivity(Intent(this@Main2Activity, placementestActivity::class.java))

               }
           }
           if (mInterstitialAd.isLoaded) {
               mInterstitialAd.show()
           } else {
               Log.d("TAG", "The interstitial wasn't loaded yet.")
               startActivity(Intent(this@Main2Activity, placementestActivity::class.java))
           }




       }
        var textView2 = findViewById<View>(R.id.cr2) as TextView
        textView2.setOnClickListener{
            mInterstitialAd.adListener = object: AdListener() {
                override fun onAdClosed() {
                    // Code to be executed when the interstitial ad is closed.
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                     startActivity(Intent(this@Main2Activity, HowToUseTheApp::class.java))

                }
            }
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
                 startActivity(Intent(this@Main2Activity, HowToUseTheApp::class.java))
            }




        }
        var textView3 = findViewById<View>(R.id.cr3) as TextView
        textView3.setOnClickListener{
            mInterstitialAd.adListener = object: AdListener() {
                override fun onAdClosed() {
                    // Code to be executed when the interstitial ad is closed.
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                    startActivity(Intent(this@Main2Activity, MainActivity3::class.java))

                }
            }
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
                startActivity(Intent(this@Main2Activity, MainActivity3::class.java))
            }




        }
        var textView4 = findViewById<View>(R.id.cr4) as TextView
        textView4.setOnClickListener{
            mInterstitialAd.adListener = object: AdListener() {
                override fun onAdClosed() {
                    // Code to be executed when the interstitial ad is closed.
                    mInterstitialAd.loadAd(AdRequest.Builder().build())
                   startActivity(Intent(this@Main2Activity, ContactUs::class.java))

                }
            }
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
               startActivity(Intent(this@Main2Activity, ContactUs::class.java))
            }




        }
        var textView5 = findViewById<View>(R.id.cr5) as TextView
        textView5.setOnClickListener{
            var i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://play.google.com/store/apps/details?id=com.eltrend.american")
            startActivity(i)

        }
    }
}
