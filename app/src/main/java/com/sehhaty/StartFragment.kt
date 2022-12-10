package com.sehhaty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sehhaty.multimodulenavigationexample.R
import com.sehhaty.navigation.DeepLinkDestination
import com.sehhaty.navigation.navigateToDeepLink
import com.sehhaty.navigation.popGraphBackStack
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_start, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // decide where to go on the first app launch, check auth tokens if login needed etc...
    lifecycleScope.launch {
      delay(2000)
      findNavController().popGraphBackStack(R.id.startFragment)
      findNavController().navigateToDeepLink(DeepLinkDestination.Dashboard("Hello From Start Screen"))
    }
  }
}