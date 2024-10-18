package com.manish.mvpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), Contract.View {
    private var textView: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null
    private var presenter: Presenter? = null

    // creating object of Presenter interface in Contract
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Manish", "Inside MainActivity onCreate: is called ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        button?.setOnClickListener {
            presenter?.onButtonClickAction()
        }
    }

    override fun showProgress() {
        Log.d("Manish", "Inside MainActivity showProgress: is called ")

        progressBar?.visibility = View.VISIBLE
        textView?.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        Log.d("Manish", "Inside MainActivity hideProgress: is called ")

        progressBar?.visibility = View.INVISIBLE
        textView?.visibility = View.VISIBLE
    }

    override fun setString(newStr: String?) {
        Log.d("Manish", "Inside MainActivity setString: is called ")
        textView?.text = newStr
    }
}