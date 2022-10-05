package com.example.kotlin

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AlertDialog
import coil.load
import coil.transform.CircleCropTransformation
import com.example.kotlin.databinding.ActivityMainBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var CAMERA_REQUEST_CODE = 1
    private var GALLARY_REQUEST_CODE = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cameraBtu.setOnClickListener {
            cameraCheckPermision()
        }
        binding.galarryBtu.setOnClickListener {
            galleryCheckPermisssion()
        }
        binding.imageView.setOnClickListener {
            val pictureDialog = AlertDialog.Builder(this)
            pictureDialog.setTitle("pick library")
            var pictureDialogItem = arrayOf("open gallery", "open camera")
            pictureDialog.setItems(pictureDialogItem) { pictureDialog, which ->
                when (which) {
                    0 -> gellary()
                    1 -> camera()
                }
            }
            pictureDialog.show()
        }
    }

    private fun camera() {
        val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,CAMERA_REQUEST_CODE)
    }

    private fun gellary() {
         val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,GALLARY_REQUEST_CODE)
    }

    private fun galleryCheckPermisssion() {
        Dexter.withContext(this).withPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            .withListener(object :PermissionListener{
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                     gellary()
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                     showRotationalDialogPermision()
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    p1: PermissionToken?
                ) {
                    showRotationalDialogPermision()
                }
            }).onSameThread().check()

    }

    private fun showRotationalDialogPermision() {


    }

    private fun cameraCheckPermision() {
        Dexter.withContext(this).withPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .withListener(object : MultiplePermissionsListener{
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    p0?.let { if (p0.areAllPermissionsGranted()){
                        camera()
                    }
                    }
                }
                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    showRotationalDialogPermision()
                }

            }).onSameThread().check()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
            Log.d("fffffffff", "reqqqqq"+" "+requestCode)
            when(requestCode){
                CAMERA_REQUEST_CODE->{
                    val bitmap=data?.extras?.get("data")as Bitmap
                    binding.imageView.load(bitmap){
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                    }
                }
                GALLARY_REQUEST_CODE->{
                    binding.imageView.load(data?.data){
                        Log.d("xxx", " "+" "+data.toString())
                        crossfade(true)
                        crossfade(1000)
                        transformations(CircleCropTransformation())
                    }
                }
            }

        }
    }
}