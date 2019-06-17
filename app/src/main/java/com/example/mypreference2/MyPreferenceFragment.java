package com.example.mypreference2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.preference.Preference;

public class MyPreferenceFragment extends PreferenceFragment {
    SharedPreferences prefs;
    Preference sound_list, keyword_sound_list;

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.kakao_setting);

        sound_list = findPreference("sound_list");
        keyword_sound_list = findPreference("keyword_sound_list");

        // 첫 화면 저장된 값 불러와서 보여주기
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if(!prefs.getString("sound_list", "").equals(""))
            sound_list.setSummary(prefs.getString("sound_list", "카톡"));
        if(!prefs.getString("keyword_sound_list", "").equals(""))
            keyword_sound_list.setSummary(prefs.getString("keyword_sound_list", "카톡"));

        // 저장된 값 불러와서 보여주기
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        if (!prefs.getString("sound_list", "").equals(""))
            sound_list.setSummary(prefs.getString("sound_list", "카톡"));

        // 이벤트 리스너 연결 - 값이 변경되면 다시 불러오기!!!
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    if (key.equals("sound_list"))
                        sound_list.setSummary(prefs.getString("sound_list", "카톡"));
                    if(key.equals("keyword_sound_list"))
                        keyword_sound_list.setSummary(prefs.getString("keyword_sound_list", "카톡"));
                }
            };
}
