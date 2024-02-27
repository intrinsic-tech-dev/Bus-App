package com.example.go_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BusAdaptor extends ArrayAdapter<BusRoute> {

    private Context context;
    private List<BusRoute> busroute;

    public BusAdaptor(@NonNull Context context, List<BusRoute> busroute) {
        super(context, R.layout.busroute_layout, busroute);
        this.context = context;
        this.busroute = busroute;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.busroute_layout, parent, false);

        TextView StartLocation = convertView.findViewById(R.id.StartLocation);
        TextView EndLocation = convertView.findViewById(R.id.EndLocation);
        TextView StartTime = convertView.findViewById(R.id.StartTime);
        TextView EndTime = convertView.findViewById(R.id.EndTime);
        TextView BusNumber = convertView.findViewById(R.id.BusNumber);
        TextView Currency = convertView.findViewById(R.id.Currency);
        TextView Price = convertView.findViewById(R.id.Price);

        StartLocation.setText(busroute.get(position).getStartLocation());
        EndLocation.setText(busroute.get(position).getEndLocation());
        StartTime.setText(busroute.get(position).getStartTime());
        EndTime.setText(busroute.get(position).getEndTime());
        BusNumber.setText(busroute.get(position).getBusNumber());
        Currency.setText(busroute.get(position).getCurrency());
        Price.setText(Float.toString(busroute.get(position).getPrice()));
        
        return super.getView(position, convertView, parent);
    }
}
