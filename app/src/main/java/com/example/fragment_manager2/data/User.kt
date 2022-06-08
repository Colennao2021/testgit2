package com.example.fragment_manager2.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username :String
) :Parcelable