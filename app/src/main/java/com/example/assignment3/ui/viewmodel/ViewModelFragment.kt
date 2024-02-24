package com.example.assignment3.ui.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.assignment3.R
import com.example.assignment3.databinding.MvvmFragmentBinding
import com.example.assignment3.ui.viewmodel.FragmentViewModel

class ViewModelFragment : Fragment() {
    private lateinit var binding: MvvmFragmentBinding
    private lateinit var viewModel: FragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MvvmFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[FragmentViewModel::class.java]

        binding.apply {
            addViewModelObservers()

            binding.root.findViewById<Button>(R.id.add_button).setOnClickListener {
                viewModel.add()
            }
            binding.root.findViewById<Button>(R.id.sub_button).setOnClickListener {
                viewModel.subtract()
            }
            binding.root.findViewById<Button>(R.id.mul_button).setOnClickListener {
                viewModel.multiply()
            }
            binding.root.findViewById<Button>(R.id.div_button).setOnClickListener {
                viewModel.divide()
            }

            binding.root.findViewById<EditText>(R.id.x_text).addTextChangedListener {
                viewModel.setX(it.toString())
            }

            binding.root.findViewById<EditText>(R.id.y_text).addTextChangedListener {
                viewModel.setY(it.toString())
            }
        }

        return binding.root
    }

    private fun MvvmFragmentBinding.addViewModelObservers() {
        viewModel.resultLiveData.observe(viewLifecycleOwner) { result ->
            binding.root.findViewById<TextView>(R.id.result_text).text = result.toString()
            binding.root.findViewById<EditText>(R.id.x_text).setText("")
            binding.root.findViewById<EditText>(R.id.y_text).setText("")
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Error, Invalid Inputs", Toast.LENGTH_SHORT).show()
        }
    }
}