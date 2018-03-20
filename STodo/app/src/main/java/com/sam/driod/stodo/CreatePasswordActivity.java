package com.sam.driod.stodo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText pwdFirst, pwdSecond;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
        pwdFirst = findViewById(R.id.passwordFirst);
        pwdSecond = findViewById(R.id.passwordSecond);
        confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = pwdFirst.getText().toString();
                String text2 = pwdSecond.getText().toString();

                //if no password Entered
                if (text1.equals("") || text2.equals("")) {
                    Toast.makeText(CreatePasswordActivity.this, "No Password entered", Toast.LENGTH_SHORT).show();
                } else {
                    //Found a matching text, Save as Password
                    if (text1.equals(text2)) {
                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", text1);
                        editor.apply();

                        //After saving the password, Enter into the App
                        Intent intent = new Intent(getApplicationContext(), CreateTaskActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        //text1 does not MATCH with Text2
                        Toast.makeText(CreatePasswordActivity.this, "Password Doesn't Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
