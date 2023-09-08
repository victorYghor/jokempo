package com.example.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView result;
    ImageView appChoiceImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.tvResult);
        appChoiceImage = findViewById(R.id.imageView);
    }
    public void selecionadoPedra(View view) {
        Log.i("selecionado", "pedra");
        ComputeResult("pedra");
    }

    public void selecionadoPapel(View view) {
        Log.i("selecionado", "papel");
        ComputeResult("papel");
    }

    public void selecionadoTesoura(View view) {
        Log.i("selecionado", "tesoura");
        ComputeResult("tesoura");
    }

    public void ComputeResult(String optionSelect) {
        List<String> choices = Arrays.asList("pedra", "papel", "tesoura");
        int randomIndex = new Random().nextInt(3);
        String appChoice = choices.get(randomIndex);

        switch(appChoice) {
            case "pedra":
                appChoiceImage.setImageResource(R.drawable.pedra);
                break;
            case "tesoura":
                appChoiceImage.setImageResource(R.drawable.tesoura);
                break;
            case "papel":
                appChoiceImage.setImageDrawable(getResources().getDrawable(R.drawable.papel));
                break;
        }
        switch (optionSelect) {
            case "papel":
                if (appChoice == "papel") {
                    result.setText("empate");
                } else if (appChoice == "tesoura") {
                    result.setText("Você perdeu");
                } else {
                    result.setText("Vocẽ venceu");
                }
                break;
            case "pedra":
                if (appChoice == "papel") {
                    result.setText("Você perdeu");
                } else if (appChoice == "tesoura") {
                    result.setText("Você venceu");
                } else {
                    result.setText("empate");
                }
                break;
            case "tesoura":
                if(appChoice == "papel") {
                    result.setText("Você venceu");
                } else if(appChoice == "tesoura") {
                    result.setText("empate");
                } else {
                    result.setText("Você perdeu");
                }
                break;
        }

    }
}