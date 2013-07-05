/*
 * HorizontalScroll.java
 *
 * 05/07/2013 - 09:18:31
 *
 * Copyright: KaioSoares
 */

package com.example.horizontalscrollviewsnap;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * @author KaioSoares
 */
public class HorizontalScrollViewSnap extends HorizontalScrollView
{
	// ===================================================================================
	// ==================================== ATTRIBUTES ====================================
	// ===================================================================================
	private static final int MIN_DISTANCE = 10;
	
	private boolean scrolling;
	private boolean down;
	private Thread thread;
	private View centerView;
	
	// ===================================================================================
	// =================================== CONSTRUTORS ==================================
	// ===================================================================================
	
	public HorizontalScrollViewSnap(Context context, View centerView)
	{
		super(context);
		
		this.centerView = centerView;
	}
	
	public HorizontalScrollViewSnap(Context context)
	{
		super(context);
	}
	
	// ===================================================================================
	// ===================================== METHODS =====================================
	// ===================================================================================
	
	private void stopped()
	{
		LinearLayout linearLayout = (LinearLayout) getChildAt(0);
		
		int size = linearLayout.getChildCount();
		
		HitTest hitTest = new HitTest();
		int[] locationCurrentView = new int[2];
		int[] locationCenterView = new int[2];
		
		centerView.getLocationOnScreen(locationCenterView);
		
		for (int i = 0; i < size; i++)
		{
			View v = linearLayout.getChildAt(i);
			v.getLocationOnScreen(locationCurrentView);
			
			if (hitTest.hitTestX(locationCenterView[0], centerView.getWidth(), locationCurrentView[0], v.getWidth()))
			{
				final int value = i;
				
				float hitSize = hitTest.hitSizeX(locationCenterView[0], centerView.getWidth(), locationCurrentView[0], v.getWidth());
				
				if (hitSize >= 0.5)
				{
					post(new Runnable()
					{
						@Override
						public void run()
						{
							if (!down)
							{
								smoothScrollTo(value * 400, 0);
							}
						}
					});
					
					return;
					
				}
			}
		}
	}
	
	// ===================================================================================
	// ===================================== EVENTS ======================================
	// ===================================================================================
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt)
	{
		super.onScrollChanged(l, t, oldl, oldt);
		
		if (Math.abs(l - oldl) > MIN_DISTANCE)
		{
			scrolling = true;
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev)
	{
		
		if (ev.getAction() == MotionEvent.ACTION_DOWN)
		{
			down = true;
		}
		if (ev.getAction() == MotionEvent.ACTION_UP)
		{
			down = false;
			
			scrolling = true;
			
			if (thread != null)
			{
				thread.interrupt();
				thread = null;
			}
			
			thread = new Thread(new Runnable()
			{
				@Override
				public void run()
				{
					while (scrolling)
					{
						scrolling = false;
						try
						{
							Thread.sleep(50);
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
					
					stopped();
				}
			});
			
			thread.start();
		}
		
		return super.onTouchEvent(ev);
	}
	
	// ===================================================================================
	// ================================= GETTERS AND SETTERS ===============================
	// ===================================================================================
	
}
