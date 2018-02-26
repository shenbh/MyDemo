package com.example.testsurfaceview;



import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {


	private NodeProgressBar ssl;
	private SeekBar seekbar;
	private RatingBar ratingbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tts);
		seekbar = (SeekBar) findViewById(R.id.progress);
		ssl=(NodeProgressBar) findViewById(R.id.ssl);
		ratingbar=(RatingBar)findViewById(R.id.ratingbarId);
		seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int index, boolean arg2) {
				// TODO Auto-generated method stub
				ssl.setProgressAndIndex(index);
				
			}
		});
		
		ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar arg0, float index, boolean arg2) {
				// TODO Auto-generated method stub
				ssl.setProgressByNode(index);
			}
		});

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}



}
