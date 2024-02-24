package com.example.assignment3.ui.mvp

import android.util.Log


class MvpPresenter(private val view: CalculatorView) {
    private var num1: String = ""
    private var num2: String = ""

    fun setX(x: String) {
        this.num1 = x;
    }

    fun setY(y: String) {
        this.num2 = y;
    }

    fun add() {
        this.performOperation { it1, it2 ->
            this.view.setResult(it1 + it2);
        };
    }

    fun subtract() {
        this.performOperation { it1, it2 ->
            this.view.setResult(it1 - it2)
        }
    }

    fun multiply() {
        this.performOperation { it1, it2 ->
            this.view.setResult(it1 * it2)
        }
    }

    fun divide() {
        this.performOperation { it1, it2 ->
            this.view.setResult(it1 / it2)
        }
    }

    private val performOperation: (op: (x: Float, y: Float) -> Unit) -> Unit = { op ->
        val xFloat = this.num1.toFloatOrNull()
        val yFloat = this.num2.toFloatOrNull()

        if (xFloat != null && yFloat != null) {
            op(xFloat, yFloat)
        } else {
            this.view.error()
        }
    }

}