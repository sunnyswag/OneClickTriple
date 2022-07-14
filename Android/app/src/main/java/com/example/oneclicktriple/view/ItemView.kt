package com.example.oneclicktriple.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.oneclicktriple.R

@SuppressLint("InflateParams")
class ItemView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private val mIcon: ImageView
    private val mIconNumbers: TextView

    init {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.ItemView)

        val iconSrc = typedArray?.getDrawable(R.styleable.ItemView_icon_src)
        val iconNum = typedArray?.getString(R.styleable.ItemView_icon_numbers)
        // attach to this, otherwise, it don't work.
        val view = inflate(context, R.layout.item_view, this)
        // TODO reduce the view layer

        mIcon = view.findViewById<ImageView>(R.id.icon).apply {
            setImageDrawable(iconSrc)
        }

        mIconNumbers = view.findViewById<TextView>(R.id.numbers).apply {
            text = iconNum
        }

        typedArray?.recycle()
    }

}