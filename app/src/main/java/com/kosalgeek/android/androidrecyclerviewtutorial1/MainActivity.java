package com.kosalgeek.android.androidrecyclerviewtutorial1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
 //       setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rvItem = (RecyclerView)findViewById(R.id.rvItem);
        rvItem.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        rvItem.setLayoutManager(manager);

        ArrayList<Item> itemList = generatedDummy();

        ItemAdapter adapter = new ItemAdapter(getApplicationContext(), itemList);

        rvItem.setAdapter(adapter);


    }

    private ArrayList<Item> generatedDummy(){
        ArrayList<Item> list = new ArrayList<>();
        for(int i = 1; i < 50; i++){
            Item item = new Item();
            item.id = i;
            item.text = "inputs " + i;
            item.img = "https://s3.ap-south-1.amazonaws.com/myimagesforappyo/images/images/" +Integer.toString(i)+ "-inputs.png";
            list.add(item);
            Item item1 = new Item();
            item1.id = i+100;
            item1.text = "outputs" + i;
            item1.img = "https://s3.ap-south-1.amazonaws.com/myimagesforappyo/images/images/" +Integer.toString(i)+ "-outputs.png";
            list.add(item1);
            Item item2 = new Item();
            item2.id = i+200;
            item2.text = "targets" + i;
            item2.img = "https://s3.ap-south-1.amazonaws.com/myimagesforappyo/images/images/" +Integer.toString(i)+ "-targets.png";
            list.add(item2);


        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
