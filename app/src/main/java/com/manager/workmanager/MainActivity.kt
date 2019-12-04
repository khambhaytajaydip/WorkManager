package com.manager.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
/**
 * Created by JAI on 04,July,2019
 * JAI KHAMBHAYTA
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.setOnClickListener {
            tvService.text = "Start workManager"
            /**
             *  There are two types of WorkRequests:

            OneTimeWorkRequest: A WorkRequest that will only execute once.
            PeriodicWorkRequest: A WorkRequest that will repeat on a cycle.
             */

            WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
                "firstTask",
                ExistingPeriodicWorkPolicy.KEEP, // alternative  ExistingPeriodicWorkPolicy.REPLACE -> existing with it if exist
                 PeriodicWorkRequest.Builder(
                    PeriodicTask::class.java,  // worker class
                    15,   // minimum set work to 15 min time interval
                    TimeUnit.MINUTES)
                    .addTag("FIRSTJOB") // tag for cancel work manager
                    .setConstraints(
                        Constraints.Builder().
                            setRequiredNetworkType(NetworkType.CONNECTED).build() // setup type of work network/battery etc
                    ).build()
            )
        }
        btnStop.setOnClickListener {
            tvService.text = "Stop workManager"
            WorkManager.getInstance(applicationContext).cancelAllWorkByTag("FIRSTJOB")
        }

    }
}
