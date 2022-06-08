package com.example.fragment_manager2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.fragment_manager2.R

class DetailFragment : Fragment() {

    lateinit var txtName :TextView
    lateinit var btnBack :Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_detail, container, false)
        txtName=view.findViewById(R.id.txt_name)
        btnBack=view.findViewById(R.id.btn_back)
        return view
    }
}