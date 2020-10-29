package com.supporters.svgeditor

import android.content.Context
import android.widget.ImageView
import com.devs.vectorchildfinder.VectorChildFinder

/*
    com.supporters.svgeditor
    Created by:  Dhananjay Jhinkwan
    Date: 25-10-2020
*/

class Alien(private val context: Context, private val vectorId : Int, private val imageView: ImageView) {
    private var alien = VectorChildFinder(context,vectorId,imageView)
    private var bodyColor = alien.findPathByName("body").fillColor
    private var borderColor = alien.findPathByName("eyeBorder").fillColor
    private var pupilColor = alien.findPathByName("eyePupil").fillColor
    private var smallDotColor = alien.findPathByName("eyeSmallDot").fillColor
    private var largerDotColor = alien.findPathByName("eyeLargerDot").fillColor


    fun setBodyColor(color: Int) {
        bodyColor = color
        invalidate()
    }

    fun setEyeBorderColor(color: Int) {
        borderColor = color
        invalidate()
    }

    fun setEyePupilColor(color: Int) {
        pupilColor = color
        invalidate()
    }

    fun setEyeSmallDotColor(color: Int) {
        smallDotColor = color
        invalidate()
    }

    fun setEyeLargerDotColor(color: Int) {
        largerDotColor = color
        invalidate()
    }

    private fun invalidate(){
        alien = VectorChildFinder(context,vectorId,imageView)
        alien.findPathByName("body").fillColor = bodyColor
        alien.findPathByName("eyeBorder").fillColor = borderColor
        alien.findPathByName("eyePupil").fillColor = pupilColor
        alien.findPathByName("eyeSmallDot").fillColor = smallDotColor
        alien.findPathByName("eyeLargerDot").fillColor = largerDotColor
    }

}