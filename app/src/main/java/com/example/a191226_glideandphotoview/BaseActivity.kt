package com.example.a191226_glideandphotoview

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {
    var mContext =this

    abstract fun setValues()
    abstract fun setupEvents()
}