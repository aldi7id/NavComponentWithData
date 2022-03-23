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
        val price = ThirdFragmentArgs.fromBundle(arguments as Bundle).price
        val qty = ThirdFragmentArgs.fromBundle(arguments as Bundle).qty
        val tax = ThirdFragmentArgs.fromBundle(arguments as Bundle).tax
        val total = ThirdFragmentArgs.fromBundle(arguments as Bundle).total

        binding.btnFourFragment.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "$aName")
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment, mBundle)
        }
        binding.tvName.text = "Selamat Datang $aName"
        binding.tvPrice.text = "Harga Barang: Rp. $price"
        binding.tvQty.text = "Jumlah Barang: $qty"
        binding.tvTax.text = "Pajak: $tax %"
        binding.tvTotal.text = "Rp. $total"
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}