package com.example.oneclicktriple.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.oneclicktriple.R
import java.lang.Exception

class ItemView: LinearLayout {

    constructor(itemList:  ArrayList<Pair<Int, String>>, context: Context?): super(context) {

        for (item in itemList) {
            val view = inflate(context, R.layout.item_view, this)
            // TODO reduce the view layer

            view.findViewById<ImageView>(R.id.icon).apply {
                setImageResource(item.first)
            }

//            Log.d("huiqinhuang", item.second)
            val numView = view.findViewById<TextView>(R.id.numbers)
            numView.apply {
                text = item.second
            }
            Log.d("huiqinhuang", numView.text.toString())
        }
    }

    constructor(context: Context?, attrs: AttributeSet?): super(context, attrs)

    /**
     * 更新所有 itemView 图标下的文字，如果长度不符，将抛出 xxx Exception
     * @param numList 文字的 List
     */
    fun updateIconNumbers(vararg numList: String) {
        if (numList.size != childCount) {
            throw Exception() // TODO define specific Exception
        }

        for (i in 0..childCount) {
            getChildAt(i).findViewById<TextView>(R.id.numbers).text = numList[i]
        }
    }

    /**
     * 通过 tag 来更新某个 itemView 下的文字
     * @param targetTag 需要更新的 itemView 的 tag
     * @param num 更新的内容
     *
     * @return 是否更新成功
     */
    fun updateIconNumbersByTag(targetTag: Any, num: String) {
        val view = findViewWithTag<LinearLayout>(targetTag)
        view.findViewById<TextView>(R.id.numbers).text = num
    }

}