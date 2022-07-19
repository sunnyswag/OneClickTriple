package com.example.oneclicktriple.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.example.oneclicktriple.Utils

class CircleAnimView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val arcRect = RectF((width / 2).toFloat() - RADIUS, (height / 2).toFloat() - RADIUS,
        (width / 2).toFloat() + RADIUS, (height / 2).toFloat() + RADIUS)

    init {
        mPaint.apply {
            color = Color.parseColor("#e17c99")
            strokeWidth = 8F
            style = Paint.Style.STROKE
        }

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc(arcRect,
            0F, 360F, false, mPaint)
    }

    companion object{
        val RADIUS = Utils.dp2px(13F) // 半径
    }
}