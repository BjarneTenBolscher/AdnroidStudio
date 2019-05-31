package com.example.project.onDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.project.Model.PVFname;

import java.util.ArrayList;

public class CountingView extends View {
    int amount;
    Paint paint;
    String pvfName;
    ArrayList<PVFname> sizePVF;

    public CountingView(Context context) {
        super(context);
        init();
    }

    public CountingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CountingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void counting(ArrayList<PVFname> number, String pvfName) {
        sizePVF = number;
        this.pvfName = pvfName;
    }

    public void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = canvas.getHeight();
        int width = canvas.getWidth();
        amount = 0;
        for (int i = 0; i < sizePVF.size(); i++) {
            if (sizePVF.get(i).getName().equals(pvfName)) {
                if (sizePVF.get(i).getBrands() != null) {
                    amount = sizePVF.get(i).getBrands().size();
                }else {
                    amount = 0;
                }
            }
        }
        /* In this loop it loops through the size of sizePVF. if the name from sizePVF corresponds
        with the pvfName then set the amount ot the size of the brands from the sizePVF list*/
        canvas.drawText("" + amount, height / 5, width / 5, paint);
    }
}
