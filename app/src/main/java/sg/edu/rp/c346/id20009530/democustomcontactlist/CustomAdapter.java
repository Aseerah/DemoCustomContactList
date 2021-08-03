package sg.edu.rp.c346.id20009530.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvCode = rowView.findViewById(R.id.tvCode);
        TextView tvNumber = rowView.findViewById(R.id.tvNumber);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        // Obtain the Android Version information based on the position
        Contact currentItem = contactList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + (currentItem.getCountryCode()));
        tvNumber.setText(currentItem.getPhoneNum() + " ");

        if(currentItem.getGender() == 'M'){
            ivGender.setImageResource((R.drawable.male));
        }
        if(currentItem.getGender() == 'F'){
            ivGender.setImageResource((R.drawable.female));
        }

        return rowView;
    }

}
