package com.bryanollivie.appml.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import dagger.hilt.android.internal.Contexts

object AppUtils {

    fun hideKeyboardWithTouchView(context: Context,view: View) {
        view.setOnTouchListener { _, _ ->
            hideKeyboard(context, view)
            false
        }
    }

    fun validateField(editText: EditText):Boolean {
        return if (editText.text.toString().trim().isEmpty()) {
            editText.error = "Por favor, insira algum texto!"
            false
        }else{
            true
        }
    }

    fun showKeyboard(context: Context, view: View) {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
    fun hideKeyboard(context: Context, view: View) {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}