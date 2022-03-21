package com.ajgroup.challangebinarchapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.ajgroup.challangebinarchapter3.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnThirdFragment.setOnClickListener {
            if (binding.etAge.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Umur harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                val actiontoThirdFragment =
                    FourthFragmentDirections.actionFourthFragmentToThirdFragment(binding.etAge.text.toString())
                it.findNavController().navigate(actiontoThirdFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}