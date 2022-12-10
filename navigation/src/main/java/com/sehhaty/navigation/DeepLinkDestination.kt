package com.sehhaty.navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class DeepLinkDestination(val address: String) {
  class Dashboard(msg: String) : DeepLinkDestination("sehhaty://dashboard?msg=${msg}")
  object Home : DeepLinkDestination("sehhaty://home")
  class Details(user: User) : DeepLinkDestination("sehhaty://details?user=$user")
  class ExternalStart(message: String) :
    DeepLinkDestination("sehhaty://external?msg=${message}")
  class ExternalSecond(message: String) :
    DeepLinkDestination("sehhaty://external/second?msg=${message}")
}


@Parcelize
data class User(val id: Long = 1, val name: String = "Muhammad") : Parcelable