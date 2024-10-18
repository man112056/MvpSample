package com.manish.mvpsample

import android.os.Handler
import android.util.Log
import java.util.Arrays
import java.util.Random

class Model : Contract.Model {

    private val arrayList =
        Arrays.asList(
            "Data Science Bootcamp: Learn data analysis, machine learning, and visualization techniques for real-world applications.",
            "Full Stack Web Development: Master front-end and back-end development using modern frameworks and tools.",
            "Mobile App Development: Build and deploy mobile apps using Android and iOS platforms with hands-on projects.",
            "Cloud Computing Essentials: Get an in-depth understanding of cloud services, architectures, and deployment models.",
            "AI and Machine Learning: Dive into artificial intelligence concepts and implement machine learning algorithms in Python."
        );


    private val getRandomString: String
        get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }

    override fun getNewData(onFinishedListner: Contract.Model.OnFinishedListner) {
        Log.d("Manish", "Inside Model getNewData is called: ")
        Handler().postDelayed({ onFinishedListner.onFinished(getRandomString) }, 1200)
    }
}