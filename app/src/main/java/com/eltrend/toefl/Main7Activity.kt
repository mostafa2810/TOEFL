package com.eltrend.toefl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class Main7Activity : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        MobileAds.initialize(this,"ca-app-pub-6572711285388576~1324320260")
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-6572711285388576/5370542338"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        val myWebView7: WebView =findViewById(R.id.myURL7)
        myWebView7.webViewClient=object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        myWebView7.settings.javaScriptEnabled=true
        myWebView7.settings.allowContentAccess=true
        myWebView7.settings.domStorageEnabled=true
        myWebView7.settings.useWideViewPort=true
        myWebView7.settings.setAppCacheEnabled(true)

        myWebView7.loadUrl("https://drive.google.com/file/d/1nIyIFvO6I6Ku-qOZPLvy9Eczkja678x1/view")


    }
    override fun onBackPressed() {
        mInterstitialAd.adListener = object: AdListener() {
            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                mInterstitialAd.loadAd(AdRequest.Builder().build())

            }
        }
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.")

        }
        super.onBackPressed()
    }
}