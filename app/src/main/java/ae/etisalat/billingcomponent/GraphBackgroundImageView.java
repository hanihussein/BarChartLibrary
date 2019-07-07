package ae.etisalat.billingcomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class GraphBackgroundImageView extends android.support.v7.widget.AppCompatImageView {

    private Paint mBitmapPaint;
    private int maxValue;
    private boolean isDrawingInfoInserted = false;

    public GraphBackgroundImageView(Context context) {
        super(context);

        initView();
    }

    public GraphBackgroundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    public GraphBackgroundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }


    private void initView() {

        mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmapPaint.setColor(Color.GRAY);
        mBitmapPaint.setStrokeWidth(5); // set stroke so you can actually see the lines

    }


    public void setBackgroundDrawInfo(int maxValue, int lineColor, int lineWidth, int textSize) {

        this.maxValue = maxValue;

        mBitmapPaint.setColor(lineColor);
        mBitmapPaint.setStrokeWidth(lineWidth);
        mBitmapPaint.setTextSize(textSize);

        isDrawingInfoInserted = true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.e("onDraw", "Done");

        if (isDrawingInfoInserted) {

//            int roundedMaxValue = ;

            int roundedLineTextValueValue = MathUtil.round(maxValue / 4);/*(( + 99) / 100) * 100;*/

            int height = ((View) getParent()).getHeight() -

                    ((ConstraintLayout.LayoutParams) getLayoutParams()).bottomMargin;

            int linesSpacesValue = height / 5;

            for (int i = 0; i < 5; i++) {

                if (i == 0) {

                    canvas.drawLine(0, 0, getMeasuredWidth(), height, mBitmapPaint);
                }

                canvas.drawLine(0, 0, getMeasuredWidth(), height - linesSpacesValue, mBitmapPaint);

                int textY = height - (int) convertDpToPixel(2, getContext());

                if (i != 4) {

                    canvas.drawText(roundedLineTextValueValue + "", 0, textY, mBitmapPaint);

                    roundedLineTextValueValue += roundedLineTextValueValue;

                }

                height -= linesSpacesValue;

            }
        }

    }


    public static float convertDpToPixel(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
