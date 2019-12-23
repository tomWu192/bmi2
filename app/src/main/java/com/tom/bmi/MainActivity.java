package com.tom.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tom.bmi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnHelp.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.help)
                        .setMessage(R.string.BMI_Desc)
                        .setPositiveButton(R.string.ok,null)
                        .show();
            }
        });
    }
    public void bmi(View v){
        String w=binding.edWeight.getText().toString();
        String h=binding.edHeight.getText().toString();
        float weight=Float.parseFloat(w);
        float height=Float.parseFloat(h);
        float bmi=weight/(height*height);
//        Toast.makeText(this,"Your bmi is "+bmi,Toast.LENGTH_SHORT).show();
//        binding.txvResult.setText("Your bmi is "+bmi);
        new AlertDialog.Builder(this)
                .setTitle(R.string.BMI_Title)
                .setMessage(getString(R.string.Bmi_Ques)+bmi)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        binding.edWeight.setText("");
                        binding.edHeight.setText("");
                    }
                })
                .show();
    }
}
