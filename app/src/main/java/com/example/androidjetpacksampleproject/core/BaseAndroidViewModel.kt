package com.example.androidjetpacksampleproject.core

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.androidjetpacksampleproject.interfaces.InitComponent
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Atik Faysal (Android Developer)
 * Create on 1/17/2021
 * Email: mdatikfaysal@gmail.com
 * *** Happy Coding ***
 */

@SuppressLint("StaticFieldLeak")
abstract class BaseAndroidViewModel : ViewModel(), InitComponent
{
    protected lateinit var mContext : Context
    protected lateinit var disposable : CompositeDisposable

    /**
     * ...initialize all component
     * ...create object
     * ...call some necessary method
     */
    override fun initialize(){}
}