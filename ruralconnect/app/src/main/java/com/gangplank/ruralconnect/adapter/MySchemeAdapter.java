package com.gangplank.ruralconnect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gangplank.ruralconnect.R;
import com.gangplank.ruralconnect.api.response.SchemeFilterResponse;
import com.gangplank.ruralconnect.fragment.dummy.DummyContent;

import java.util.List;

public class MySchemeAdapter extends ArrayAdapter<SchemeFilterResponse> {

    private final LayoutInflater mInflater;

    public MySchemeAdapter(Context context, int recently_viewed_scheme_item, List<SchemeFilterResponse> filteredSchemes) {
        super(context,recently_viewed_scheme_item, filteredSchemes);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<SchemeFilterResponse> data) {
        clear();
        if (data != null) {
            for (SchemeFilterResponse appEntry : data) {
                add(appEntry);
            }
        }
    }

    /**
     * Populate new items in the list.
     */
    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.content_myscheme, parent, false);
        } else {
            view = convertView;
        }

        SchemeFilterResponse scheme = getItem(position);
        TextView textView = (TextView) view.findViewById(R.id.content);
        textView.setText(scheme.getName());
        textView.setTag(scheme.getId());
        String icon = scheme.getIcon();
        int id = getContext().getResources().getIdentifier(icon, "mipmap", getContext().getPackageName());
        ((ImageView)view.findViewById(R.id.category_icon)).setImageResource(id);
        return view;
    }
}
