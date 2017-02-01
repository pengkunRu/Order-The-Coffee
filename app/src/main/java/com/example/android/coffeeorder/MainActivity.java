package com.example.android.coffeeorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view){
        display(1);
        displayPrice(2 * 5);
    }

    /**
     * This method display the given quantity value on the screen
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(java.text.NumberFormat.getCurrencyInstance().format(number));
    }
}
