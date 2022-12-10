package com.sehhaty.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sehhaty.navigation.DeepLinkDestination
import com.sehhaty.navigation.User
import com.sehhaty.navigation.navigateToDeepLink
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {
  private val dashboardFragmentArgs: DashboardFragmentArgs by navArgs()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    dashboardFragmentArgs.msg.let {
      if (it.isNotEmpty()) {
        Toast.makeText(requireContext(), dashboardFragmentArgs.msg, Toast.LENGTH_SHORT).show()
      }
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_dashboard, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setFragmentResultListener("result") { _, bundle ->
      val s = bundle.getString("testKey")
      Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
    }

    navigate_to_home_btn.setOnClickListener {
      findNavController().navigateToDeepLink(DeepLinkDestination.Home)
    }

    navigate_to_details_deeplink.setOnClickListener {
      findNavController().navigateToDeepLink(DeepLinkDestination.Details(User()))
    }
  }
}