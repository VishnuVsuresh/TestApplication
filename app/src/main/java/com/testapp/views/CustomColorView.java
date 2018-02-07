package com.testapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import com.testapp.R;

public class CustomColorView extends View {
        private Paint mPaint;
        private Paint mCenterPaint;
        private final int[] mColors= new int[] {
                0xFFFF0000, 0xFFFF00FF, 0xFF0000FF, 0xFF00FFFF, 0xFF00FF00,
                0xFFFFFF00, 0xFFFF0000
        };;

    private  float CENTER_X = 100;

    public CustomColorView(Context context) {
        super(context);
        init(context, null);
    }

    public CustomColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public  void init(Context c, AttributeSet attrs) {

        if (attrs != null) {
            final TypedArray a = c.obtainStyledAttributes(attrs,
                    R.styleable.CustomColorView, 0, 0);

            CENTER_X = a.getDimension(R.styleable.CustomColorView_radius,40);
        }

            Shader s = new SweepGradient(0, 0, mColors, null);
 
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setShader(s);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(15);
 

        }
 

 
        @Override 
        protected void onDraw(Canvas canvas) {
            float r = CENTER_X - mPaint.getStrokeWidth()*0.5f;
            canvas.translate(CENTER_X, CENTER_X);
            canvas.drawOval(new RectF(-r, -r, r, r), mPaint);
                    }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension((int) CENTER_X*2, (int) CENTER_X*2);
        }
    }
 