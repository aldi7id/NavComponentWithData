package com.ajgroup.challangebinarchapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.ajgroup.challangebinarchapter3.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater,container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aName = arguments?.getString(FirstFragment.EXTRA_NAME)

        binding.tvName.text = "$aName"

        binding.btnThirdFragment.setOnClickListener {
            if (binding.etName.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom nama masih kosong", Toast.LENGTH_SHORT).show()
            } else {
                val nama = binding.etName.text.toString()
                val dataParcelable = DataParcelable(0,0,0.0,0.0)
                val actiontoThirdFragment =
                    SecondFragmentDirections.actionSecondFragmentToThirdFragment(nama, dataParcelable)
                it.findNavController().navigate(actiontoThirdFragment)

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}