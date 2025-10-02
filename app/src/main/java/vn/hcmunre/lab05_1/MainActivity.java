package vn.hcmunre.lab05_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.AnimRes;
import androidx.appcompat.app.AppCompatActivity;

import vn.hcmunre.lab05_1.pager.ScreenSlideActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml, btnRotateCode, btnMoveXml, btnMoveCode,
            btnSlideUpXml, btnSlideUpCode, btnBounceXml, btnBounceCode,
            btnCombineXml, btnCombineCode, btnOpenPager;

    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsByIds();
        initVariables();

        // --- XML buttons ---
        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);

        // --- CODE buttons ---
        handleClickAnimationCode(btnFadeInCode, createFadeInAnim());
        handleClickAnimationCode(btnFadeOutCode, createFadeOutAnim());
        handleClickAnimationCode(btnBlinkCode, createBlinkAnim());
        handleClickAnimationCode(btnZoomInCode, createZoomInAnim());
        handleClickAnimationCode(btnZoomOutCode, createZoomOutAnim());
        handleClickAnimationCode(btnRotateCode, createRotateAnim());
        handleClickAnimationCode(btnMoveCode, createMoveAnim());
        handleClickAnimationCode(btnSlideUpCode, createSlideUpAnim());
        handleClickAnimationCode(btnBounceCode, createBounceAnim());
        handleClickAnimationCode(btnCombineCode, createCombineAnim());

        // --- Bài 3: click logo => mở activity mới + transition ---
        ivUitLogo.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
            // New activity vào từ phải, MainActivity trượt sang trái:
            overridePendingTransition(R.anim.activity_in_right, R.anim.activity_out_left);
        });

        // Mở ViewPager2 demo (Bài 4)
        btnOpenPager.setOnClickListener(v -> {
            // Chuyển sang SecondActivity thay vì ScreenSlideActivity
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            // Thêm hiệu ứng chuyển trang nếu muốn:
            overridePendingTransition(R.anim.activity_in_right, R.anim.activity_out_left);
        });
    }

    private void findViewsByIds() {
        ivUitLogo = findViewById(R.id.iv_uit_logo);
        btnFadeInXml = findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = findViewById(R.id.btn_blink_xml);
        btnBlinkCode = findViewById(R.id.btn_blink_code);
        btnZoomInXml = findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = findViewById(R.id.btn_rotate_xml);
        btnRotateCode = findViewById(R.id.btn_rotate_code);
        btnMoveXml = findViewById(R.id.btn_move_xml);
        btnMoveCode = findViewById(R.id.btn_move_code);
        btnSlideUpXml = findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = findViewById(R.id.btn_slide_up_code);
        btnBounceXml = findViewById(R.id.btn_bounce_xml);
        btnBounceCode = findViewById(R.id.btn_bounce_code);
        btnCombineXml = findViewById(R.id.btn_combine_xml);
        btnCombineCode = findViewById(R.id.btn_combine_code);
        btnOpenPager = findViewById(R.id.btn_open_pager);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override public void onAnimationStart(Animation animation) { }
            @Override public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();
            }
            @Override public void onAnimationRepeat(Animation animation) { }
        };
    }

    // ---- XML ----
    private void handleClickAnimationXml(Button btn, @AnimRes int animId) {
        btn.setOnClickListener(v -> {
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), animId);
            anim.setAnimationListener(animationListener);
            ivUitLogo.startAnimation(anim);
        });
    }

    // ---- CODE ----
    private void handleClickAnimationCode(Button btn, final Animation animation) {
        btn.setOnClickListener(v -> {
            animation.setAnimationListener(animationListener);
            ivUitLogo.startAnimation(animation);
        });
    }

    // ---- Các animation bằng code (tái tạo giống XML) ----
    private Animation createFadeInAnim() {
        AlphaAnimation a = new AlphaAnimation(0f, 1f);
        a.setDuration(1000);
        a.setFillAfter(true);
        return a;
    }

    private Animation createFadeOutAnim() {
        AlphaAnimation a = new AlphaAnimation(1f, 0f);
        a.setDuration(1000);
        a.setFillAfter(true);
        return a;
    }

    private Animation createBlinkAnim() {
        AlphaAnimation a = new AlphaAnimation(0f, 1f);
        a.setDuration(300);
        a.setRepeatMode(Animation.REVERSE);
        a.setRepeatCount(3);
        return a;
    }

    private Animation createZoomInAnim() {
        ScaleAnimation s = new ScaleAnimation(
                1f, 3f, 1f, 3f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        s.setDuration(1000);
        s.setFillAfter(true);
        return s;
    }

    private Animation createZoomOutAnim() {
        ScaleAnimation s = new ScaleAnimation(
                1f, 0.5f, 1f, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        s.setDuration(1000);
        s.setFillAfter(true);
        return s;
    }

    private Animation createRotateAnim() {
        RotateAnimation r = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        r.setDuration(600);
        r.setRepeatMode(Animation.RESTART);
        r.setRepeatCount(2);
        r.setInterpolator(new CycleInterpolator(1f));
        return r;
    }

    private Animation createMoveAnim() {
        TranslateAnimation t = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.75f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f
        );
        t.setDuration(800);
        t.setFillAfter(true);
        t.setInterpolator(new LinearInterpolator());
        return t;
    }

    private Animation createSlideUpAnim() {
        ScaleAnimation s = new ScaleAnimation(
                1f, 1f, 1f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        s.setDuration(500);
        s.setFillAfter(true);
        return s;
    }

    private Animation createBounceAnim() {
        ScaleAnimation s = new ScaleAnimation(
                1f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
        );
        s.setDuration(500);
        s.setFillAfter(true);
        s.setInterpolator(new BounceInterpolator());
        return s;
    }

    private Animation createCombineAnim() {
        AnimationSet set = new AnimationSet(true);
        set.setFillAfter(true);
        set.setInterpolator(new LinearInterpolator());

        ScaleAnimation s = new ScaleAnimation(
                1f, 3f, 1f, 3f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        s.setDuration(4000);

        RotateAnimation r = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        r.setDuration(500);
        r.setRepeatCount(2);
        r.setRepeatMode(Animation.RESTART);

        set.addAnimation(s);
        set.addAnimation(r);
        return set;
    }
}
