package com.example.oneclicktriple.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.example.oneclicktriple.Utils

class CircleAnimView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val arcRect : RectF

    init {
        mPaint.apply {
            color = Color.parseColor("#e17c99")
            strokeWidth = 8F
            style = Paint.Style.STROKE
        }

        arcRect = RectF((width / 2).toFloat() - RADIUS, (height / 2).toFloat() - RADIUS,
            (width / 2).toFloat() + RADIUS, (height / 2).toFloat() + RADIUS)
        Log.d("huiqing", arcRect.toString() + "width / 2: ${height / 2}, width / 2: ${height / 2}")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("huiqing", arcRect.toString() + "width / 2: ${height / 2}, width / 2: ${height / 2}")
        canvas?.drawArc(arcRect,
            0F, 360F, true, mPaint)
    }

    companion object{
        val RADIUS = Utils.dp2px(15F) // 半径
    }
}