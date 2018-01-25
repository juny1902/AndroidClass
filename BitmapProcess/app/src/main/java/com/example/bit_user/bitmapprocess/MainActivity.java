package com.example.bit_user.bitmapprocess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibBlur, ibEmbos;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;
    static boolean blur = false;
    static boolean embos = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons() {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                satur = satur + 0.2f;
                graphicView.invalidate();
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (satur - 0.2f > 0) {
                    satur = satur - 0.2f;
                } else {
                    satur = 0;
                }
                graphicView.invalidate();
            }
        });
        ibBlur = (ImageButton) findViewById(R.id.ibBlur);
        ibBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (blur == false) {
                    blur = true;
                } else {
                    blur = false;
                }
                graphicView.invalidate();
            }
        });
        ibEmbos = (ImageButton) findViewById(R.id.ibEmbos);
        ibEmbos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (embos == false) {
                    embos = true;
                } else {
                    embos = false;
                }
                graphicView.invalidate();
            }
        });

    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = {color, 0, 0, 0, 0, 0, color, 0, 0, 0, 0, 0,
                    color, 0, 0, 0, 0, 0, 1, 0};

            ColorMatrix cm = new ColorMatrix(array);

            cm.setSaturation(satur);


            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            BlurMaskFilter bMask;
            EmbossMaskFilter eMask;
            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
            eMask = new EmbossMaskFilter(new float[] {3,3,3},0.5f,5,10);
            if(blur) {
                paint.setMaskFilter(null);
                embos = false;
                paint.setMaskFilter(bMask);
            }
            if(embos) {
                paint.setMaskFilter(null);
                blur = false;
                paint.setMaskFilter(eMask);
            }
            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }
}

