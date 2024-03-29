package com.example.billz.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billz.R
import com.example.billz.databinding.FragmentSummaryBinding


class SummaryFragment : Fragment() {
    private  var binding :FragmentSummaryBinding? = null

//    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSummaryBinding.inflate(inflater,container,false)
        return  binding?.root
//        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onResume() {
        super.onResume()
        binding?.fabAddBill?.setOnClickListener {
            startActivity(Intent(requireContext(),AddBillActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}