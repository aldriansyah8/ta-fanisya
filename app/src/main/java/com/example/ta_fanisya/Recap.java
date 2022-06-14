package com.example.ta_fanisya;

import static com.example.ta_fanisya.LoginActivity.newuser;
import static com.example.ta_fanisya.Menu.totalOrder;
import static com.example.ta_fanisya.Menu.totalPrice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Recap extends AppCompatActivity {

    private Button bBack;
    private TextView order,price;
    private ImageView bPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        bBack = findViewById(R.id.btnBack1);
        bPesan = findViewById(R.id.btnPesan);
        order = findViewById(R.id.totalOrder_tv);
        price = findViewById(R.id.totalPrice_tv);

        order.setText(totalOrder.toString());
        price.setText(totalPrice.toString());

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Recap.this, Menu.class);
                startActivity(i);
            }
        });

        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("transaksi").child("orderStatus");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Integer money = snapshot.getValue(Integer.class);
                        money = money - totalPrice;
                        DatabaseReference myRef2 = database.getReference("transaksi").child(newuser).child("saldo");
                        myRef2.setValue(money);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                myRef.setValue(1);
                Intent i = new Intent(Recap.this, NotifProses.class);
                startActivity(i);
            }
        });
    }
}