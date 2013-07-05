/*
 * HitTest.java
 *
 * 05/07/2013 - 10:45:52
 *
 * Copyright: KaioSoares
 */
package com.example.horizontalscrollviewsnap;

/**
 * @author KaioSoares
 */
public class HitTest
{
	public boolean hitTestX(int left1, int width1, int left2, int width2)
	{
		boolean hit = false;
		
		if ((((left2 >= left1) && (left2 <= left1 + width1)) || ((left2 + width2 >= left1) && (left2 + width2 <= left1 + width1))))
		{
			hit = true;
		}
		return hit;
	}
	
	public float hitSizeX(float left1, float width1, float left2, float width2)
	{
		float hSize = 0;
		float tempHSize = 0;
		
		if ((left2 + width2 > left1) && (left2 < left1))
		{
			hSize = ((width2 - left1 + left2) / width2);
		}
		else if ((left2 > left1) && (left2 + width2 < left1 + width1))
		{
			hSize = 1;
		}
		else if ((left2 > left1 + width1) || (left2 + width2 < left1))
		{
			hSize = 0;
		}
		else
		{
			tempHSize = left2 + width2 - left1 - width1;
			
			if (tempHSize >= 0)
			{
				hSize = (width2 - tempHSize) / width2;
			}
			else
			{
				hSize = 0;
			}
		}
		
		return (hSize);
		
	}
}