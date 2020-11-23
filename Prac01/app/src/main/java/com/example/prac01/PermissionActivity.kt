package com.example.prac01

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)


        Btn.setOnClickListener{
            val cameraPermissionCheck = ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.CAMERA
            )

            if(cameraPermissionCheck != PackageManager.PERMISSION_GRANTED){
                // 권한이 없는 경우
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    1000
                )
            }else{
                // 권한이 있는 경우
                Log.d("permissionn", "권한이 이미 있음")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1000){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // 승낙
                Log.d("permissionn", "승낙")
            }else{
                // 거부
                Log.d("permissionn", "거부")
            }
        }
    }
}
