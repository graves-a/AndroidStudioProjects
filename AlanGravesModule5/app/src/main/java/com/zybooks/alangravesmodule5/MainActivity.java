package com.zybooks.alangravesmodule5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mName;
    private TextView mDisplayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.nameText);
        mDisplayName = findViewById(R.id.textGreeting);

    }

    public void SayHello(View view) {
        String name = mName.getText().toString();
        if (name.length() > 0) {
            mDisplayName.setText("Hello " + name + "!");
        } else {
            toast();
        }
    }

    public void toast() {
        Toast t = Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 0, 0);
        t.show();
    }
}

