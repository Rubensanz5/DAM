package com.example.miniproyecto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class CanvasDibujo extends View {

    float x,y;
    public Paint paint = new Paint();
    public Path path = new Path();
    public Bitmap mBitmap;
    public Canvas mCanvas;
    public Paint mBitMapPaint = new Paint(Paint.DITHER_FLAG);


    public CanvasDibujo(Context context) {
        super(context);
        paint.setColor(Color.RED);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        canvas.drawBitmap(mBitmap,0,0,mBitMapPaint);
        canvas.drawPath(path,paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
         x = (int)motionEvent.getX();
         y = (int)motionEvent.getY();

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
		        path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
		        path.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                mCanvas.drawPath(path,paint);
                path.reset();
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        invalidate();
        return true;
    }
}
