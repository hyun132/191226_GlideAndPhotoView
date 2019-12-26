package com.example.a191226_glideandphotoview.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.a191226_glideandphotoview.R
import com.example.a191226_glideandphotoview.datas.User
import de.hdodenhof.circleimageview.CircleImageView

class UserInfoAdapter(context: Context, resId:Int, list:ArrayList<User> ):ArrayAdapter<User>(context,resId,list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        tempRow?.let {  }.let {
            tempRow = inf.inflate(R.layout.user_item,null)
        }

        var row =tempRow!!

        var data = mList.get(position)

        var ImgView = row.findViewById<CircleImageView>(R.id.userImgView)
        var NameTxt = row.findViewById<TextView>(R.id.userNameTxt)

        NameTxt.text = data.name
        Glide.with(mContext).load(data.img).centerCrop().into(ImgView)

        return row
    }
}