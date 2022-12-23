package com.example.thingstodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thingstodo.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
 ActivityDataInsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_insert);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String type = getIntent().getStringExtra("type");
        if (type.equals("update")) {
           // setTitle("update");
            EditText tv = findViewById(R.id.editTextTextPersonName);
            tv.setText(getIntent().getStringExtra("title"));
            EditText Tv = findViewById(R.id.editTextTextPersonName2);
            Tv.setText(getIntent().getStringExtra("text"));
            int id = getIntent().getIntExtra("id",0);
            binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText tv = findViewById(R.id.editTextTextPersonName);
                    EditText Tv = findViewById(R.id.editTextTextPersonName2);
                    String title = tv.getText().toString();
                    //String text = binding.editTextTextPersonName2.toString();
                    String text = Tv.getText().toString();
                    Intent intent = new Intent();
                    intent.putExtra("title", title);
                    intent.putExtra("text", text);
                    intent.putExtra("id",id);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });


        } else {
            setTitle("ADD Mode");
            binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText tv = findViewById(R.id.editTextTextPersonName);
                    EditText Tv = findViewById(R.id.editTextTextPersonName2);
                    String title = tv.getText().toString();
                    //String text = binding.editTextTextPersonName2.toString();
                    String text = Tv.getText().toString();
                    Intent intent = new Intent();
                    intent.putExtra("title", title);
                    intent.putExtra("text", text);
                    setResult(RESULT_OK, intent);
                    finish();

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this,MainActivity.class));
    }
}