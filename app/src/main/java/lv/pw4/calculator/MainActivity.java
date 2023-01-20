package lv.pw4.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView calculationsTV;
    TextView resultsTV;
    float mValueOne, mValueTwo,savedValue;
    boolean Addition, mSubtract, Multiplication, Division, Decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculationsTV = (TextView) findViewById(R.id.calculations);
        resultsTV = (TextView)findViewById(R.id.results);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);


        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDecimal = findViewById(R.id.button10);
        Button buttonAdd = findViewById(R.id.buttonadd);
        Button buttonSub = findViewById(R.id.buttonsub);
        Button buttonMul = findViewById(R.id.buttonmul);
        Button buttonDivision = findViewById(R.id.buttondiv);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonEqual = findViewById(R.id.buttoneql);
        Button memSave = findViewById(R.id.memSave);
        Button memRead = findViewById(R.id.memRead);
        Button memClear = findViewById(R.id.memClear);

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Addition || mSubtract || Multiplication || Division ) {
                    mValueTwo = Float.parseFloat(calculationsTV.getText() + "");
                }

                if (Addition) {
                    resultsTV.setText(mValueOne + mValueTwo + "");
                    mValueTwo=Float.parseFloat(resultsTV.getText().toString());
                    Addition = false;
                }
                if (mSubtract) {
                    resultsTV.setText(mValueOne - mValueTwo + "");
                    mSubtract = false;
                }
                if (Multiplication) {
                    resultsTV.setText(mValueOne * mValueTwo + "");
                    Multiplication = false;
                }
                if (Division) {
                    resultsTV.setText(mValueOne / mValueTwo + "");
                    Division = false;
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculationsTV.getText().length() != 0) {
                    mValueOne = Float.parseFloat(calculationsTV.getText() + "");
                    Addition = true;
                    Decimal = false;
                    calculationsTV.setText(null);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculationsTV.getText().length() != 0) {
                    mValueOne = Float.parseFloat(calculationsTV.getText() + "");
                    mSubtract = true;
                    Decimal = false;
                    calculationsTV.setText(null);
                }

            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculationsTV.getText().length() != 0) {
                    mValueOne = Float.parseFloat(calculationsTV.getText() + "");
                    Multiplication = true;
                    Decimal = false;
                    calculationsTV.setText(null);
                }

            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculationsTV.getText().length() != 0) {
                    mValueOne = Float.parseFloat(calculationsTV.getText() + "");
                    Division = true;
                    Decimal = false;
                    calculationsTV.setText(null);
                }

            }
        });

        memSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultsTV.getText().length() != 0) {
                    savedValue = Float.parseFloat(resultsTV.getText().toString());
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putFloat("savedVal", savedValue);
                    editor.apply();
                }
            }
        });

        memRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedValue = sharedPref.getFloat("savedVal",0.0f);
                if (savedValue == 0.0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nothing saved", Toast.LENGTH_SHORT);
                    toast.show();
                } else calculationsTV.setText(calculationsTV.getText() + Float.toString(savedValue));

            }
        });

        memClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.apply();

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + "0");
            }
        });

        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText(calculationsTV.getText() + ".");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculationsTV.setText("");
                resultsTV.setText("");
            }
        });
    }
}