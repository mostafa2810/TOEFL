package com.eltrend.toefl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class ContactUs : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
        MobileAds.initialize(this,"ca-app-pub-6572711285388576~1324320260")
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-6572711285388576/5370542338"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        var cr1=findViewById<View>(R.id.cr1)as CardView
        cr1.setOnClickListener {
            startActivity(Intent(this@ContactUs,PhoneCall::class.java))
        }
        var cr2=findViewById<View>(R.id.cr2)as CardView
        cr2.setOnClickListener {
            var i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://www.facebook.com/TOEFL.Helaly/")
            startActivity(i)
        }

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