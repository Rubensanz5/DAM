package com.example.actividad_40;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Lienzo extends View {
    public Lienzo(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(255,255,255);
        int ancho = canvas.getWidth();
        int largo = canvas.getHeight();


        Paint pincelNegro = new Paint();
        pincelNegro.setARGB(255,0,0,0);
        pincelNegro.setStyle(Paint.Style.STROKE);
        pincelNegro.setStrokeWidth(6);

        Paint pincelAzul = new Paint();
        pincelAzul.setARGB(255,0,0,255);
        pincelAzul.setStyle(Paint.Style.STROKE);
        pincelAzul.setStrokeWidth(6);

        Paint pincelRojo = new Paint();
        pincelRojo.setARGB(255,255,0,0);
        pincelRojo.setStyle(Paint.Style.STROKE);
        pincelRojo.setStrokeWidth(6);

        canvas.drawCircle(ancho/2, largo/2, 200, pincelNegro);
        canvas.drawOval((ancho/2) - 300, (largo/2) + 225, (ancho/2) + 300, (largo/2) - 225, pincelAzul);
        canvas.drawRect((ancho/2) - 300, (largo/2) + 225, (ancho/2) + 300, (largo/2) - 225, pincelRojo);
    }
}
