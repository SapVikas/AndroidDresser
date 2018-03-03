package com.sap.androiddresser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Naruto on 2/24/2018.
 */

public class MasterList extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list);
        MasterListFragment masterList = new MasterListFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.all_pics, masterList).commit();
    }

    @Override
    public void OnImageSelected(int position) {
        Toast.makeText(this,"Position Clicked = " + position, Toast.LENGTH_SHORT).show();

        int bodyPartNumber= position/12;
        int listIndex = position-12*bodyPartNumber;

        switch (bodyPartNumber){
            case 0:
                headIndex=listIndex;
                break;
            case 1:
                bodyIndex=listIndex;
                break;
            case 2:
               legIndex=listIndex;
                break;
                default:break;
        }
        Bundle b =  new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);

        final Intent intent = new Intent(this,MainActivity.class);
        intent.putExtras(b);

        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
