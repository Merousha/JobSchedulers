package com.example.vanil_singh.jobschedulers;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

/**
 * Created by Vanil-Singh on 9/19/2017.
 */

class JobTask extends AsyncTask<JobParameters, Void,
        JobParameters> {
    private final JobService jobService ;
    public JobTask(JobService jobService) {
        this . jobService = jobService;
    }
    @Override
    protected JobParameters doInBackground(JobParameters... params) {
        SystemClock. sleep ( 5000 );
        return params[ 0 ];
    }
    @Override
    protected void onPostExecute(JobParameters jobParameters) {
        jobService .jobFinished(jobParameters, false );
        Toast. makeText ( jobService , "Task Finished" ,
                Toast. LENGTH_SHORT ).show();
    }
}
