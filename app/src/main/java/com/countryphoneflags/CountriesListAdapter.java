package com.countryphoneflags;

import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountriesListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public CountriesListAdapter(Context context, String[] values) {
        super(context, R.layout.country_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.country_list_item, parent, false);
        TextView textView = rowView.findViewById(R.id.txtViewCountryName);
        TextView textView1 = rowView.findViewById(R.id.txtViewCountryCode);
        ImageView imageView = rowView.findViewById(R.id.imgViewFlag);

        String[] g = values[position].split(",");
        textView.setText(GetCountryZipCode(g[1]).trim());
        textView1.setText(GetCountryZipCode(g[0]).trim());

        String pngName;
        if (g[1].trim().toLowerCase().equals("do"))
            pngName = "flag_do";
        else
            pngName = g[1].trim().toLowerCase();
        imageView.setImageResource(context.getResources().getIdentifier("drawable/" + pngName, null, context.getPackageName()));
        return rowView;
    }

    private String GetCountryZipCode(String ssid) {
        Locale loc = new Locale("", ssid);

        return loc.getDisplayCountry().trim();
    }
}
