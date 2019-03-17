package com.gradle.auto.autogradledemo;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gradle.auto.autogradledemo.global.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG","base_url:"+ Constants.base_url);
    }

    ApplicationInfo info= null;
    @Override
    protected void onResume() {
        super.onResume();
        try {
            info = this.getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);
            if(info!=null&&info.metaData!=null) {
                String msg = (String) (info.metaData.getString("myValue"));
                Toast.makeText(getApplicationContext(), msg+"", Toast.LENGTH_LONG).show();
            }else {
                Log.e("TAG","info:"+info);
                Log.e("TAG","metaData:"+info.metaData);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
