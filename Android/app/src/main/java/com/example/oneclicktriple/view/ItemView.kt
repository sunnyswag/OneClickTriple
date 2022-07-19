package com.example.oneclicktriple.view

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.oneclicktriple.R

@SuppressLint("ViewConstructor")
class ItemView(itemNum: Int, context: Context?) : LinearLayout(context) {

    init {
        repeat(itemNum) {
            inflate(context, R.layout.item_view, this)
        }
    }

    /**
     * 更新所有 itemView，如果长度不符，将抛出 IndexOutOfBoundsException
     * @param itemList itemView 的 List
     */
    fun updateIconNumbers(itemList: ArrayList<Pair<Int, String>>) {
        if (itemList.size != childCount) {
            throw IndexOutOfBoundsException(
                "childCount and the itemView list count not the same!")
        }

        for (i in 0 until childCount) {
            val child = getChildAt(i)

            child.findViewById<ImageView>(R.id.icon)?.apply {
                setImageResource(itemList[i].first)
                setOnClickListener {
                    ObjectAnimator.ofFloat(it, "sweepAngle", 360F).apply {
                        duration = 3000
                        startDelay = 300
                        start()
                    }
                }
            }
            child.findViewById<TextView>(R.id.numbers)?.apply {
                text = itemList[i].second
            }

            // set tag
            child.tag = itemList[i]
        }
    }

    /**
     * 通过 tag 来更新某个 itemView 下的文字
     * @param targetTag 需要更新的 itemView 的 tag
     * @param num 更新的内容
     */
    fun updateIconNumbersByTag(targetTag: Any, num: String) {
        val view = findViewWithTag<LinearLayout>(targetTag)
        view.findViewById<TextView>(R.id.numbers).text = num
    }

}