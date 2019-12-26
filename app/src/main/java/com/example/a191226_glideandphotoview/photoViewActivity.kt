package com.example.a191226_glideandphotoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_photo_view.*

class photoViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_view)
        setValues()
        setupEvents()
    }

    override fun setValues() {
        var data = intent.getStringExtra("userImg")
        Glide.with(mContext).load(data).into(userPhotoView)
    }

    override fun setupEvents() {

    }

}
