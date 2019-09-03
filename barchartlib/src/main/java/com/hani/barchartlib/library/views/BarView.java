package com.hani.barchartlib.library.views;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.hani.barchartlib.R;
import com.hani.barchartlib.library.models.BillingModeType;
import com.hani.barchartlib.library.models.BarChartEntry;

public class BarView extends ConstraintLayout {

    public interface onBarClickListener {

        void onBarClick(BarChartEntry barChartEntry);
    }

    private VerticalProgressBar progressBar;

    private AppCompatTextView title;

    private onBarClickListener onBarClickListener;


    public BarView(Context context) {
        super(context);

        initView(context);
    }

    public BarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context);

    }

    public BarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.item_progressbar, this, true);

        progressBar = rootView.findViewById(R.id.progressBar);

        title = rootView.findViewById(R.id.title);

    }

    public void drawBar(final BarChartEntry barChartEntry, int biggestBarsValue) {

        LayoutParams layoutParams = (LayoutParams) progressBar.getLayoutParams();

        layoutParams.height = (layoutParams.height * barChartEntry.getMaxValue()) / biggestBarsValue;

        progressBar.setLayoutParams(layoutParams);

        title.setText(barChartEntry.getTitle());

        ShapeDrawable backgroundDrawable =
                new ShapeDrawable(new RoundRectShape(new float[]{20, 20, 20, 20, 20, 20, 0, 0}, null, null));

        backgroundDrawable.getPaint().setStyle(Paint.Style.FILL);
        backgroundDrawable.getPaint().setColor(barChartEntry.getMaxValueColor());


        ShapeDrawable progressDrawable =
                new ShapeDrawable(new RoundRectShape(new float[]{0, 0, 20, 20, 20, 20, 0, 0}, null, null));

        progressDrawable.getPaint().setColor(barChartEntry.getProgressValueColor());
        progressDrawable.getPaint().setStyle(Paint.Style.FILL);
        ClipDrawable progress = new ClipDrawable(progressDrawable, Gravity.START, ClipDrawable.HORIZONTAL);

        LayerDrawable layerDrawable = null;

        if (barChartEntry.getBillingModeType() == BillingModeType.BAR_MAX_MODE_ACTIVE) {

            progressBar.setBackgroundDrawable(backgroundDrawable);

            layerDrawable = new LayerDrawable(new Drawable[]{
                    progress});

        } else if (barChartEntry.getBillingModeType() == BillingModeType.BAR_MAX_MODE_INACTIVE) {

            layerDrawable = new LayerDrawable(new Drawable[]{
                    progress});
        }

        progressBar.setProgressDrawable(layerDrawable);
        progressBar.setEnabled(false);
        progressBar.setMax(barChartEntry.getMaxValue());
        progressBar.setProgress(barChartEntry.getProgressValue());

        findViewById(R.id.pro_component_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onBarClickListener != null)
                    onBarClickListener.onBarClick(barChartEntry);

                findViewById(R.id.pro_component_view).setBackgroundResource(R.drawable.ic_highlight);

            }
        });


    }

}
