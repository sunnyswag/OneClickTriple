package com.example.oneclicktriple.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleAnimView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        mPaint.color = Color.parseColor("#e17c99")
        mPaint.strokeWidth = 6F
        mPaint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle((width / 2).toFloat(), (height / 2).toFloat(),
            (width / 2).toFloat() - mPaint.strokeWidth, mPaint)
    }
}