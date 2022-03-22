package com.ajgroup.challangebinarchapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ajgroup.challangebinarchapter3.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
   private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    companion object {
        val EXTRA_NAME = "EXTRA NAME"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSecondFragment.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Silahkan Masukkan Nama Terlebih Dahulu")
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, mBundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}