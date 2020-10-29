package com.supporters.svgeditor

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.caverock.androidsvg.SVG
import com.pixplicity.sharp.Sharp
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import yuku.ambilwarna.AmbilWarnaDialog

class MainActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var alien : Alien
    lateinit var alienSVG: SVG
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alien = Alien(this,R.drawable.ic_alien_red_no_tentacles,imageAlien)

//        VectorDrawableCompat.createFromPath("C:\\Users\\jay\\AndroidStudioProjects\\SVGEditor\\app\\src\\main\\res\\drawable\\ic_alien_red_no_tentacles.xml")
//        Log.e("Path Data", imageAlien.getPathModelByName("body").pathData)
//        imageAlien.getPathModelByName("body").fillColor = Color.BLACK

//        alienSVG = SVG.getFromAsset(assets,"alien.svg")
//        alienSVG.get
//
//
//        if(alienSVG.documentWidth != -1F){
//            Log.e("SVG","File found")
//            val newBitmap = Bitmap.createBitmap(ceil(alienSVG.documentWidth).toInt(),ceil(alienSVG.documentHeight).toInt(),Bitmap.Config.ARGB_8888)
//            val canvas = Canvas(newBitmap)
//
//            alienSVG.renderToCanvas(canvas)
//
//            imageAlien.setImageBitmap(newBitmap)
//        }

//        Sharp.loadAsset(assets,"alien.svg").into(imageAlien)

//        Picasso.get().load("https://de.wikipedia.org/wiki/Scalable_Vector_Graphics#/media/File:SVG_logo.svg").error(R.drawable.ic_launcher_foreground).into(imageAlien)

        btnBody.setOnClickListener(this)
        btnBorder.setOnClickListener(this)
        btnPupil.setOnClickListener(this)
        btnSmallDot.setOnClickListener(this)
        btnLargerDot.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        AmbilWarnaDialog(this,Color.parseColor("#ffffff"),object  : AmbilWarnaDialog.OnAmbilWarnaListener{
            override fun onCancel(dialog: AmbilWarnaDialog?) {
//                TODO("Not yet implemented")
            }

            override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
//                Log.e("View", "${p0!!.id} ${btnBody.id}")
                Toast.makeText(this@MainActivity,"${(p0 as Button).text}",Toast.LENGTH_SHORT).show()
                when(p0.id){
                    btnBody.id -> alien.setBodyColor(color)
                    btnBorder.id -> alien.setEyeBorderColor(color)
                    btnPupil.id -> alien.setEyePupilColor(color)
                    btnSmallDot.id -> alien.setEyeSmallDotColor(color)
                    btnLargerDot.id -> alien.setEyeLargerDotColor(color)
                }
            }
        }).show()
    }
}
