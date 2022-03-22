package com.ajgroup.challangebinarchapter3

import android.content.Intent
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
        val aName = arguments?.getString(FirstFragment.EXTRA_NAME)
        binding.tvName.text = "$aName"
        binding.btnThirdFragment.setOnClickListener {
            if (binding.etPrice.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Harganya Berapa?", Toast.LENGTH_SHORT).show()
            } else {
                val price = binding.etPrice.text.toString().toInt()
                val qty = binding.etQty.text.toString().toInt()
                val tax = binding.etTax.text.toString().toInt()
                binding.tvTotal.text = (price*qty*(1+tax/100)).toString()
                val actiontoThirdFragment =
                    FourthFragmentDirections.actionFourthFragmentToThirdFragment(
                        binding.tvName.text.toString(),
                        binding.etPrice.text.toString(),
                        binding.etQty.text.toString(),
                        binding.etTax.text.toString(),
                        binding.tvTotal.text.toString())
                it.findNavController().navigate(actiontoThirdFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}