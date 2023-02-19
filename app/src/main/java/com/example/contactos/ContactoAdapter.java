package com.example.contactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    ArrayList<Contacto> contactos;

    public ContactoAdapter (ArrayList contactos){
        this.contactos=contactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contactos, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto= contactos.get(position);
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.imgFoto.setImageResource(contacto.getFoto());

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageView imgFoto;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto= (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV= (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV= (TextView) itemView.findViewById(R.id.tvTelefonoCV);
        }
    }
}
