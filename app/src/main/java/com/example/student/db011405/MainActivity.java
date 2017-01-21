package com.example.student.db011405;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int fruitid, tmp;
    boolean[] b=new boolean[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("對話框");
        builder.setMessage("測試對話框");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下了取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("小幫手", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下了小幫手", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("輸入框");
        builder.setMessage("輸入用對話框");
        final EditText ed = new EditText(MainActivity.this);
        builder.setView(ed);

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下了確定:" + ed.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下了取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("單選項");
        builder.setSingleChoiceItems(R.array.fruits, fruitid, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp = which;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                fruitid = tmp;
                String str[] = getResources().getStringArray(R.array.fruits);
                TextView tv = (TextView) findViewById(R.id.textView);
                tv.setText(str[fruitid]);

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下了取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void click4(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("清單");
        builder.setItems(R.array.fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] fruits=getResources().getStringArray(R.array.fruits);
                TextView tv2= (TextView) findViewById(R.id.textView2);
                tv2.setText(fruits[which]);
            }
        });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void click5(View v){
        final boolean[] tmp=b.clone();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("多選");
        builder.setMultiChoiceItems(R.array.fruits, tmp, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setNegativeButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                b=tmp;
                TextView tv3= (TextView) findViewById(R.id.textView3);
                String[] fruits=getResources().getStringArray(R.array.fruits);//把選項取出
                String tmp = "";
                for(int i=0;i<b.length;i++){
                    if(b[i])
                    tmp+=fruits[i]+",";
                }

                tv3.setText(tmp);
            }
        });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void click6(View v){
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.mylayout,null);
        Button btn7= (Button) layout.findViewById(R.id.button7);
        final TextView tv5= (TextView) layout.findViewById(R.id.textView5);
        final TextView tv4= (TextView) findViewById(R.id.textView4);
        final EditText et= (EditText) layout.findViewById(R.id.editText);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv5.setText("成功了");
                tv4.setText(et.getText().toString());
            }
        });

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setView(layout);
        builder.show();
    }
    public  void click7(View v){
        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("程式執行中");
        dialog.setMessage("請稍後...");

        dialog.show();
        new Thread(){
            public void run(){
                try {
                    Thread.sleep(2000);
                    dialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
