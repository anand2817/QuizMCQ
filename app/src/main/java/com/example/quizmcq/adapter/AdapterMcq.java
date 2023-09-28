package com.example.quizmcq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmcq.DataModelMCQ;
import com.example.quizmcq.R;

import java.util.List;
import java.util.function.UnaryOperator;

public class AdapterMcq extends RecyclerView.Adapter<AdapterMcq.McqViewHolder> {

    Context context;
    List<DataModelMCQ> tempDataModelMCQList;
    int listPosition;
    List<DataModelMCQ> dataModelMCQList;
    OptionClick optionClick;

    interface OptionClick{
        void optionClick(int selectQuestion , int selectOption);
    }
    void setOnInterface(OptionClick optionClick){
        this.optionClick = optionClick;
    }

    public AdapterMcq(Context context, List<DataModelMCQ> tempDataModelMCQList,List<DataModelMCQ> dataModelMCQList,int listPosition) {
        this.context = context;
        this.tempDataModelMCQList = tempDataModelMCQList;
        this.listPosition = listPosition;
        this.dataModelMCQList = dataModelMCQList;
    }

    @NonNull
    @Override
    public McqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_mcq,parent,false);
        return new McqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull McqViewHolder holder, int position) {
        holder.tvOption.setText(tempDataModelMCQList.get(position).getAnswerOption());
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataModelMCQList.get(position).getIsSelected()){
                    dataModelMCQList.get(position).setIsSelected(false);
                }else {
                    dataModelMCQList.get(position).setIsSelected(true);
                }
                optionClick.optionClick(listPosition,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tempDataModelMCQList.size();
    }

    class McqViewHolder extends RecyclerView.ViewHolder {
        TextView tvOption;
        RadioButton radioButton;
        public McqViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOption = itemView.findViewById(R.id.tvOption);
            radioButton = itemView.findViewById(R.id.radioButton);
        }
    }
}
