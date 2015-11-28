package com.gangplank.ruralconnect.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gangplank.ruralconnect.R;
import com.gangplank.ruralconnect.activity.NavigationActivity;
import com.gangplank.ruralconnect.adapter.MySchemeAdapter;
import com.gangplank.ruralconnect.api.response.SchemeFilterResponse;
import com.gangplank.ruralconnect.client.RestClient;
import com.gangplank.ruralconnect.model.Scheme;
import com.gangplank.ruralconnect.service.SchemeService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchemeFragment extends Fragment {

    private View view;

    public SchemeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scheme, container, false);
        int schemeId = (int) NavigationActivity.myBundle.get("scheme_id");
        Retrofit retrofit = RestClient.getInstance();
        SchemeService schemeService = retrofit.create(SchemeService.class);
        Call<Scheme> call = schemeService.findById(schemeId);
        call.enqueue(new Callback<Scheme>() {
            @Override
            public void onResponse(Response<Scheme> response, Retrofit retrofit) {
                int statusCode = response.code();
                Scheme scheme = response.body();
                inflateView(scheme);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t);
                // Log error here since request failed
            }
        });
        return view;
    }

    private void inflateView(Scheme scheme) {
        TextView nameView = (TextView) view.findViewById(R.id.textView8);
        nameView.setText(nameView.getText() + "\n" + scheme.getName());

        TextView departmentView = (TextView) view.findViewById(R.id.textView9);
        departmentView.setText(departmentView.getText() + "\n" + scheme.getDepartment());

        TextView fundingView = (TextView) view.findViewById(R.id.textView10);
        fundingView.setText(fundingView.getText() + "\n" + scheme.getFunding_pattern());

        TextView availFromView = (TextView) view.findViewById(R.id.textView15);
        availFromView.setText(availFromView.getText() + "\n" + scheme.getAvail_from());

        TextView validFromView = (TextView) view.findViewById(R.id.textView16);
        validFromView.setText(validFromView.getText() + "\n" + scheme.getValid_from());

        TextView descriptionView = (TextView) view.findViewById(R.id.textView18);
        descriptionView.setText(descriptionView.getText() + "\n" + scheme.getDescription());
    }
}
