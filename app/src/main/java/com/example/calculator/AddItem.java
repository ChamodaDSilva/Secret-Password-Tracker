package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    private Button add;
    private EditText description,userName,password;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        add=findViewById(R.id.add);
        description =findViewById(R.id.editTextDescription);
        userName=findViewById(R.id.editTextUserName);
        password=findViewById(R.id.editTextPassword);
        context=this;

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textDescription=description.getText().toString();
                String textUserName=userName.getText().toString();
                String textPassword=password.getText().toString();
                Item item =new Item(textDescription,textUserName,textPassword);

                DbHandler dbHandler=new DbHandler(context);
                dbHandler.addItem(item);

                startActivity(new Intent(context,MainMenu.class));
            }
        });
    }
}