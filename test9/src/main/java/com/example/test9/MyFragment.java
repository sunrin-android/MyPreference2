package com.example.test9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.preference.Preference;

public class MyFragment extends PreferenceFragment {
    SharedPreferences prefs;
    Preference network;

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.setting);

        network = findPreference("network");

        // 첫 화면 저장된 값 불러와서 보여주기
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if(!prefs.getString("network", "").equals(""))
            network.setSummary(prefs.getString("network", "2G"));

        // 저장된 값 불러와서 보여주기
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (!prefs.getString("network", "").equals(""))
            network.setSummary(prefs.getString("network", "2G"));

        // 이벤트 리스너 연결 - 값이 변경되면 다시 불러오기!!!
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    if (key.equals("network"))
                        network.setSummary(prefs.getString("network", "2G"));
                }
            };
}
