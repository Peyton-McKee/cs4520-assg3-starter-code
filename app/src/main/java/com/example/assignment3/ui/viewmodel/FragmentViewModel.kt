package com.example.assignment3.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {
    private var num1: String = ""
    private var num2: String = ""

    val resultLiveData: MutableLiveData<Float> by lazy {
        MutableLiveData<Float>()
    }

    val errorLiveData: MutableLiveData<Unit> by lazy {
        MutableLiveData<Unit>()
    }

    fun setX(x: String) {
        Log.v("viewModel", "setting x $x")
        num1 = x
    }

    fun setY(y: String) {
        num2 = y
    }

    fun add() {
        performOperation { it1, it2 ->
            resultLiveData.postValue(it1 + it2)
        }
    }

    fun subtract() {
        performOperation { it1, it2 ->
            resultLiveData.postValue(it1 - it2)
        }
    }

    fun multiply() {
        performOperation { it1, it2 ->
            resultLiveData.postValue(it1 * it2)
        }
    }

    fun divide() {
        performOperation { it1, it2 ->
            if (it2 != 0f) {
                resultLiveData.postValue(it1 / it2)
            } else {
                errorLiveData.postValue(Unit)
            }
        }
    }

    private fun performOperation(op: (Float, Float) -> Unit) {
        Log.v("viewModel", "$num1 $num2")

        val xFloat = num1.toFloatOrNull()
        val yFloat = num2.toFloatOrNull()

        if (xFloat != null && yFloat != null) {
            op(xFloat, yFloat)
        } else {
            errorLiveData.postValue(Unit)
        }
    }
}