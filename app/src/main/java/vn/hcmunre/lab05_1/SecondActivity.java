package vn.hcmunre.lab05_1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "SecondActivity onCreate started");

        try {
            setContentView(R.layout.activity_second);
            Log.d(TAG, "Layout set successfully");

            // Show toast to confirm activity is loaded
            Toast.makeText(this, "SecondActivity loaded", Toast.LENGTH_SHORT).show();

            // Xử lý nút BACK
            findViewById(R.id.btn_back).setOnClickListener(v -> {
                Log.d(TAG, "Back button clicked");
                finish();
                // Transition khi quay lại: MainActivity trượt từ trái vào, SecondActivity trượt sang phải
                overridePendingTransition(R.anim.activity_in_left, R.anim.activity_out_right);
            });

        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate: " + e.getMessage());
            Toast.makeText(this, "Error loading activity: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "System back pressed");
        super.onBackPressed();
        // Cùng transition khi bấm nút back của hệ thống
        overridePendingTransition(R.anim.activity_in_left, R.anim.activity_out_right);
    }
}
