package com.app.wecare.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.wecare.R;
import com.app.wecare.dao.RoleDAO;
import com.app.wecare.model.Employee;
import com.app.wecare.model.EmployeeImage;
import com.app.wecare.model.EmployeeRole;

import java.util.List;


public class EmployeesGridAdapter extends ArrayAdapter<Employee> {

    Context mContext;
    int layoutResourceId;
    List<EmployeeImage> images = null;
    List<EmployeeRole> roles = null;

    public EmployeesGridAdapter(Context mContext, int layoutResourceId, List<Employee> employees, List<EmployeeImage> images , List<EmployeeRole> roles) {

        super(mContext, layoutResourceId, employees);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.images = images;
        this.roles=roles;
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
        Employee employee = getItem(position);
        EmployeeImage image = images.get(position);
        EmployeeRole role= roles.get(position);

        //------

        TextView names = (TextView) convertView
                .findViewById(R.id.tv_employee_name);

        TextView roleName = (TextView) convertView
                .findViewById(R.id.tv_employee_role);
//        RoleDAO roleDAO = new RoleDAO(this.getContext());
        // ..........::::::::::::here:::::::::::::::::::
//        roleDAO.open();
        String employeeRole = role.getRole();
//        roleDAO.close();

        roleName.setText(employeeRole);

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        int id = employee.getId();

        names.setText(firstName + " " + lastName);
        names.setTag(id);

        // Image Resource
        ImageView imageView = (ImageView) convertView
                .findViewById(R.id.imageView1);

        imageView.setImageBitmap(image.getImage());


        return convertView;

    }


}
