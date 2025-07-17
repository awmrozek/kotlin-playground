package com.example.myandroidapplication2

import android.content.Context
import android.graphics.*

class Bird(context: Context, screenWidth: Int, screenHeight: Int) {
    private val birdImage: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.bird)
    private var x: Float = screenWidth / 4f
    private var y: Float = screenHeight / 2f
    private var velocity = 0f
    private val gravity = 0.6f
    private val width = birdImage.width
    private val height = birdImage.height

    fun update() {
        velocity += gravity
        y += velocity
    }

    fun flap() {
        velocity = -10f
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(birdImage, x, y, null)
    }

    fun getRect(): Rect = Rect(x.toInt(), y.toInt(), x.toInt() + width, y.toInt() + height)
}
