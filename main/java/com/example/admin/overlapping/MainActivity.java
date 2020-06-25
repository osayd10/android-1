package com.example.admin.overlapping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button b1;
    private TextView t1;
    private EditText e1;
    private TextView t2;
    private EditText e2;
    private TextView t3;
    private  String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= findViewById(R.id.button);
        t1=findViewById(R.id.tv);
        e1=findViewById(R.id.et1);
        t2=findViewById(R.id.tv2);
        e2=findViewById(R.id.et2);
        t3=findViewById(R.id.tv3);

        b1.setOnClickListener(this);
        e1.setInputType(InputType.TYPE_CLASS_NUMBER);





    }

    @Override
    public void onClick(View v) {

        System.out.println("hello 1");
        int var=0;
        String s2 = "";
        ArrayList A= new ArrayList();

        String s = e2.getText().toString();
        for (int i=0;i<s.length();i++) {
            if (!s.isEmpty()) {
                char c = s.charAt(i);
                var= (int)c;
                A.add(var);
            }
        }
        System.out.println("hello 2");

        ArrayList B= new ArrayList();
        B=overlap(A);
        for (int j=0; j<B.size();j++)
        {
            int v2=(int) B.get(j);
            char c2=(char) v2;
            s2=s2+" "+c2;

        }


t3.setText(s2);
        System.out.println("hello 3");
    }
    public static ArrayList<Integer> overlap(List a)
    {
        int i=0,j=0;

        for(i=0; i< a.size()-2; i+=2)
        {
            for(j=2;j<a.size();j+=2)
            {

                if((int)a.get(i) < (int)a.get(j) && (int)a.get(i+1)>=(int)a.get(j) && (int)a.get(i+1)<(int)a.get(j+1))
                {
                    a.set(i+1,0);
                    a.set(j,0);

                    break;

                }
               else if ((int)a.get(i) > (int)a.get(j) && (int)a.get(i+1)<(int)a.get(j+1))
                {

                    a.set(i,0);
                    a.set(i+1,0);

                    break;


                }
                else if ((int)a.get(i) < (int)a.get(j) && (int)a.get(i+1)>(int)a.get(j+1))
                {
                    a.set(j,0);
                    a.set(j+1,0);

                }

            }
        }
        return (ArrayList<Integer>) a;
    }


}
