package com.bryanollivie.appml.util

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bryanollivie.appml.R

fun Fragment.showErrorLayout(msg: String, tryAgain: () -> Unit) {
    val viewErro = LayoutInflater.from(context).inflate(R.layout.error_layout, null)
    val textViewErro = viewErro.findViewById<TextView>(R.id.textViewErro)
    val buttonTentarNovamente = viewErro.findViewById<Button>(R.id.buttonTryAgain)

    textViewErro.text = msg
    buttonTentarNovamente.setOnClickListener { tryAgain() }
    viewErro.visibility = View.VISIBLE

    val container = view?.findViewById<ViewGroup>(com.google.android.material.R.id.container)
    container?.removeAllViews()
    container?.addView(viewErro)
}

fun Fragment.hideErrorLayout() {
    val viewErro = LayoutInflater.from(context).inflate(R.layout.error_layout, null)
    viewErro.visibility = View.GONE

}

