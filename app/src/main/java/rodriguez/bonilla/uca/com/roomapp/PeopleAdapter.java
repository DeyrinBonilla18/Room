package rodriguez.bonilla.uca.com.roomapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rodriguez.bonilla.uca.com.roomapp.models.People;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    List<People> peopleList;

    public PeopleAdapter(List<People> peopleList) {this.peopleList = peopleList; }

    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleAdapter.ViewHolder holder, int position) {
        holder.name.setText(peopleList.get(position).getName());
        holder.gender.setText(peopleList.get(position).getGender());
        holder.preferencia.setText(peopleList.get(position).getPreferencia());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView gender;
        public TextView preferencia;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            gender = itemView.findViewById(R.id.gender);
            preferencia = itemView.findViewById(R.id.preferencia);
        }
    }

}
