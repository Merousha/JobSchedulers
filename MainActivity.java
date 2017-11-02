package com.example.vanil_singh.jobschedulers;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button jobSchedule;
    private static final int JOB_ID = 0x00 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final JobInfo job = new JobInfo.Builder( JOB_ID , new ComponentName( this ,
                SyncJobService. class ))
                .setRequiresCharging( true )
                .build();
        final JobScheduler jobScheduler = (JobScheduler)
                getSystemService(Context. JOB_SCHEDULER_SERVICE );

        jobSchedule =(Button)findViewById(R.id.schedule_job);

        jobSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobScheduler.schedule( job );
            }
        });

    }
}
