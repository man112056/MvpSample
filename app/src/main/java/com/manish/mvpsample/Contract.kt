package com.manish.mvpsample

interface Contract {
    interface Model {
        interface OnFinishedListner {
            fun onFinished(str: String?)
        }

        fun getNewData(onFinishedListner: OnFinishedListner)
    }

    interface View {

        fun showProgress()
        fun hideProgress()
        fun setString(newStr: String?)
    }

    interface Presenter {

        fun onButtonClickAction()
        fun onDestroy()
    }
}