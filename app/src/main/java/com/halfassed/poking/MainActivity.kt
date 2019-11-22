package com.halfassed.poking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.LinearLayout
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.TextView
import android.view.ViewGroup
import android.widget.Toast
import android.R.attr.y
import android.R.attr.x
import android.graphics.Color
import android.graphics.Point
import android.view.Display
import android.view.Gravity


class MainActivity : AppCompatActivity() {
    private val handler: Handler? = null

    // выводим сообщение
    //Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();

    var players: Array<ImageView>? = null
//    var rocks: Array<Rock>? = null
//    var board1: TextView? = null, var board2:TextView? = null
//    var left: Button? = null, var right:Button? = null

    var _speed: Int = 0
    var metrics = DisplayMetrics()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wallLayout = findViewById<LinearLayout>(R.id.wallContainer)
//        val p1Layout = findViewById<LinearLayout>(R.id.lPlayerLayout)
//        val p1IconLayout = findViewById<LinearLayout>(R.id.lIconLayout)
//        val p2Layout = findViewById<LinearLayout>(R.id.rPlayerLayout)
//        val p2IconLayout = findViewById<LinearLayout>(R.id.rIconLayout)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        // since orientation is landscape , swap em
        val width = size.y
        val height = size.x

        // calc all sizes
//
//        p1Layout.setHorizontalGravity(Gravity.CENTER)
//        p1Layout.setVerticalGravity(Gravity.LEFT)
//        p1IconLayout.setHorizontalGravity(Gravity.BOTTOM)
//        p1IconLayout.setVerticalGravity(Gravity.CENTER)


        // ti me for pads
        val padH8 = height/10
        val player1 = findViewById<ImageView>(R.id.lPadView)
        val player2 = findViewById<ImageView>(R.id.rPadView)
        player1.setBackgroundColor(Color.MAGENTA)
        player1.x = height/10.0
        player1.y = width/10.0
//        p1LayoutParams.gravity = Gravity.CENTER
        /*player1.layoutParams = p1LayoutParams

//        p1Layout.addView(player1)

        player2.setBackgroundColor(Color.CYAN)
        val p2LayoutParams = LinearLayout.LayoutParams(padH8, height/10)
//        p2LayoutParams.gravity = Gravity.CENTER or Gravity.BOTTOM
        player2.layoutParams = p2LayoutParams
//        p1Layout.addView(player2)
*/

        val rockCount = 3
        var elemCount = rockCount*2+1
        var insertX = 0
        while (elemCount > 0)
        {
            val rock = ImageView(this)
            var colour = 0
            var rockHeight = 0
            if (elemCount % 2 == 0)
            {
                // rock
                colour = Color.LTGRAY
                rockHeight = height/10
            }
            else
            {
                // wall
                colour = Color.DKGRAY
                rockHeight = height/6
            }

            rock.setBackgroundColor(colour)
            rock.layoutParams = LinearLayout.LayoutParams(rockHeight, height/10)
            wallLayout?.addView(rock)
            elemCount--
        }
        val padHeight = height / 50
        val padWidth = width / 40
        val lPad = ImageView(this)
        val rPad = ImageView(this)
        lPad.layoutParams = LinearLayout.LayoutParams(padHeight, padWidth)
        rPad.layoutParams = LinearLayout.LayoutParams(padHeight, padWidth)
        lPad.setBackgroundColor(Color.RED)
        rPad.setBackgroundColor(Color.BLUE)

//        linearLayout?.addView(lPad)
//        linearLayout?.addView(rPad)



/*
        // Create Button Dynamically
        val btnShow = Button(this)
        btnShow.
        btnShow.setText("yeah")
        btnShow.layoutParams = LinearLayout.LayoutParams(width/8, height)
        btnShow.setOnClickListener { Toast.makeText(this@MainActivity, "yikes!", Toast.LENGTH_LONG).show() }

        // Add Button to LinearLayout
        linearLayout?.addView(btnShow)
*/
    }
}
