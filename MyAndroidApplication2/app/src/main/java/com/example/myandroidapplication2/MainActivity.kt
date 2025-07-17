package com.example.myandroidapplication2

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var gameView: GameView? = null

    protected override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        gameView = GameView(this)
        setContentView(gameView)
    }
}