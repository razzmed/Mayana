package com.example.mayana;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<Note> notes;
    private Context context;


    public NotesAdapter(ArrayList<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_item, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NotesViewHolder holder, final int position) {
        final Note note = notes.get(position);
        holder.textViewEmployerName.setText(note.getEmployerName());
        holder.textViewEmployerPosition.setText(note.getEmployerPosition());
        holder.textViewEmployerSalary.setText(note.getEmployerSalary());
        holder.textViewBonus.setText(note.getBonus());
        holder.textViewPersonalWage.setText(note.getPersonalWage());
        holder.textViewMonthSalary.setText(note.getMonthSalary());
        holder.textViewOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final PopupMenu popupMenu = new PopupMenu(context, holder.textViewOptionDigit);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.menu_item_send:
                                Intent intent2 = new Intent(context, SendInfoActivity.class);
                                intent2.putExtra("key", note);
                                view.getContext().startActivity(intent2);
                                Toast.makeText(context, "Подготовка к отправке", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_item_edit:
                                Intent intent = new Intent(context, AddNoteActivity.class);
                                intent.putExtra("note", note);
                                view.getContext().startActivity(intent);
                                Toast.makeText(context, "Редактирование разрешено", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_item_delete:
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setMessage("Удалить?").setNegativeButton("Нет", null)
                                        .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                App.getInstance().getDatabase().notesDao().deleteById(note.getId());
                                                Toast.makeText(context, "Удалено", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                builder.show();
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
        private TextView textViewBonus;
        private TextView textViewPersonalWage;
        private TextView textViewMonthSalary;
        private TextView textViewOptionDigit;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewEmployerName = itemView.findViewById(R.id.textViewEmployerName);
            textViewEmployerPosition = itemView.findViewById(R.id.textViewEmployerPosition);
            textViewEmployerSalary = itemView.findViewById(R.id.textViewEmployerSalary);
            textViewBonus = itemView.findViewById(R.id.textViewEmployerBonus);
            textViewPersonalWage = itemView.findViewById(R.id.textViewPersonalWage);
            textViewMonthSalary = itemView.findViewById(R.id.textViewMonthSalary);
            textViewOptionDigit = itemView.findViewById(R.id.textViewOptionDigit);
        }
    }
}
