package com.example.vanil_singh.jobschedulers;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

/**
 * Created by Vanil-Singh on 9/19/2017.
 */

public class SyncJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast. makeText ( this , "Job Starts" , Toast. LENGTH_SHORT ).show();
        new JobTask( this ).execute(jobParameters);
        return true ;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Toast. makeText ( this , "Job Stopped: criteria not met" ,
                Toast. LENGTH_SHORT ).show();
        return false ;
    }
}
