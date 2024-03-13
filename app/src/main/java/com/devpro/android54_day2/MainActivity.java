package com.devpro.android54_day2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.devpro.android54_day2.login.LoginFragment;
import com.devpro.android54_day2.object.User;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnHello;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        btnHello = findViewById(R.id.btnHello);

        User user = new User();
        user.setUserName("HaiPT");
        user.setAddress("HN");


        btnHello.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BActivity.class);

            Bundle bundle = new Bundle();
            bundle.putInt("COUNT", count);
            bundle.putSerializable("USER", user);

//            intent.putExtra("COUNT",count);

            intent.putExtras(bundle);
//            startActivity(intent);
//            startActivityForResult(intent, REQUEST_B);
            bLauncher.launch(intent);
        });

//        LoginFragment loginFragment = new LoginFragment();
        LoginFragment loginFragment = LoginFragment.newInstance(123);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container,loginFragment,"LOGIN_FRG")
                .addToBackStack("MAIN_STACK")
                .commit();
//
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
        }
        super.onBackPressed();
    }

    ActivityResultLauncher<Intent> bLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                String data = intent.getStringExtra("INPUT");
                Toast.makeText(MainActivity.this, "Data = "+data, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "User cancel!", Toast.LENGTH_SHORT).show();
            }
        }
    });

    ActivityResultLauncher<Intent> cLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {

        }
    });

    public static final int REQUEST_B = 1;
    public static final int REQUEST_C = 2;
    public static final int REQUEST_D = 3;

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case REQUEST_B:
//                break;
//            case REQUEST_C:
//                break;
//            case REQUEST_D:
//                break;
//            default:
//
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}