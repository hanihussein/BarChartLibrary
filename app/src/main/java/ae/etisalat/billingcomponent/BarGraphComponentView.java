package ae.etisalat.billingcomponent;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class BarGraphComponentView extends ConstraintLayout {

    public interface onBarClickListener {

        void onBarClick(BarChartEntry barChartEntry);
    }

    private RecyclerView rc_bills;

    private onBarClickListener onBarClickListener;

    private BillingModeType billingModeType;

    private ArrayList<BarChartEntry> barChartEntries;

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

        rc_bills = rootView.findViewById(R.id.rc_bills);
        rc_bills.setHasFixedSize(true);
        rc_bills.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    public void drawChart(final ArrayList<BarChartEntry> barChartEntries) {

        this.barChartEntries = barChartEntries;

        int maxBarValue = 0;

        for (BarChartEntry barChartEntry : barChartEntries) {

            if (barChartEntry.getMaxValue() > maxBarValue)
                maxBarValue = barChartEntry.getMaxValue();
        }
        rc_bills.setAdapter(new BarsChartAdapter(barChartEntries, maxBarValue));
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
