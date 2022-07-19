package com.example.oneclicktriple.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.example.oneclicktriple.Utils

class CircleAnimView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var sweepAngle: Float = 0.0f
        get() = field
        set(value) {
            field = value
            invalidate()
        }

    init {
        mPaint.apply {
            color = Color.parseColor("#e17c99")
            strokeWidth = STROKE_WIDTH
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc((width / 2).toFloat() - RADIUS, (height / 2).toFloat() - RADIUS,
            (width / 2).toFloat() + RADIUS, (height / 2).toFloat() + RADIUS,
            INITIAL_ANGLE, sweepAngle, false, mPaint)
    }

    companion object{
        val RADIUS = Utils.dp2px(17F) // 半径
        val STROKE_WIDTH = Utils.dp2px(2F) // 半径
        const val INITIAL_ANGLE = 270F // 初始角度
    }
}