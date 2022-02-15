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

class Main5Activity : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        MobileAds.initialize(this,"ca-app-pub-6572711285388576~1324320260")
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-6572711285388576/5370542338"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        val myWebView3: WebView =findViewById(R.id.myURL3)
        myWebView3.webViewClient=object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        myWebView3.settings.javaScriptEnabled=true
        myWebView3.settings.allowContentAccess=true
        myWebView3.settings.domStorageEnabled=true
        myWebView3.settings.useWideViewPort=true
        myWebView3.settings.setAppCacheEnabled(true)

        myWebView3.loadUrl("https://drive.google.com/file/d/1ufXlgfSuKbjmqE8kS6lUg5XuOW_DTi84/view")


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