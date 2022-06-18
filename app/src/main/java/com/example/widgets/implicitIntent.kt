package com.example.widgets

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import com.example.widgets.databinding.ActivityImplicitIntentBinding

//Membuat variable binding
private lateinit var binding: ActivityImplicitIntentBinding
class implicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//inisialisasi binding
binding = ActivityImplicitIntentBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >=23){
            if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA,
                android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
            }
        }

        binding.btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        binding.btnFile.setOnClickListener {
            val intent = Intent()
            intent.type = "*/*"
            intent.action =Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "pilih file"), 0)
        }
        binding.btnBrowser.setOnClickListener {
            val url = "http://google.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }
    }

}