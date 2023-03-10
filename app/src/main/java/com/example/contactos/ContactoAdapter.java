package com.example.contactos;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdapter (ArrayList contactos, Activity activity){
        this.contactos=contactos;
        this.activity=activity;
    }


    @Override
    public ContactoViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contactos, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ContactoViewHolder holder, int position) {
        final Contacto contacto= contactos.get(position);
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.imgFoto.setImageResource(contacto.getFoto());

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, Detalle.class);

                intent.putExtra("nombre" , contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageView imgFoto;

        public ContactoViewHolder( View v) {
            super(v);
            imgFoto= (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV= (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV= (TextView) itemView.findViewById(R.id.tvTelefonoCV);
        }
    }
}
