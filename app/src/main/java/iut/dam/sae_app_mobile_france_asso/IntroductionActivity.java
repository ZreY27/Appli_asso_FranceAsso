package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import iut.dam.sae_app_mobile_france_asso.adapter.IntroAdapter;

public class IntroductionActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout dotsLayout;
    private TextView btnSkip;
    private Button btnStart;
    private IntroAdapter introAdapter;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);
        btnSkip = findViewById(R.id.btnSkip);
        btnStart = findViewById(R.id.btnCommencer);

        introAdapter = new IntroAdapter(this);
        viewPager.setAdapter(introAdapter);

        setupDots(introAdapter.getItemCount());
        selectDot(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectDot(position);

                if (position == introAdapter.getItemCount() - 1) {
                    btnStart.setVisibility(View.VISIBLE);
                    btnSkip.setVisibility(View.GONE);
                } else {
                    btnStart.setVisibility(View.GONE);
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSkip.setOnClickListener(v -> {
            SharedPrefManager.setIntroSeen(IntroductionActivity.this);
            startMain();
        });

        btnStart.setOnClickListener(v -> {
            SharedPrefManager.setIntroSeen(IntroductionActivity.this);
            startMain();
        });
    }

    private void startMain() {
        Log.d("IntroductionActivity", "Bouton Passer cliqué");
        Intent intent = new Intent(IntroductionActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setupDots(int count) {
        dots = new ImageView[count];
        dotsLayout.removeAllViews();

        for (int i = 0; i < count; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.dot_inactive);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 0, 8, 0);
            dotsLayout.addView(dots[i], params);
        }
    }

    private void selectDot(int index) {
        for (int i = 0; i < dots.length; i++) {
            dots[i].setImageResource(i == index ? R.drawable.dot_active : R.drawable.dot_inactive);
        }
    }
}