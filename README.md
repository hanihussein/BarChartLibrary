# BarChartLibrary
Android Libaray to create customized Bar Charts with easy way without any difficults with just few lines 



![device-2019-09-08-230652](https://user-images.githubusercontent.com/8023216/64493188-fee2aa00-d28d-11e9-9d4b-71f93fad44dc.png)


## Setup 

Step 1. Add the JitPack repository to your build file

- Add it in your root build.gradle at the end of repositories:-

        allprojects {
  	      repositories {
  		   ...
  		   maven { url 'https://jitpack.io' }
  	      }
        }        
        
Step 2. Add the dependency:-

       dependencies {
       
	       implementation 'com.github.hanihussein:BarChartLibrary:1.0.1'
               
          }


## How to use it ! 

Step 1. In your xml layout file as following :- 

    <com.hani.barchartlib.library.views.BarGraphComponentView
        android:id="@+id/bc_bills"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />



Step 2. Init your component instance:- 

        final BarGraphComponentView barGraphComponentView = findViewById(R.id.bc_bills);

        barGraphComponentView.setBackgroundHorizontalLinesColor(getResources().getColor(R.color.light_gray));
        barGraphComponentView.setBackgroundHorizontalLinesWidth(2);
        barGraphComponentView.setBackgroundValuesTextSize(30);
        
        
Step 3. Fill  BarChartEntry  with your data   :- 


        ArrayList<BarChartEntry> billBarChartEntries = new ArrayList<>();

        billBarChartEntries.add(new BarChartEntry("Jan", 1000, 700, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Feb", 800, 300, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Mar", 1400, 1200, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_ACTIVE));

        billBarChartEntries.add(new BarChartEntry("Apri", 500, 500, getResources().getColor(R.color.green_bright)
                , getResources().getColor(R.color.green_dark), BillingModeType.BAR_MAX_MODE_INACTIVE));


Step 4.  Add Bar Item click Listener and if you want to enable highlighting mode , just make it true    :- 

        barGraphComponentView.setOnBarItemClickListener(this);

        barGraphComponentView.setHighlightClickBar(true);

![device-2019-09-08-230710](https://user-images.githubusercontent.com/8023216/64493198-220d5980-d28e-11e9-93c3-83567001716d.png)

![device-2019-09-08-230727](https://user-images.githubusercontent.com/8023216/64493203-39e4dd80-d28e-11e9-9ff6-1bfc3ce18c69.png)


Step 5.  Just call DrawChart to start drawing charts bars:- 

        barGraphComponentView.drawChart(billBarChartEntries);


