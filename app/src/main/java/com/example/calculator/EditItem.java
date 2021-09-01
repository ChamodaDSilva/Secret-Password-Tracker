package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItem extends AppCompatActivity {
    private Button btnEdit;
    private EditText description,userName,password;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        btnEdit=findViewById(R.id.edit);
        description =findViewById(R.id.editTextDescription);
        userName=findViewById(R.id.editTextUserName);
        password=findViewById(R.id.editTextPassword);
        context=this;

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        DbHandler dbHandler=new DbHandler(context);

        Item item;
        item=dbHandler.getSingleItem(Integer.valueOf(id));

        description.setText(item.getDescription());
        userName.setText(item.getUserName());
        password.setText(item.getPassword());


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newDescription=description.getText().toString();
                String newUserName=userName.getText().toString();
                String newPassword=password.getText().toString();
                Item updatedItem=new Item(item.getId(),newDescription,newUserName,newPassword);
                dbHandler.updateSingleItem(updatedItem);
                startActivity(new Intent(context,MainMenu.class));
            }
        });
    }
}