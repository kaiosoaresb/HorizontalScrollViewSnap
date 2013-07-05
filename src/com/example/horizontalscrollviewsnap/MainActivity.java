package com.example.horizontalscrollviewsnap;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity
{
	
	private RelativeLayout linearLayout;
	private HorizontalScrollViewSnap horizontalScrollView;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		View centerView = new View(getApplicationContext());
		
		horizontalScrollView = new HorizontalScrollViewSnap(this, centerView);
		setContentView(R.layout.activity_main);
		linearLayout = (RelativeLayout) findViewById(R.id.layout_main);
		linearLayout.addView(horizontalScrollView);
		
		LinearLayout container = new LinearLayout(this);
		container.setLayoutParams(new LayoutParams(width, LayoutParams.MATCH_PARENT));
		container.setPadding(400, 0, width - (800), 0);
		
		width = 400;
		height = 400;
		
		TextView textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("One  Screen");
		textView.setBackgroundColor(Color.CYAN);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Two  Screen");
		textView.setBackgroundColor(Color.GREEN);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Three  Screen");
		textView.setBackgroundColor(Color.RED);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Four  Screen");
		textView.setBackgroundColor(Color.BLACK);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Five  Screen");
		textView.setBackgroundColor(Color.BLUE);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Six  Screen");
		textView.setBackgroundColor(Color.MAGENTA);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Seven  Screen");
		textView.setBackgroundColor(Color.DKGRAY);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Eight  Screen");
		textView.setBackgroundColor(Color.YELLOW);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Nine  Screen");
		textView.setBackgroundColor(Color.LTGRAY);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Ten  Screen");
		textView.setBackgroundColor(Color.CYAN);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Eleven  Screen");
		textView.setBackgroundColor(Color.GREEN);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Twelve  Screen");
		textView.setBackgroundColor(Color.RED);
		container.addView(textView, new LinearLayout.LayoutParams(width, height));
		
		horizontalScrollView.addView(container);
		
		centerView.setBackgroundColor(Color.argb(150, 255, 0, 0));
		
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(400, 450);
		params.setMargins(400, 0, 0, 0);
		
		linearLayout.addView(centerView, params);
	}
	
}
