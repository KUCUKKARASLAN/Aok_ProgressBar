package com.aoktest.library;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class aok_Progress extends View {

    private Paint mPaint;
    private Paint mPaint2;
    private int mProgresingColor = Color.RED;
    private int mProgresBackColor = Color.WHITE;
    private int mProgresMax = 100;
    private int mProgresValue = 50;

    public aok_Progress(Context context) {
        this(context, null);
    }

    public aok_Progress(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public aok_Progress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public aok_Progress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    private void init(AttributeSet attrs)
    {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.aok_Progress);
        mProgresMax = array.getInteger(R.styleable.aok_Progress_aokProgresMax, mProgresMax);
        mProgresValue = array.getInteger(R.styleable.aok_Progress_aokProgresValue, mProgresValue);
        mProgresingColor = array.getColor(R.styleable.aok_Progress_aokProgresingColor, mProgresingColor);
        mProgresBackColor = array.getColor(R.styleable.aok_Progress_aokProgresBackColor, mProgresBackColor);
        array.recycle();

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        mPaint.setAntiAlias(true);
        mPaint.setColor(mProgresBackColor);

        mPaint2 = new Paint();
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        mPaint2.setAntiAlias(true);
        mPaint2.setColor(mProgresingColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawBackgroundValue(canvas);
    }
    private void drawBackground(Canvas canvas) {

        int w = canvas.getWidth();
        int h = canvas.getHeight();

        float radius = 10.0f;
        mPaint.setStrokeWidth(2);
        CornerPathEffect corEffect = new CornerPathEffect(radius);
        mPaint.setPathEffect(corEffect);
        Path path = new Path();
        path.moveTo(1, 1);
        path.lineTo(w-1, 1);
        path.lineTo(w-1, h-1);
        path.lineTo(1, h-1);
        path.close();
        canvas.drawPath(path, mPaint);
    }
    private void drawBackgroundValue(Canvas canvas) {

        int w = canvas.getWidth();
        int h = canvas.getHeight();

        mProgresMax = mProgresMax < 0? 0:mProgresMax;
        mProgresValue = mProgresValue < 0? 0:mProgresValue;
        mProgresValue = mProgresValue > mProgresMax? mProgresMax:mProgresValue;

        double oran =  ((mProgresValue * 100) / mProgresMax);

        int gotoMin = 5;
        int goToMax = w-5;


        int drawIcerik = goToMax-gotoMin;
        int goToValue = (int)((oran*drawIcerik)/100);

        goToValue = goToValue<=0?gotoMin:goToValue;

        float radius = 10.0f;
        mPaint2.setStrokeWidth(2);
        CornerPathEffect corEffect = new CornerPathEffect(radius);
        mPaint2.setPathEffect(corEffect);

        Path path = new Path();
        path.moveTo(5, 5);
        path.lineTo(goToValue, 5);
        path.lineTo(goToValue, h-5);
        path.lineTo(5, h-5);
        path.close();
        canvas.drawPath(path, mPaint2);
    }

    public void setmProgresMax(int mProgresMax) {
        this.mProgresMax = mProgresMax;
    }

    public void setmProgresValue(int mProgresValue) {
        this.mProgresValue = mProgresValue;
        postInvalidate();
    }

    public int getmProgresMax() {
        return mProgresMax;
    }
    public int getmProgresValue() {
        return mProgresValue;
    }
}
