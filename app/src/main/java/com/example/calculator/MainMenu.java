package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    private ListView listView;
    private Button add,settings;
    private Context context;
    private List<Item> items;
    DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        listView=findViewById(R.id.listView);
        add=findViewById(R.id.btnAdd);
        settings=findViewById(R.id.btnSettings);
        context=this;

        dbHandler=new DbHandler(context);
        items=new ArrayList<>();
        items=dbHandler.getAllItems();
        ItemAdapter itemAdapter=new ItemAdapter(context,R.layout.single_row,items);
        listView.setAdapter(itemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("User Name :"+items.get(position).getUserName());
                builder.setMessage("Password :"+items.get(position).getPassword());

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(context, EditItem.class);
                        i.putExtra("id",String.valueOf(items.get(position).getId()));
                        startActivity(i);
                    }
                });
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteItem(items.get(position).getId());
                        startActivity(new Intent(context,MainMenu.class));
                    }
                });
                builder.show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddItem.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,Settings.class));
            }
        });

        
    }
}