package edu.umbc.dmutlu1.photoprintsdem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private final double price4x6 = 0.19;
    private final double price5x7 = 0.49;
    private final double price8x10 = 0.79;
    private int photos;
    private double customerPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton radio4x6 = findViewById(R.id.radio4x6);
        final RadioButton radio5x7 = findViewById(R.id.radio5x7);
        final RadioButton radio8x10 = findViewById(R.id.radio8x10);
        final EditText numPhoto = findViewById(R.id.editText);
        Button calcBtn = findViewById(R.id.button);
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

        calcBtn.setOnClickListener(v -> {
            final TextView output = findViewById(R.id.textOut);

            if (numPhoto.getText().toString().isEmpty())
            {
                photos = 0;
            }
            else
            {
                photos = Integer.parseInt(numPhoto.getText().toString());
            }

            if (photos == 0 || photos > 50)
            {
                myToast();
            }
            else if (radio4x6.isChecked())
            {
                customerPrice = photos * price4x6;

                output.setVisibility(1);
                output.setText(getString(R.string.order_cost) + currency.format(customerPrice));

            }
            else if (radio5x7.isChecked())
            {
                customerPrice = photos * price5x7;

                output.setVisibility(1);
                output.setText(getString(R.string.order_cost) + currency.format(customerPrice));
            }
            else if (radio8x10.isChecked())
            {
                customerPrice = photos * price8x10;

                output.setVisibility(1);
                output.setText(getString(R.string.order_cost) + currency.format(customerPrice));
            }
        });
    }

    private void myToast()
    {
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.toast);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}