package com.example.assignment1;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class seekBar extends AppCompatActivity {
     MediaPlayer mediaPlayer;
    public void play(View view){
        mediaPlayer.start();
    }
    public void pause(View view) {
        mediaPlayer.pause();
    }
    int progress;

    private AudioManager audioManager;
    private SeekBar seekBar;
    private TextView tvSeekBar;
    private Switch aSwitch;
    private RatingBar ratingBar;
    private TextView tvRatting;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
        int crntVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int mxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        setContentView(R.layout.activity_seek_bar);
        seekBar = findViewById(R.id.sekkBaar);
        tvSeekBar = findViewById(R.id.tvSeekbar);
        aSwitch = findViewById(R.id.switchid);
        mediaPlayer = MediaPlayer.create(this,R.raw.audio);
        tvSeekBar.setText("Volume: "+seekBar.getProgress()+"/"+seekBar.getMax());
        seekBar.setMax(mxVolume);
        seekBar.setProgress(crntVolume);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                tvSeekBar.setText("Volume: "+ progress +"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(seekBar.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(seekBar.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(seekBar.this, "On", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(seekBar.this, "Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ratingBar = findViewById(R.id.rattingBar);
        tvRatting = findViewById(R.id.tvRating);
        tvRatting.setText("Value: "+ratingBar.getProgress());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvRatting.setText("Value: "+rating);
            }
        });

        progressBar =findViewById(R.id.progressBar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        });
        thread.start();
    }
    public void doWork(){
        for(progress=10;progress<=500;progress+=10){
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}