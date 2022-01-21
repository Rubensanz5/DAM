package com.example.multimedia_rsg;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multimedia_rsg.databinding.FragmentSensorBinding;
import com.example.multimedia_rsg.databinding.FragmentSonidoBinding;

import java.util.List;

public class SensorFragment extends Fragment implements SensorEventListener {
    FragmentSensorBinding binding;
    Sensor acelerometro;
    SensorManager sensorManager;


    public SensorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSensorBinding.inflate(inflater);
        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s : listaSensores) {
            Log.i("SENSORES", s.getName());
        }

        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        binding.textView.setText("Eje X:" + sensorEvent.values[0]);
        binding.textView2.setText("Eje Y:" + sensorEvent.values[1]);
        binding.textView3.setText("Eje Z:" + sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, acelerometro,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}