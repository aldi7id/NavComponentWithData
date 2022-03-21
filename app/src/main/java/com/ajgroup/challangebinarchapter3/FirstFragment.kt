package com.ajgroup.challangebinarchapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajgroup.challangebinarchapter3.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
   private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    companion object {
        private val EXTRA_NAME = "EXTRA NAME"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        super.onCreateView(view, savedInstanceState)
        binding.btnSecondFragment.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Binarian Pertama")
        }
    }
}