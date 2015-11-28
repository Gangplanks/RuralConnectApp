package com.gangplank.ruralconnect.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.gangplank.ruralconnect.R;
import com.gangplank.ruralconnect.adapter.MySchemeAdapter;
import com.gangplank.ruralconnect.api.response.SchemeFilterResponse;
import com.gangplank.ruralconnect.service.SchemeService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MySchemeFragment extends ListFragment{

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;


    public static MySchemeFragment newInstance() {
        MySchemeFragment fragment = new MySchemeFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MySchemeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://f7551972.ngrok.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchemeService schemeService = retrofit.create(SchemeService.class);
        Call<List<SchemeFilterResponse>> call = schemeService.getFilteredSchemes("Students", "23", "-", "-");
        call.enqueue(new Callback<List<SchemeFilterResponse>>() {
            @Override
            public void onResponse(Response<List<SchemeFilterResponse>> response, Retrofit retrofit) {
                int statusCode = response.code();
                List<SchemeFilterResponse> filteredSchemes = response.body();
                mAdapter = new MySchemeAdapter(getActivity(), R.layout.content_myscheme, filteredSchemes);
                setListAdapter(mAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t);
                // Log error here since request failed
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myscheme, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);


        return view;
    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }



}
