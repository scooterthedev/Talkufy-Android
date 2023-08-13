package ca.scooter.talkufy.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import ca.scooter.talkufy.R;
import com.htetznaing.app_updater.AppUpdater;

public class Updates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);

        String check_update_json = "https://talkufy-updater.web.app/";
        AppUpdater appUpdater = new AppUpdater(this, check_update_json);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        appUpdater.check();
    }
}