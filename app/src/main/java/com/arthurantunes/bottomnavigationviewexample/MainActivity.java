/*
 * Copyright (c) 2017 Arthur Antunes Dias.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arthurantunes.bottomnavigationviewexample;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener {

  BottomNavigationView bottomNavigationView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
    bottomNavigationView.setOnNavigationItemSelectedListener(this);

    setInitialFragment();
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    Fragment fragment = null;
    switch (item.getItemId()) {
      case R.id.action_device:
        fragment = new DeviceFragment();
        break;
      case R.id.action_cloud:
        fragment = new CloudFragment();
        break;
      case R.id.action_share:
        fragment = new ShareFragment();
        break;
      case R.id.action_settings:
        fragment = new SettingsFragment();
        break;
    }
    replaceFragment(fragment);
    return true;
  }

  private void setInitialFragment() {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.main_fragment_placeholder, new DeviceFragment());
    fragmentTransaction.commit();
  }

  private void replaceFragment(Fragment fragment) {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.main_fragment_placeholder, fragment);
    fragmentTransaction.commit();
  }
}
