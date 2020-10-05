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
    private String editHold;
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
        gameStateHearts secondInstance= new gameStateHearts(firstInstance);

        firstInstance.selectCard();
        editText.append("Player selected card.");

        firstInstance.collectTrick();
        editHold= editText.getText().toString();
        editText.setText(editHold + "Player collected cards.\n", TextView.BufferType.NORMAL);

        firstInstance.passCard();
        editHold= editText.getText().toString();
        editText.setText(editHold + "Player passed cards.\n", TextView.BufferType.NORMAL);

        firstInstance.playCard();
        editHold= editText.getText().toString();
        editText.setText(editHold + "Player played card.\n", TextView.BufferType.NORMAL);

        firstInstance.quit();
        editHold= editText.getText().toString();
        editText.setText(editHold + "Player quit game.\n", TextView.BufferType.NORMAL);


        gameStateHearts thirdInstance= new gameStateHearts();
        gameStateHearts fourthInstance= new gameStateHearts(thirdInstance);

        

    }

}