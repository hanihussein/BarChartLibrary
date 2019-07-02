package ae.etisalat.billingcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BarGraphComponentView barGraphComponentView = findViewById(R.id.bc_bills);

        ArrayList<BarChartEntry> billBarChartEntries = new ArrayList<>();

        billBarChartEntries.add(new BarChartEntry("Jan", 1000, 700, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.PAYMENT_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Feb", 800, 300, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.PAYMENT_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Mar", 900, 650, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.PAYMENT_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Apri", 500, 500, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.PAYMENT_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("May", 200, 160, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.PAYMENT_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Jun", 775, 700, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.PAYMENT_MODE_ACTIVE));

        barGraphComponentView.drawChart(billBarChartEntries);

//        progressBar.getBackground().setColorFilter(
//                getResources().getColor(R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);

    }
}
