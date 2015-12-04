package com.gkr.spinnerwithgridlist;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.GridView;

public class GridViewDialog extends Dialog {

    public GridView gridView;
    int mIndex;
    public String[] mStrings;
    private Context mContext;

    public GridViewDialog(Context context, String[] mString, int index) {
        super(context);
        this.mContext = context;
        this.mStrings = mString;
        this.mIndex = index;
    }

    public GridViewDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected GridViewDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_grid_view);

        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(mContext);
        gridViewAdapter.addAll(mStrings);
        gridView.setAdapter(gridViewAdapter);
        gridView.setItemChecked(mIndex, true);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity) mContext).setIndex(position);
                dismiss();
            }
        });
    }

    public class GridViewAdapter extends ArrayAdapter<String> {

        public GridViewAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.form_option_text_view, parent, false);
            }
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.chkd_txt_view);
            checkedTextView.setText(getItem(position));

            return view;
        }
    }
}
