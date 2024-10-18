package com.manish.mvpsample

import android.util.Log

class Presenter(private var mainView: Contract.View, private var model: Contract.Model) :
    Contract.Presenter, Contract.Model.OnFinishedListner {


    override fun onFinished(str: String?) {
        Log.d("Manish", "inside Presenter onFinished: ")
        mainView.hideProgress()
        mainView.setString(str)
    }

    override fun onButtonClickAction() {
        Log.d("Manish", "inside Presenter onButtonClickAction: ")

        mainView.showProgress()
        model.getNewData(this)
    }

    override fun onDestroy() {
        Log.d("Manish", "inside Presenter onDestroy: ")
    }
}