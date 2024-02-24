package com.example.assignment3.ui.mvp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.assignment3.R
import com.example.assignment3.databinding.MvpFragmentBinding

interface CalculatorView {
    fun setResult(result: Float);
    fun error();
}

class MvpFragment : Fragment(), CalculatorView, View.OnClickListener {
    private lateinit var binding: MvpFragmentBinding
    private var presenter = MvpPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //bind my mvp fragment
        binding = MvpFragmentBinding.inflate(inflater, container, false)

        binding.root.findViewById<Button>(R.id.add_button).setOnClickListener (this)

        binding.root.findViewById<Button>(R.id.sub_button).setOnClickListener (this)

        binding.root.findViewById<Button>(R.id.mul_button).setOnClickListener (this)

        binding.root.findViewById<Button>(R.id.div_button).setOnClickListener (this)

        binding.root.findViewById<EditText>(R.id.x_text).addTextChangedListener {
            this.presenter.setX(it.toString())
        }

        binding.root.findViewById<EditText>(R.id.y_text).addTextChangedListener {
            this.presenter.setY(it.toString())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun setResult(result: Float) {
        binding.root.findViewById<TextView>(R.id.result_text).text = result.toString()
        binding.root.findViewById<EditText>(R.id.x_text).setText("")
        binding.root.findViewById<EditText>(R.id.y_text).setText("")
    }

    override fun error() {
        Toast.makeText(context, "Error, Invalid Inputs", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add_button -> {
                this.presenter.add()
            }
            R.id.sub_button -> {
               this.presenter.subtract()
            }
            R.id.mul_button -> {
                this.presenter.multiply()
            }
            R.id.div_button -> {
                this.presenter.divide()
            }
        }
    }
}