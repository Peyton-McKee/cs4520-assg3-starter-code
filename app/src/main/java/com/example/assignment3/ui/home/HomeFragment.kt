package com.example.assignment3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assignment3.R

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val mvpButton = view.findViewById<Button>(R.id.mvpButton)
        mvpButton.setOnClickListener(this)

        val mvvmButton = view.findViewById<Button>(R.id.mvvmButton)
        mvvmButton.setOnClickListener(this)

        return view;
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.mvpButton -> {
                findNavController().navigate(R.id.mvp_fragment)
            }
            R.id.mvvmButton -> {
                findNavController().navigate(R.id.mvvm_fragment)
            }
        }
    }
}