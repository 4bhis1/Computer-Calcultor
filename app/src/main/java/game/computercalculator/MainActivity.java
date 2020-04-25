package game.computercalculator;



import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import game.computercalculator.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pop=findViewById(R.id.button2);
        Button go=findViewById(R.id.button3);
        final CheckBox f=findViewById(R.id.checkBox);
        final CheckBox s=findViewById(R.id.checkBox2);
        final EditText fnu=findViewById(R.id.editText);
        final EditText snu=findViewById(R.id.editText3);
        final EditText sym=findViewById(R.id.editText2);
        final TextView result=findViewById(R.id.textView);
        final Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        //int m=0;

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>=26){
                    vibrator.vibrate(VibrationEffect.createOneShot(100,VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else{
                    vibrator.vibrate(100);
                }
                String k= (String) result.getText();
                //if()
                fnu.setText(""+k);
                snu.setText("");
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f.isChecked()==true){
                    Toast.makeText(MainActivity.this, "Gaand mra BC", Toast.LENGTH_SHORT).show();
                    fnu.setTextColor(Color.parseColor("#FF0000"));
                }
                else{
                    Toast.makeText(MainActivity.this, "tu mra sale", Toast.LENGTH_SHORT).show();
                    fnu.setTextColor(Color.parseColor("#00ff00"));
                }

            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(s.isChecked()==true){
                    Toast.makeText(MainActivity.this, "chup lwde", Toast.LENGTH_SHORT).show();
                    snu.setTextColor(Color.parseColor("#FF0000"));

                }
                else{
                    Toast.makeText(MainActivity.this, "chl apne kaam se kaam rkh", Toast.LENGTH_SHORT).show();
                    snu.setTextColor(Color.parseColor("#00ff00"));
                }
            }
        });


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>=26){
                    vibrator.vibrate(VibrationEffect.createOneShot(100,VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else{
                    vibrator.vibrate(100);
                }

             try {

                 float fnum=Float.parseFloat(fnu.getText().toString());
                 float snum=Float.parseFloat(snu.getText().toString());
                 String symbol=sym.getText().toString();
                 char c=symbol.charAt(0);
                 float re = 0;

                 if(c=='+')
                     re=fnum+snum;
                 else if(c=='-')
                     re=fnum-snum;
                 else if(c=='*')
                     re=fnum*snum;
                 else if(c=='/'){
                     try{
                         re=fnum/snum;
                     }
                     catch (Exception e){
                         Toast.makeText(MainActivity.this, "you can't devide any number by 0", Toast.LENGTH_SHORT).show();
                     }
                 }
                 else if(c=='%')
                     re=fnum%snum;
                 else if(symbol==null)
                     Toast.makeText(MainActivity.this, "BSDK kuch to daal", Toast.LENGTH_SHORT).show();
                 else
                     Toast.makeText(MainActivity.this, "BSDK shi symbol use kr na", Toast.LENGTH_SHORT).show();

                if(f.isChecked()==false && s.isChecked()==false){
                    int k=(int)re;
                    result.setTextColor(Color.parseColor("#00ff00"));
                    result.setText(""+k);
                }else{
                    result.setTextColor(Color.parseColor("#FF0000"));
                    result.setText(""+re);

                }
                 //result.setText(""+re);

             }
             catch(Exception e){
                 Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_SHORT).show();
             }

            }
        });
    }
}
