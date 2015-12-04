package com.gkr.spinnerwithgridlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    String[] mString = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.txt_view);
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * Pass Your array list instate of @param mString
                * */
                GridViewDialog gridDialog = new GridViewDialog(MainActivity.this, mString, index);
                gridDialog.show();

            }
        });
    }

    /*
    * Set the selected index of grid view
    * */
    public void setTxtIndex(int mIndex, String mTxt) {
        this.index = mIndex;
        txtView.setText(mTxt);
    }
}
