package com.sehhaty.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.sehhaty.navigation.Data
import com.sehhaty.navigation.Hamada
import com.sehhaty.navigation.User
import com.sehhaty.navigation.popGraphBackStack
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_home, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    to_next_fragment_btn.setOnClickListener {
      findNavController().navigate(
        HomeFragmentDirections.actionHomeFragmentToNextFragment(
          Gson().toJson(
            User(
              2,
              "Ahmed"
            )
          ),
          Gson().toJson(Hamada(43, "1332"))
        )
      )
    }

    to_dashboard_flow.setOnClickListener {
      findNavController().popGraphBackStack(R.id.homeFragment)
    }
  }
}