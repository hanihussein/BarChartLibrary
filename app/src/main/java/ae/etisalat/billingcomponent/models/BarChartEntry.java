package ae.etisalat.billingcomponent.models;

import ae.etisalat.billingcomponent.BillingModeType;

public class BarChartEntry {
    private String title;
    private int maxValue;
    private int progressValue;
    private int maxValueColor;
    private int progressValueColor;
    private BillingModeType billingModeType;

    public BarChartEntry(String title, int maxValue, int progressValue, int maxValueColor, int progressValueColor, BillingModeType billingModeType) {
        this.title = title;
        this.maxValue = maxValue;
        this.progressValue = progressValue;
        this.maxValueColor = maxValueColor;
        this.progressValueColor = progressValueColor;
        this.billingModeType = billingModeType;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getProgressValue() {
        return progressValue;
    }

    public int getMaxValueColor() {
        return maxValueColor;
    }

    public int getProgressValueColor() {
        return progressValueColor;
    }
    public BillingModeType getBillingModeType() {
        return billingModeType;
    }


    public void setBillingModeType(BillingModeType billingModeType) {
        this.billingModeType = billingModeType;
    }

    public String getTitle() {
        return title;
    }
}
