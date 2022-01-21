package com.example.miniproyecto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;

public class LienzoImagen extends View {

    public LienzoImagen(Context context) {
        super(context);
    }


    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(0, 0, 255);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.descarga);

        Matrix matrix = new Matrix();
        matrix.setRotate(30);
        matrix.postTranslate(500/2,350/2);

        canvas.drawBitmap(bmp,matrix, null);

    }
}
