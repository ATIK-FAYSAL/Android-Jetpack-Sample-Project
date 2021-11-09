package com.example.androidjetpacksampleproject.core

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjetpacksampleproject.interfaces.InitComponent
import io.github.inflationx.viewpump.ViewPumpContextWrapper

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * Created 11/9/2021 at 11:56 AM
 */
abstract class BaseActivity : AppCompatActivity() , InitComponent
{
    /**
     * ...initialize all component
     * ...create object
     * ...call some necessary method
     */
    abstract override fun initialize()

    /**
     * Override Method to active calligraphy font in this activity
     * @param newBase - activity base
     */
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
}