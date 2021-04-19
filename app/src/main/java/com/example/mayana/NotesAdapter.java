package com.example.mayana;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textViewEmployerName.setText(note.getEmployerName());
        holder.textViewEmployerPosition.setText(note.getEmployerPosition());
        holder.textViewEmployerSalary.setText(note.getEmployerSalary());
        holder.textViewPersonalWage.setText(note.getPersonalWage());
        //holder.textViewMonthSalary.setText(note.getMonthSalary());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewEmployerName;
        private TextView textViewEmployerPosition;
        private TextView textViewEmployerSalary;
        private TextView textViewPersonalWage;
        //private TextView textViewMonthSalary;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewEmployerName = itemView.findViewById(R.id.textViewEmployerName);
            textViewEmployerPosition = itemView.findViewById(R.id.textViewEmployerPosition);
            textViewEmployerSalary = itemView.findViewById(R.id.textViewEmployerSalary);
            textViewPersonalWage = itemView.findViewById(R.id.textViewPersonalWage);
            //textViewMonthSalary = itemView.findViewById(R.id.textViewMonthSalary);
        }
    }
}
