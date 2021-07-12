package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        Button btn =(Button)findViewById(R.id.changeprogressbarBtn);
        Button add = (Button)findViewById(R.id.addProgress);
        Button minus = (Button)findViewById(R.id.minusProgress);
        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //三种状态 Visible Invisible(隐藏，但原来位置还有) Gone(移除)
                if (progressBar.getVisibility() == View.VISIBLE) {
                    progressBar.setVisibility(View.GONE);
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setProgress(progressBar.getProgress()+1);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setProgress(progressBar.getProgress()-1);
            }
        });

    }
}
