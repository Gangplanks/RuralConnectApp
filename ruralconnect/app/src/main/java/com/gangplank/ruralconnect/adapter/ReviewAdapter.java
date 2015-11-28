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

public class ReviewAdapter extends ArrayAdapter<DummyContent.DummyItem> {

    private final LayoutInflater mInflater;

    public ReviewAdapter(Context context, int recently_viewed_scheme_item, List<DummyContent.DummyItem> ITEMS) {
        super(context,recently_viewed_scheme_item, ITEMS);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<DummyContent.DummyItem> data) {
        clear();
        if (data != null) {
            for (DummyContent.DummyItem appEntry : data) {
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
            view = mInflater.inflate(R.layout.content_review, parent, false);
        } else {
            view = convertView;
        }

        DummyContent.DummyItem item = getItem(position);
        ((TextView)view.findViewById(R.id.content)).setText(item.content);

        return view;
    }
}

