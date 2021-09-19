package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mySpinner;
    EditText ecran;
    Button btn ,btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    final List<String> options = new ArrayList<>();
    boolean isBtnVisible;
    double a, b, resultat;
    String Op = "+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySpinner = findViewById(R.id.sp);
        ecran =  findViewById(R.id.ecran);
        btn = (Button)  findViewById(R.id.btn);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        options.add("Standard");
        options.add("Scientifique");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, options ) ;
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="cos( ";
                ecran.setText(Op);

            }});
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="sin( ";
                ecran.setText(Op);
            }});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="tang( ";
                ecran.setText(Op);
            }});
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="log( ";
                ecran.setText(Op);

            }});
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="^( ";
                ecran.setText(Op);

            }});
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="log10( ";
                ecran.setText(Op);

            }});
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="√( ";
                ecran.setText(Op);

            }});
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecran.setText("");
                Op="exp( ";
                ecran.setText(Op);

            }});


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, options.get(position), Toast.LENGTH_SHORT).show();
        if(position==1){
            btn.setVisibility(view.VISIBLE);
            btn1.setVisibility(view.VISIBLE);
            btn2.setVisibility(view.VISIBLE);
            btn3.setVisibility(view.VISIBLE);
            btn4.setVisibility(view.VISIBLE);
            btn5.setVisibility(view.VISIBLE);
            btn6.setVisibility(view.VISIBLE);
            btn7.setVisibility(view.VISIBLE);
            isBtnVisible = true;
        }
        else{
            btn.setVisibility(view.INVISIBLE);
            btn1.setVisibility(view.INVISIBLE);
            btn2.setVisibility(view.INVISIBLE);
            btn3.setVisibility(view.INVISIBLE);
            btn4.setVisibility(view.INVISIBLE);
            btn5.setVisibility(view.INVISIBLE);
            btn6.setVisibility(view.INVISIBLE);
            btn7.setVisibility(view.INVISIBLE);
            isBtnVisible = false;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void chiffre(View view) {
        String chf = view.getTag().toString();
        String ecranTxt = ecran.getText().toString();
        if(ecranTxt.equals("NaN") ||ecranTxt.equals("0") || ecranTxt.contains(".")  ) ecranTxt="";
        ecranTxt = chf;
        ecran.setText(ecranTxt);
    }

    public void effacer(View view) {
        ecran.setText("");
    }

    public void operation(View view) {
        Button btn = (Button) view;
        String ecranTxt = ecran.getText().toString();
        a = Double.valueOf(ecranTxt);
        ecran.setText("");
        Op = btn.getText().toString();
    }

    public void egal(View view) {
        String ecranTxt = ecran.getText().toString();

        b = Double.valueOf(ecranTxt);

        Log.i("test", "OP = "+ Op);
        switch (Op)
        {
            case "+" :
                 resultat = a + b;
                break;
            case "-" :
                resultat = a - b;
                break;
            case "/" :
                resultat = b==0? Double.NaN : a / b;
                break;
            case "X" :
                resultat =  a * b;
                break;
            case "cos( ":
                if( isBtnVisible = true){ resultat=Math.cos(b);}
                break;

            case "sin( ":
                if( isBtnVisible = true){ resultat=Math.sin(b);}
                break;

            case "tang( ":
                if( isBtnVisible = true){resultat=Math.tan(b);}
                break;

            case "log( ":
                if( isBtnVisible = true){resultat=Math.log(b);}
                break;

            case "^( ":
                if( isBtnVisible = true){ resultat=Math.pow(a, b);}
                break;

            case "log10( ":
                if( isBtnVisible = true){resultat=Math.log10(b) ;}
                break;

            case "exp( ":
                if( isBtnVisible = true){resultat=Math.exp(b) ;}
                break;

            case "√( ":
                if( isBtnVisible = true){resultat=Math.sqrt(b) ;}
                break;


        }
        ecran.setText(Double.toString(resultat));
    }
}
