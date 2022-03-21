package com.ajgroup.challangebinarchapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ajgroup.challangebinarchapter3.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding : FragmentThirdBinding? = null
    private val binding get() = _binding!!
    companion object {
        val EXTRA_NAME = "EXTRA NAME"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aName = ThirdFragmentArgs.fromBundle(arguments as Bundle).name
        val address = ThirdFragmentArgs.fromBundle(arguments as Bundle).address
        val age = ThirdFragmentArgs.fromBundle(arguments as Bundle).age
        val job = ThirdFragmentArgs.fromBundle(arguments as Bundle).job

        binding.btnFourFragment.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "$aName")
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, mBundle)
        }
        binding.tvName.text = "Nama Anda : $aName"
        binding.tvAge.text = "Usia Anda : $age"
        binding.tvAddress.text = "Alamat Anda : $address"
        binding.tvJob.text = "Pekerjaan Anda: $job"
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}