package com.manish.mvpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), Contract.View {
    // creating object of TextView class
    private var textView: TextView? = null

    // creating object of Button class
    private var button: Button? = null

    // creating object of ProgressBar class
    private var progressBar: ProgressBar? = null

    private var presenter: Presenter? = null

    // creating object of Presenter interface in Contract
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // assigning ID of the TextView
        textView = findViewById(R.id.textView)

        // assigning ID of the Button
        button = findViewById(R.id.button)

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        button?.setOnClickListener {
            presenter?.onButtonClickAction()
        }

        // operations to be performed when
        // user clicks the button
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
        textView?.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar?.visibility = View.INVISIBLE
        textView?.visibility = View.VISIBLE
    }

    override fun setString(newStr: String?) {
        textView?.text = newStr
    }
}