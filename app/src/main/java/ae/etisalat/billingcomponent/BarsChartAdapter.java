package ae.etisalat.billingcomponent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BarsChartAdapter extends RecyclerView.Adapter<BarsChartAdapter.BillViewHolder> {

    private ArrayList<BarChartEntry> billBarChartEntries;
    private int maxValue;
    private BillingModeType billingModeType ;

    public BarsChartAdapter(ArrayList<BarChartEntry> billBarChartEntries, int maxValue) {
        this.billBarChartEntries = billBarChartEntries;
        this.maxValue = maxValue;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        BarView barView = new BarView(viewGroup.getContext());

        int width  = viewGroup.getWidth() / 6 ;
        int height = (viewGroup.getHeight() * billBarChartEntries.get(i).getMaxValue()) / 100;

        barView.setLayoutParams(new RecyclerView.LayoutParams(width, RecyclerView.LayoutParams.MATCH_PARENT));

        return new BillViewHolder(barView);
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder viewHolder, int i) {

        viewHolder.onBind(billBarChartEntries.get(i));
    }

    public void setBillingModeType(BillingModeType billingModeType) {
        this.billingModeType = billingModeType;
    }

    @Override
    public int getItemCount() {
        return billBarChartEntries.size();
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {

        private BillViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void onBind(BarChartEntry BarChartEntry) {
            ((BarView) itemView).drawBar(BarChartEntry, maxValue);
        }
    }
}
