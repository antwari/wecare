package com.app.wecare.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.wecare.R;
import com.app.wecare.model.Department;

import java.util.List;

public class DepartmentListAdapter extends ArrayAdapter<Department> {
    Context mContext;
    int layoutResourceId;
    List<Department> data = null;

    public DepartmentListAdapter(Context mContext, int layoutResourceId, List<Department> data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row layout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
         */
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        Department objectItem = data.get(position);

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView department = (TextView) convertView.findViewById(R.id.tv_department_name);
        department.setTag(objectItem.getId());
        department.setText(objectItem.getName());


        return convertView;

    }

}
