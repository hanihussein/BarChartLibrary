package ae.etisalat.billingcomponent;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VerticalProgressBar progressBar = findViewById(R.id.progressBar);

        ShapeDrawable shape =
                new ShapeDrawable(new RoundRectShape(new float[]{0, 0, 20, 20, 20, 20, 0, 0}, null, null));

        shape.getPaint().setStyle(Paint.Style.FILL);
        shape.getPaint().setColor(getResources().getColor(R.color.green_bright));

        ShapeDrawable progressDrawable =
                new ShapeDrawable(new RoundRectShape(new float[]{0, 0, 20, 20, 20, 20, 0, 0}, null, null));

        progressDrawable.getPaint().setColor(getResources().getColor(R.color.green_dark));
        progressDrawable.getPaint().setStyle(Paint.Style.FILL);
        ClipDrawable progress = new ClipDrawable(progressDrawable, Gravity.START, ClipDrawable.HORIZONTAL);

        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{
                shape, progress});

        progressBar.setProgressDrawable(layerDrawable);

        progressBar.setEnabled(false);

        progressBar.setProgress(60);
        progressBar.setMax(100);


        findViewById(R.id.pro_component_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadii(new float[] { 15, 15, 15, 15, 15, 15, 15, 15 });
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                gradientDrawable.setColor(Color.WHITE);
                gradientDrawable.setStroke(3, Color.LTGRAY);

                findViewById(R.id.pro_component_view).setBackgroundDrawable(gradientDrawable);

            }
        });


//        progressBar.getBackground().setColorFilter(
//                getResources().getColor(R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);

    }
}
