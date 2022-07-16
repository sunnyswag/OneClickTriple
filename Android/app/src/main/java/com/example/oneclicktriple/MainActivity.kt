package com.example.oneclicktriple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.oneclicktriple.view.ItemView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemView = ItemView(ITEM_LIST.size, this)
        itemView.updateIconNumbers(ITEM_LIST)
        findViewById<ConstraintLayout>(R.id.rootView).addView(itemView)
    }

    companion object{
        val ITEM_LIST = arrayListOf(
            Pair(R.drawable.ic_like, "2万"),
            Pair(R.drawable.ic_coin, "3万"),
            Pair(R.drawable.ic_collect, "4万"),
            Pair(R.drawable.ic_share, "5万"), )
    }
}