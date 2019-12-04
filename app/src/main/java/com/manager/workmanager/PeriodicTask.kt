package com.manager.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by JAI on 04,July,2019
 * JAI KHAMBHAYTA
 */

class PeriodicTask(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        /**
         *e.g => Call api here to do work in background or insert data etc
         *
         */
        Log.d("jai", "PeriodicWork in BackGround")  // just log to print here
        return Result.success()
    }

}