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
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aName = arguments?.getString(FirstFragment.EXTRA_NAME)
        binding.tvName.text = "Halo $aName Silahkan Masukkan Jumlah Belanjaan Anda"
        binding.btnThirdFragment.setOnClickListener {
            if (binding.etPrice.text.isNullOrEmpty() || binding.etQty.text.isNullOrEmpty() || binding.etTax.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Ada Kolom Yang Kosong", Toast.LENGTH_SHORT).show()
            } else if(binding.etTax.text.toString().toDouble() > 100) {
                Toast.makeText(requireContext(), "Pajak Ngga Boleh Lebih Dari 100%", Toast.LENGTH_SHORT).show()
            }else {
                val price = binding.etPrice.text.toString().toInt()
                val qty = binding.etQty.text.toString().toInt()
                val tax = binding.etTax.text.toString().toDouble()
//                val dataParcelable = DataParcelable(price,qty,tax)
                val total = (price*(1+tax/100)*qty)
                val dataParcelable = DataParcelable(price,qty,tax,total)
                //binding.tvTotal.text = (price*qty*(1+tax/100)).toString()
                val actiontoThirdFragment =

                    FourthFragmentDirections.actionFourthFragmentToThirdFragment(aName.toString(),dataParcelable)
                it.findNavController().navigate(actiontoThirdFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}