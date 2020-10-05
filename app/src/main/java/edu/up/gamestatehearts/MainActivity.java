package edu.up.gamestatehearts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.Normalizer;

import static edu.up.gamestatehearts.R.id.runTestButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button testButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testButton = (Button) findViewById(R.id.runTestButton);
        testButton.setOnClickListener(this);
        editText = findViewById(R.id.editTextMulti);
    }

    @Override
    public void onClick(View v){
        editText.setText("", TextView.BufferType.NORMAL);
        gameStateHearts firstInstance= new gameStateHearts();


    }

}