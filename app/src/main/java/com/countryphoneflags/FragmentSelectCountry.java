package com.countryphoneflags;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.countryphoneflags.databinding.FragmentSelectCountryBinding;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FragmentSelectCountry extends Fragment {
    ViewGroup viewGroup;
    Context thisContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_select_country, container, false);
        thisContext = container.getContext();

        identifies();
        init();

        return viewGroup;
    }

    private void init() {

        String[] recourseList = this.getResources().getStringArray(R.array.CountryCodes);




        ListView listview = viewGroup.findViewById(R.id.listViewCountries);
        listview.setAdapter(new CountriesListAdapter(thisContext, recourseList));
    }

    private void identifies() {
    }
}