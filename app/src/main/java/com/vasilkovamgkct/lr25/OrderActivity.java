// OrderActivity.java
package com.vasilkovamgkct.lr25;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Form fields and button
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextQuantity = findViewById(R.id.editTextQuantity);
        EditText editTextComments = findViewById(R.id.editTextComments);
        Button buttonPlaceOrder = findViewById(R.id.buttonPlaceOrder);

        buttonPlaceOrder.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String quantity = editTextQuantity.getText().toString();
            String comments = editTextComments.getText().toString();

            String message = "Заказ на " + quantity + " пицц для " + name + " успешно оформлен!";

            // Добавляем комментарий, если он не пустой
            if (!comments.isEmpty()) {
                message += "\nКомментарий: " + comments;
            }

            Toast.makeText(OrderActivity.this, message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Закрывает активность и возвращает на предыдущий экран
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
