package ae.etisalat.billingcomponent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.hani.barchartlib.library.models.BarChartEntry;
import com.hani.barchartlib.library.models.BillingModeType;
import com.hani.barchartlib.library.views.BarGraphComponentView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BarGraphComponentView barGraphComponentView = findViewById(R.id.bc_bills);

        barGraphComponentView.setBackgroundHorizontalLinesColor(getResources().getColor(R.color.light_gray));
        barGraphComponentView.setBackgroundHorizontalLinesWidth(2);
        barGraphComponentView.setBackgroundValuesTextSize(30);

        ArrayList<BarChartEntry> billBarChartEntries = new ArrayList<>();

        billBarChartEntries.add(new BarChartEntry("Jan", 1000, 700, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Feb", 800, 300, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Mar", 1400, 1200, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Apri", 500, 500, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_INACTIVE));

        billBarChartEntries.add(new BarChartEntry("May", 200, 160, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Jun", 775, 700, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        barGraphComponentView.drawChart(billBarChartEntries);

    }
}
