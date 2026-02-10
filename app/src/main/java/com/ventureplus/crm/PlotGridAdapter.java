package com.ventureplus.crm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class PlotGridAdapter extends BaseAdapter {

    private Context context;
    private List<VentureMapActivity.Plot> plotList;

    public PlotGridAdapter(Context context, List<VentureMapActivity.Plot> plotList) {
        this.context = context;
        this.plotList = plotList;
    }

    @Override
    public int getCount() {
        return plotList.size();
    }

    @Override
    public Object getItem(int position) {
        return plotList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.plot_item_layout, parent, false);
            holder = new ViewHolder();
            holder.plotTextView = view.findViewById(R.id.plotTextView);
            holder.plotContainer = view.findViewById(R.id.plotContainer);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        VentureMapActivity.Plot plot = plotList.get(position);
        holder.plotTextView.setText(plot.getName());

        // Set background color based on plot status
        switch (plot.getStatus()) {
            case "green":
                holder.plotContainer.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_light));
                break;
            case "orange":
                holder.plotContainer.setBackgroundColor(context.getResources().getColor(android.R.color.holo_orange_light));
                break;
            case "red":
                holder.plotContainer.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_light));
                break;
        }

        return view;
    }

    private static class ViewHolder {
        TextView plotTextView;
        View plotContainer;
    }
}
