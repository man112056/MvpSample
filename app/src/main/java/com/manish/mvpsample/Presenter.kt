package com.manish.mvpsample

class Presenter(private var mainView: Contract.View, private var model: Contract.Model) :
    Contract.Presenter, Contract.Model.OnFinishedListner {


    override fun onFinished(str: String?) {
        mainView?.hideProgress()
        mainView.setString(str)
    }

    override fun onButtonClickAction() {
        mainView?.showProgress()
        model.getNewData(this)
    }

    override fun onDestroy() {
        //NOOP
    }
}