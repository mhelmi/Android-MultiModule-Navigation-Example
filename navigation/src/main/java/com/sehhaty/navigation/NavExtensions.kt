package com.sehhaty.navigation

import android.content.Context
import android.content.Intent
import androidx.annotation.IdRes
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavController

fun NavController.navigateToDeepLink(
  deepLinkDestination: DeepLinkDestination
) {
  navigate(deepLinkDestination.address.toUri())
}

fun NavController.popGraphBackStack(@IdRes startDestinationId: Int) {
  if (!popBackStack(startDestinationId, true)) {
    navigateUp()
  }
}

fun Fragment.navigateToActivityDeeplink(
  deepLinkDestination: DeepLinkDestination
) {
  context?.navigateToActivityDeeplink(deepLinkDestination)
}

fun Context.navigateToActivityDeeplink(
  deepLinkDestination: DeepLinkDestination
) {
  val intent = Intent(Intent.ACTION_VIEW)
  intent.data = deepLinkDestination.address.toUri()
  startActivity(intent)
}

