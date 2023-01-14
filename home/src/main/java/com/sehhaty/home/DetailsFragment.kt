package com.sehhaty.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.sehhaty.navigation.DeepLinkDestination
import com.sehhaty.navigation.Hamada
import com.sehhaty.navigation.User
import com.sehhaty.navigation.navigateToActivityDeeplink
import com.sehhaty.navigation.popGraphBackStack
import kotlinx.android.synthetic.main.fragment_next.*


class DetailsFragment : Fragment() {

  val args: DetailsFragmentArgs by navArgs()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Toast.makeText(
      context,
      "User name is: ${
        Gson().fromJson(
          args.user,
          User::class.java
        ).name
      } && Hamada age is: ${Gson().fromJson(args.hamada, Hamada::class.java).age}",
      Toast.LENGTH_SHORT
    ).show()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_next, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    to_dash_fragment_deeplink_btn.setOnClickListener {
      setFragmentResult("result", bundleOf("testKey" to "Result from Details Screen"))
      findNavController().popGraphBackStack(R.id.homeFragment)
    }

    to_external_activity_deeplink_btn.setOnClickListener {
      navigateToActivityDeeplink(DeepLinkDestination.ExternalSecond("Hello from details fragment to External Second Fragment"))
    }
  }
}