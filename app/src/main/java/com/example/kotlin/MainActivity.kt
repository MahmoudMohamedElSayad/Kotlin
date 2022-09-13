package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.example.kotlin.utils.uuu

class MainActivity : AppCompatActivity() {
    var x  = 7
    var y=5
    var w :Int?  =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
    }

    private fun main() {
        var result=if((x+y)==15) 7 else 8
            Toast.makeText(this, "${w!! - 5}", Toast.LENGTH_SHORT).show()
    }
}