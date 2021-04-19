package com.example.mayana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private ArrayList<Note> notes;
    private Context context;

    public NotesAdapter(ArrayList<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NotesViewHolder holder, final int position) {
        Note note = notes.get(position);
        holder.textViewEmployerName.setText(note.getEmployerName());
        holder.textViewEmployerPosition.setText(note.getEmployerPosition());
        holder.textViewEmployerSalary.setText(note.getEmployerSalary());
        holder.textViewPersonalWage.setText(note.getPersonalWage());
        holder.textViewMonthSalary.setText(note.getMonthSalary());
        holder.textViewOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, holder.textViewOptionDigit);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu_item_send:
                                Toast.makeText(context, "Отправлено", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_item_edit:
                                Toast.makeText(context, "Редактирование завершено", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_item_delete:
                                notes.remove(position);
                                notifyDataSetChanged();
                                Toast.makeText(context, "Удалено", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
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
        private TextView textViewMonthSalary;
        private TextView textViewOptionDigit;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewEmployerName = itemView.findViewById(R.id.textViewEmployerName);
            textViewEmployerPosition = itemView.findViewById(R.id.textViewEmployerPosition);
            textViewEmployerSalary = itemView.findViewById(R.id.textViewEmployerSalary);
            textViewPersonalWage = itemView.findViewById(R.id.textViewPersonalWage);
            textViewMonthSalary = itemView.findViewById(R.id.textViewMonthSalary);
            textViewOptionDigit = itemView.findViewById(R.id.textViewOptionDigit);
        }
    }
}
