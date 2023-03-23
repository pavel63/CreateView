package com.example.android_razrab.createcustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by android_razrab on 02/10/2017.
 */


class MyView extends View {

    boolean mShowText,isBigFont;
    int mTextPos,textColor;

    String text;


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MyChart,
                0, 0);

        try {
            text=a.getString(R.styleable.MyChart_text);

            isBigFont=a.getBoolean(R.styleable.MyChart_bigFont,false);

            textColor=a.getColor(R.styleable.MyChart_colorRgb,0);

          mShowText = a.getBoolean(R.styleable.MyChart_showText, false);
           mTextPos = a.getInteger(R.styleable.MyChart_labelPosition, 0);
        } finally {
            a.recycle();
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();

        if(textColor==0){

            paint.setColor(Color.RED);
        }else  if(textColor==1) {
           paint.setColor(Color.GREEN);

        }else {

            paint.setColor(Color.BLUE);
        }

        if(isBigFont) {
            paint.setTextSize(100);
        }else {
            paint.setTextSize(30);
        }

        if((mShowText)&&(text!=null)) {
            canvas.drawText(text, 150, 150, paint);
        }

        canvas.drawCircle(25F,68F,5,paint);

    }

}
