package com.example.miniproyecto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.ArcShape;
import android.view.View;

public class LienzoPath extends View {

    public LienzoPath(Context context) {
        super(context);
    }
    protected void onDraw(Canvas canvas) {
        String texto_a_dibujar= "Feliz Año a todos";
        canvas.drawRGB(0, 0, 255);
        Path camino1 = new Path();

        RectF rectF= new RectF(0,0, 400,320);

        camino1.addOval(rectF,Path.Direction.CW);
        camino1.offset(300,200);


        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 255, 0, 0);
        pincel1.setTextSize(70);
        pincel1.setTextAlign(Paint.Align.RIGHT);
//        pincel1.setAntiAlias(true);
       // pincel1.setStyle(Paint.Style.STROKE);
       // canvas.drawPath(camino, pincel1);
        pincel1.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(texto_a_dibujar, camino1, 0, 0,
                pincel1);


        Path camino2 = new Path();
        RectF recta = new RectF(0,0, 400,320);

        camino2.addRect(recta,Path.Direction.CW);
        camino2.offset(500,400);


        Paint pincel2 = new Paint();
        pincel2.setARGB(255, 255, 0, 255);
        pincel2.setTextSize(70);
        pincel2.setTextAlign(Paint.Align.RIGHT);
        pincel2.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(texto_a_dibujar, camino2, 0, 0,
                pincel2);

        Path camino3 = new Path();
        camino3.lineTo(500,1500);

        Paint pincel3 = new Paint();
        pincel3.setARGB(255, 0, 255, 0);
        pincel3.setTextSize(70);
        pincel3.setTextAlign(Paint.Align.RIGHT);
        pincel3.setStyle(Paint.Style.FILL);
        canvas.drawTextOnPath(texto_a_dibujar, camino3, 0, 0,
                pincel3);
    }
}
