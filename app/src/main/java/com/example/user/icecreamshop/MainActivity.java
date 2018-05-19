package com.example.user.icecreamshop;

import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.text.Format;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioGroup radioGroup;
    private RadioButton sizeButton;

    private FloatingActionButton increase1, increase2, increase3, decrease1, decrease2, decrease3;
    private TextView text1, text2, text3, status;
    private Button order, total;
    private MaterialSpinner spinner;
    private CardView CV1, CV2, CV3;
    private LinearLayout overall;

    int quantity1 = 1, quantity2 = 1, quantity3 = 1;

    String[] flavors = {"Strawberry", "Vanilla", "Chocolate", "Strawberry-Vanilla", "StrawBerry-Chocolate", "Vanilla-Chocolate"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        }

        //FloatingActionButtons
        increase1 = findViewById(R.id.increaseS);
        increase2 = findViewById(R.id.increaseM);
        increase3 = findViewById(R.id.increaseL);
        decrease1 = findViewById(R.id.decreaseS);
        decrease2 = findViewById(R.id.decreaseM);
        decrease3 = findViewById(R.id.decreaseL);

        increase1.setOnClickListener(this);
        increase2.setOnClickListener(this);
        increase3.setOnClickListener(this);
        decrease1.setOnClickListener(this);
        decrease2.setOnClickListener(this);
        decrease3.setOnClickListener(this);

        //TextViews
        text1 = findViewById(R.id.textS);
        text2 = findViewById(R.id.textM);
        text3 = findViewById(R.id.textL);
        status = findViewById(R.id.status);

        //Buttons
        order = findViewById(R.id.order);
        total = findViewById(R.id.total);

        order.setOnClickListener(this);
        total.setOnClickListener(this);

        //cardViews
//        CV1 = findViewById(R.id.cv1);
//        CV2 = findViewById(R.id.cv2);
//        CV3 = findViewById(R.id.cv3);
//
//        CV1.getBackground().setAlpha(100);
//        CV2.getBackground().setAlpha(100);
//        CV3.getBackground().setAlpha(100);

        //LinearLayout
        overall = findViewById(R.id.overall);
        overall.getBackground().setAlpha(200);

        //spinner
        spinner = findViewById(R.id.spinner);
        spinner.setItems(flavors);

        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                //int i = position;
                switch (view.getSelectedIndex()){
                    case(0)://strawberry
                        spinner.setBackground(getResources().getDrawable(R.drawable.straw));
                        break;

                    case(1)://vanilla
                        spinner.setBackground(getResources().getDrawable(R.drawable.van));
                        break;

                    case(2)://chocolate
                        spinner.setBackground(getResources().getDrawable(R.drawable.choc));
                        break;

                    case(3)://Strawberry-Vanilla
                        spinner.setBackground(getResources().getDrawable(R.drawable.straw_van));
                        break;

                    case(4)://Strawberry-Vanilla
                        spinner.setBackground(getResources().getDrawable(R.drawable.straw_choc));
                        break;

                    case(5)://Strawberry-Vanilla
                        spinner.setBackground(getResources().getDrawable(R.drawable.van_choc));
                        break;
                }
            }
        });


    }//end of onCreate

    //price button
    private void displayPrice(int number){
        status.setText("" + NumberFormat.getCurrencyInstance().format(number));
    }

    private void order(){
        displayPrice(quantity1 * 2 + quantity2 * 5 + quantity3 * 10);
    }
    //end of price button

    //order button
    private void displayOrder(int number){
        status.setText("" + NumberFormat.getCurrencyInstance().format(number) + "\nOrder submitted");
    }

    private void message(){
        displayOrder(quantity1 * 2 + quantity2 * 5 + quantity3 * 10);
    }
    //end of order button

    private void display1(int number){
        text1.setText("" + number);
    }

    private void display2(int number){
        text2.setText("" + number);
    }

    private void display3(int number){
        text3.setText("" + number);
    }

    private void increament1(){
        if (quantity1 >= 0){
            quantity1 = quantity1 + 1;
        }
    }

    private void increament2(){
        if (quantity2 >= 0){
            quantity2 = quantity2 + 1;
        }
    }

    private void increament3(){
        if (quantity3 >= 0){
            quantity3 = quantity3 + 1;
        }
    }

    private void decreament1(){
        if (!(quantity1 <= 1)){
            quantity1 = quantity1 - 1;
        }
    }

    private void decreament2(){
        if (!(quantity2 <= 1)){
            quantity2 = quantity2 - 1;
        }
    }

    private void decreament3(){
        if (!(quantity3 <= 1)){
            quantity3 = quantity3 - 1;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.increaseS):
                increament1();
                display1(quantity1);
                break;

            case(R.id.increaseM):
                increament2();
                display2(quantity2);
                break;

            case(R.id.increaseL):
                increament3();
                display3(quantity3);
                break;

            case(R.id.decreaseS):
                decreament1();
                display1(quantity1);
                break;

            case(R.id.decreaseM):
                decreament2();
                display2(quantity2);
                break;

            case(R.id.decreaseL):
                decreament3();
                display3(quantity3);
                break;

            case(R.id.total):
                order();
                break;

            case(R.id.order):
                message();
                break;
        }
    }
}//end of public class
