package com.example.a191226_glideandphotoview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a191226_glideandphotoview.adapters.UserInfoAdapter
import com.example.a191226_glideandphotoview.datas.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var userAdapter :UserInfoAdapter? = null
    var userList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()
    }

    override fun setValues() {
        addListData()
        userAdapter = UserInfoAdapter(mContext,R.layout.user_item,userList)
        userListView.adapter = userAdapter
    }

    override fun setupEvents() {
        userListView.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent(mContext,userInfoActivity::class.java)
            intent.putExtra("user",userList.get(position))
            startActivity(intent)
        }
    }

    fun addListData(){
        userList.add(User("user1","data:image/jpeg;base64,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","01023235656"))
        userList.add(User("user2","data:image/jpeg;base64,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","01023477656"))
        userList.add(User("user3","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQL71IRoKTs1TemZQUUq0w2noiBUQXSoYZCHNf-ffAnpaVejLLF&s","01056786786"))
        userList.add(User("user4","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRr3447CZQA9a5Y976jMpB0ZlXLGIEWbrJz6u-QIn8w4efIWOLK&s","01023239356"))
        userList.add(User("user5","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTi1YQEkHUqfmFM1m3K7KHNZMkC-M4NTtLjMY-d1OO0l-qJ4KxV&s","01026848656"))
        userList.add(User("user6","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgpwzl-L5ynyD0oW-G1fhhvuUq57vRWzl3zuP3xDL_am3B4qrpUQ&s","01023255670"))
        userList.add(User("user7","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxYCmY4JMm4Us-t8rsUXFnJexQ3SxkNVBkZbvlhjfz1QOs4rHO5Q&s","01023235226"))
        userList.add(User("user8","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTDFN3LqKY9whmEepuQGwNH-hjTWtmarPCARIyHvggjFgftG4zSA&s","01023931626"))


    }

}
