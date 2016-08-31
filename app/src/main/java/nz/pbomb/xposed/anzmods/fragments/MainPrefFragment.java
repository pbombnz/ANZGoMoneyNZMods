package nz.pbomb.xposed.anzmods.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;

import nz.pbomb.xposed.anzmods.Common;
import nz.pbomb.xposed.anzmods.preferences.PREFERENCES;
import nz.pbomb.xposed.anzmods.R;
import nz.pbomb.xposed.anzmods.activities.HelpActivity;
import nz.pbomb.xposed.anzmods.activities.PrefActivity;


public class MainPrefFragment extends PreferenceFragment implements OnPreferenceClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_main);

        //findPreference(PREFERENCES.KEYS.MAIN.ASB).setOnPreferenceClickListener(this);
        findPreference(PREFERENCES.KEYS.MAIN.ANZ).setOnPreferenceClickListener(this);
        findPreference(PREFERENCES.KEYS.MAIN.SEMBLE).setOnPreferenceClickListener(this);
        findPreference(PREFERENCES.KEYS.MAIN.TVNZ).setOnPreferenceClickListener(this);
        findPreference(PREFERENCES.KEYS.MAIN.TV3NOW).setOnPreferenceClickListener(this);

        findPreference(PREFERENCES.KEYS.MAIN.DEBUG).setOnPreferenceClickListener(this);
        //findPreference(PREFERENCES.KEYS.MAIN.HELP).setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        Intent intent = null;
        switch (preference.getKey()) {
            /*case PREFERENCES.KEYS.MAIN.ASB:
                intent = new Intent(getActivity(), PrefActivity.class);
                intent.putExtra("id", R.xml.preferences_asb);
                intent.putExtra("title", getString(R.string.label_asb));
                intent.putExtra("preference", preference.getKey());
                break;*/
            case PREFERENCES.KEYS.MAIN.ANZ:
                intent = new Intent(getActivity(), PrefActivity.class);
                intent.putExtra("id", R.xml.preferences_anz);
                intent.putExtra("title", getString(R.string.label_anz));
                intent.putExtra("preference", preference.getKey());
                break;
            case PREFERENCES.KEYS.MAIN.SEMBLE:
                intent = new Intent(getActivity(), PrefActivity.class);
                intent.putExtra("id", R.xml.preferences_semble);
                intent.putExtra("title", getString(R.string.label_semble));
                intent.putExtra("preference", preference.getKey());
                break;
            case PREFERENCES.KEYS.MAIN.TVNZ:
                intent = new Intent(getActivity(), PrefActivity.class);
                intent.putExtra("id", R.xml.preferences_tvnz);
                intent.putExtra("title", getString(R.string.label_tvnz));
                intent.putExtra("preference", preference.getKey());
                break;
            case PREFERENCES.KEYS.MAIN.TV3NOW:
                intent = new Intent(getActivity(), PrefActivity.class);
                intent.putExtra("id", R.xml.preferences_tv3now);
                intent.putExtra("title", getString(R.string.label_tv3now));
                intent.putExtra("preference", preference.getKey());
                break;
            case PREFERENCES.KEYS.MAIN.DEBUG:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                if(!Common.getInstance().DEBUG) {
                    if (checkBoxPreference.isChecked()) {
                        getActivity().setTitle(getResources().getString(R.string.app_name) + " (Debug Mode)");
                    } else {
                        getActivity().setTitle(getResources().getString(R.string.app_name));
                    }
                }

                SharedPreferences sharedPref = getActivity().getSharedPreferences(Common.getInstance().SHARED_PREFS_FILE_NAME, Context.MODE_WORLD_READABLE);
                SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();
                sharedPrefEditor.putBoolean(PREFERENCES.KEYS.MAIN.DEBUG, checkBoxPreference.isChecked());
                sharedPrefEditor.apply();

                return true;
            case PREFERENCES.KEYS.MAIN.HELP:
                intent = new Intent(getActivity(), HelpActivity.class);
                break;
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
        return true;
    }
}
