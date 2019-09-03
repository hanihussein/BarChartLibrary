package com.hani.barchartlib.library.views;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import com.hani.barchartlib.R;
import com.hani.barchartlib.library.adapters.BarsChartAdapter;
import com.hani.barchartlib.library.models.BillingModeType;
import com.hani.barchartlib.library.util.MathUtil;
import com.hani.barchartlib.library.models.BarChartEntry;

public class BarGraphComponentView extends ConstraintLayout {

    public interface onBarClickListener {

        void onBarClick(BarChartEntry barChartEntry);
    }

    private RecyclerView rc_bills;

    private GraphBackgroundImageView graphBackgroundImageView;

    private onBarClickListener onBarClickListener;

    private BillingModeType billingModeType;

    private ArrayList<BarChartEntry> barChartEntries;

    private int backgroundHorizontalLinesColor = 0xFF888888;
    private int backgroundHorizontalLinesWidth = 1;
    private int backgroundValuesTextSize = 10;

    public BarGraphComponentView(Context context) {
        super(context);

        initView(context);
    }

    public BarGraphComponentView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context);

    }

    public BarGraphComponentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.billing_component_view, this, true);

        graphBackgroundImageView = rootView.findViewById(R.id.img_chart_background);

        rc_bills = rootView.findViewById(R.id.rc_bills);
        rc_bills.setHasFixedSize(true);
        rc_bills.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    public void setBackgroundHorizontalLinesColor(int backgroundHorizontalLinesColor) {
        this.backgroundHorizontalLinesColor = backgroundHorizontalLinesColor;
    }

    public void setBackgroundHorizontalLinesWidth(int backgroundHorizontalLinesWidth) {
        this.backgroundHorizontalLinesWidth = backgroundHorizontalLinesWidth;
    }

    public void setBackgroundValuesTextSize(int backgroundValuesTextSize) {
        this.backgroundValuesTextSize = backgroundValuesTextSize;
    }

    public void drawChart(final ArrayList<BarChartEntry> barChartEntries) {

        this.barChartEntries = barChartEntries;

        int maxBarValue = 0;

        for (BarChartEntry barChartEntry : barChartEntries) {

            if (barChartEntry.getMaxValue() > maxBarValue)
                maxBarValue = barChartEntry.getMaxValue();
        }

        int roundedMaxValue = MathUtil.round(maxBarValue + (maxBarValue * 10 / 100));

        graphBackgroundImageView.setBackgroundDrawInfo(roundedMaxValue, backgroundHorizontalLinesColor,
                backgroundHorizontalLinesWidth, backgroundValuesTextSize);
        graphBackgroundImageView.invalidate();

        rc_bills.setAdapter(new BarsChartAdapter(barChartEntries, roundedMaxValue));
    }

    public void setBillingModeType(BillingModeType billingModeType) {
        this.billingModeType = billingModeType;

        if (rc_bills.getAdapter() != null) {

            for (BarChartEntry barChartEntry : barChartEntries) {

                barChartEntry.setBillingModeType(billingModeType);
            }

            rc_bills.getAdapter().notifyDataSetChanged();
        }

    }
}
