package com.example.sosmobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final Context context;
    private final List<ContactModel> contactModelArrayList;

    // Constructor
    public ContactAdapter(Context context, List<ContactModel> contactModelArrayList) {
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView phoneNumber;
        private final ImageView deleteImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.phoneNumber = itemView.findViewById(R.id.deleteImage);
            this.deleteImage = itemView.findViewById(R.id.contactPhone);
        }
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
    ContactModel model=contactModelArrayList.get(position);
    holder.phoneNumber.setText(model.getPhone());
    holder.deleteImage.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }
}
