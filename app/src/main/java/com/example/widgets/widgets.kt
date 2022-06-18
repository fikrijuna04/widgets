package com.example.widgets

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widgets.databinding.ActivityWidgetsBinding
import com.google.android.material.snackbar.Snackbar

//Membuat variable binding
private lateinit var binding : ActivityWidgetsBinding
class widgets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inisialisai binding
        binding = ActivityWidgetsBinding.inflate(layoutInflater)
        //memangil layout dengan menggunakan binding.root
        setContentView(binding.root)
        //button Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText( this, "ini adalah Toast",Toast.LENGTH_SHORT).show()
        }

        //Button Snackbar
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it,"ini adalah snackbar",Snackbar.LENGTH_SHORT).show()
        }
        //Button Alert
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("massage")
                setMessage("ini adlah alert")

                setPositiveButton("ok") { dialog, _ ->
                    Toast.makeText(applicationContext, "anda klik ok", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }
                setNegativeButton ("Back"){ dialog, _ ->
                    Toast.makeText(applicationContext, "anda klik back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }.show()

        }
        //Button costume Daialog
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.costum_dialog)

                val BtnCancel = this.findViewById<Button>(R.id.btnCancel)
                val BtnContinue = this.findViewById<Button>(R.id.btnContinue)

                BtnCancel.setOnClickListener {
                    Toast.makeText(applicationContext,"anda klik cancel",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
                BtnContinue.setOnClickListener {
                    Toast.makeText(applicationContext,"anda klik continue",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }

    }
}