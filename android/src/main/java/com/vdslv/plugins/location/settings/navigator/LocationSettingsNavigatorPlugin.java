package com.vdslv.plugins.location.settings.navigator;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.JSObject;

@CapacitorPlugin(name = "LocationSettingsNavigator")
public class LocationSettingsNavigatorPlugin extends Plugin {
private static final int BACKGROUND_LOCATION_PERMISSION_CODE = 2;

        @PluginMethod
        public void checkPermission(PluginCall call) {
            JSObject ret = new JSObject();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                boolean isGranted = ContextCompat.checkSelfPermission(
                    getBridge().getActivity().getApplicationContext(),
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                ) == PackageManager.PERMISSION_GRANTED;
                ret.put("granted", isGranted);
            } else {
                // For Android < Q, if they have location permission, they effectively have background permission
                boolean isGranted = ContextCompat.checkSelfPermission(
                    getBridge().getActivity().getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED;
                ret.put("granted", isGranted);
            }
            call.resolve(ret);
        }

    @PluginMethod
    public void openLocationSettings(PluginCall call) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                saveCall(call);
                ActivityCompat.requestPermissions(
                    getBridge().getActivity(),
                    new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION},
                    BACKGROUND_LOCATION_PERMISSION_CODE
                );
            } else {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                Uri uri = Uri.fromParts("package", getBridge().getActivity().getPackageName(), null);
                intent.setData(uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getBridge().getActivity().startActivity(intent);
                call.resolve();
            }
        } catch (Exception e) {
            // Fallback to application details settings if direct navigation fails
            try {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getBridge().getActivity().getPackageName(), null);
                intent.setData(uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getBridge().getActivity().startActivity(intent);
                call.resolve();
            } catch (Exception fallbackError) {
                call.reject("Failed to open settings", fallbackError);
            }
        }
    }

    @Override
    protected void handleRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.handleRequestPermissionsResult(requestCode, permissions, grantResults);

        PluginCall savedCall = getSavedCall();
        if (savedCall == null) {
            return;
        }

        if (requestCode == BACKGROUND_LOCATION_PERMISSION_CODE) {
            try {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getBridge().getActivity().getPackageName(), null);
                intent.setData(uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getBridge().getActivity().startActivity(intent);
                savedCall.resolve();
            } catch (Exception e) {
                savedCall.reject("Failed to open settings", e);
            }
        }
    }
}

