package com.sehhaty.navigation

import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

sealed class DeepLinkDestination(val address: String) {
  class Dashboard(msg: String) : DeepLinkDestination("sehhaty://dashboard?msg=${msg}")
  object Home : DeepLinkDestination("sehhaty://home")
  class Details(user: User, hamada: Hamada) :
    DeepLinkDestination("sehhaty://details?user=${Gson().toJson(user)}&hamada=${Gson().toJson(hamada)}")

  class ExternalStart(message: String) :
    DeepLinkDestination("sehhaty://external?msg=${message}")

  class ExternalSecond(message: String) :
    DeepLinkDestination("sehhaty://external/second?msg=${message}")
}

@Parcelize
data class User(val id: Long = 1, val name: String = "Muhammad") : Parcelable

@Parcelize
data class Hamada(val age: Long = 30, val dob: String = "1-4-1992") : Parcelable

@Parcelize
data class Data(val user: User = User(), val hamada: Hamada = Hamada()) : Parcelable