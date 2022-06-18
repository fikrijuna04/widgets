package com.example.widgets

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelLogin(
    var username : String,
    var password : String
) : Parcelable
