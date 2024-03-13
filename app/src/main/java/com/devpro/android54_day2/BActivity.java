package com.devpro.android54_day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.devpro.android54_day2.object.User;

public class BActivity extends AppCompatActivity {
    private static final String TAG = "BActivity";
    private EditText edtInput;
    private Button btnBackToMain;

    public BActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);

        Intent intent = getIntent();
//        int count = intent.getIntExtra("COUNT",-1);
//        Log.d(TAG, "onCreate: "+count);
//        User user = (User) intent.getSerializableExtra("USER");
//        Log.d(TAG, "onCreate: "+user.toString());


        Bundle bundle = intent.getExtras();
        User user = (User) bundle.getSerializable("USER");


        edtInput = findViewById(R.id.edtInput);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edtInput.getText().toString();
                Intent intent2 = new Intent();
                intent2.putExtra("INPUT",data);
                setResult(RESULT_OK,intent2);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}