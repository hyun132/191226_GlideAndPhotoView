package com.example.a191226_glideandphotoview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.a191226_glideandphotoview.datas.User
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_user_info.*
import java.util.jar.Manifest

class userInfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        setValues()
        setupEvents()
    }

    override fun setValues() {
//        Glide.with(mContext).load(intent.getStringExtra("userImg")).into(userInfoImgView)

        var data = intent.getSerializableExtra("user") as User
        userInfoPhone.text = data.phone
        userInfoNameTxt.text=data.name
        Glide.with(mContext).load(data.img).into(userInfoImgView)

    }

    override fun setupEvents() {
        var data = intent.getSerializableExtra("user") as User
        userInfoImgView.setOnClickListener {
            var sendintent = Intent(mContext,photoViewActivity::class.java)
            sendintent.putExtra("userImg",data.img)
            startActivity(sendintent)
        }

        callBtn.setOnClickListener {

            var listener = object :PermissionListener{
                override fun onPermissionGranted() {
                    var uri = Uri.parse("tel:${data.phone}")
                    var intent = Intent(Intent.ACTION_CALL,uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext,"권한 설정이 필요합니다.",Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext).setPermissionListener(listener).setDeniedMessage("권한 설정이 필요합니다").setPermissions(android.Manifest.permission.CALL_PHONE).check()
        }


    }

}
