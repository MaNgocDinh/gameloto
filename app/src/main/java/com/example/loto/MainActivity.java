package com.example.loto;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText medtsMin,medtsMax;
    Button mbtRange,mbtRandom,mbtReset;
    TextView mkq;
    int mRandomValue=0;
    Random mRandom;
    String mValue="";
    ArrayList<Integer> mArrayRange;
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medtsMin=findViewById(R.id.edittextSomin);
        medtsMax=findViewById(R.id.edittextSomax);
        mbtRange=findViewById(R.id.buttonRange);
        mbtRandom=findViewById(R.id.buttonRandom);
        mbtReset=findViewById(R.id.buttonReset);
        mkq=findViewById(R.id.textviewKetqua);
        mRandom=new Random();
        mArrayRange=new ArrayList<>();
        mbtRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msMin=medtsMin.getText().toString();
                String msMax=medtsMax.getText().toString();
                int miMin=Integer.parseInt(msMin);
                int miMax=Integer.parseInt(msMax);
                if(msMax.isEmpty()||msMin.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Nhap thieu gia tri.Vui long nhap them", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (miMin>miMax){
                    int doi=0;
                    doi=miMin;
                    miMin=miMax;
                    miMax=doi;
                }
                if (miMin==miMax)
                {
                    miMax=miMax+1;
                }
                medtsMax.setText(miMax+"");
                medtsMin.setText(miMin+"");
                if(mArrayRange.size()>0)
                {
                    mArrayRange.clear();
                }
                for (int i=miMin;i<=miMax;i++)
                {
                    mArrayRange.add(i);
                }
            }
        });

        mbtReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mArrayRange.size();
                mArrayRange.clear();
                medtsMin.setText("");
                medtsMax.setText("");
                mkq.setText("");
            }
        });
        mbtRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (mArrayRange.size()<=0){
                    Toast.makeText(MainActivity.this, "Ket thuc", Toast.LENGTH_SHORT).show();
                    return;
                }
                int index = mRandom.nextInt(mArrayRange.size());
                mRandomValue=mArrayRange.get(index);
                if (mArrayRange.size() == 1){
                    mValue += mRandomValue;
                }else{
                    mValue += mRandomValue + " - ";
                }
                mkq.setText(mValue);
                mArrayRange.remove(index);
            }
        });
        enableView(mbtRandom);
        enableView(mbtReset);
        enableView(mbtRange);
    }
    private void enableView(View view){
        view.setEnabled(true);
    }
    private void disableView(View view){
        view.setEnabled(false);
    }
}