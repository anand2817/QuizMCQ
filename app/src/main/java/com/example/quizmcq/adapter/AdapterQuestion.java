package com.example.quizmcq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmcq.DataModelQuestion;
import com.example.quizmcq.R;

import java.util.List;

public class AdapterQuestion extends RecyclerView.Adapter<AdapterQuestion.QuestionViewHolder> {
    List<DataModelQuestion> tempDataModelQuestionList;
    Context context;
    int listPosition;
    List<DataModelQuestion> dataModelQuestionList;
    OptionSelect optionSelect;

    public interface OptionSelect{
        void optionSelect(int selectQuestion,int selectOption);
    }
    public void setOnInterfaceOption(OptionSelect optionSelect){
        this.optionSelect = optionSelect;
    }
    public AdapterQuestion(Context context,List<DataModelQuestion> tempDataModelQuestionList,List<DataModelQuestion> dataModelQuestionList,int listPosition) {
        this.tempDataModelQuestionList = tempDataModelQuestionList;
        this.context = context;
        this.listPosition = listPosition;
        this.dataModelQuestionList = dataModelQuestionList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_question,parent,false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.tvID.setText(String.valueOf(listPosition+1)+" )");
        holder.tvQuestion.setText(tempDataModelQuestionList.get(position).getQuestion());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(layoutManager);
        AdapterMcq adapterMcq = new AdapterMcq(context,tempDataModelQuestionList.get(position).getDataModelMCQList(),dataModelQuestionList.get(listPosition).getDataModelMCQList(),listPosition);
        holder.recyclerView.setAdapter(adapterMcq);
        adapterMcq.setOnInterface(new AdapterMcq.OptionClick() {
            @Override
            public void optionClick(int selectQuestion, int selectOption) {
                optionSelect.optionSelect(selectQuestion,selectOption);
            }
        });
    }
    @Override
    public int getItemCount() {
        return tempDataModelQuestionList.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView tvID,tvQuestion;
        RecyclerView recyclerView;
        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            recyclerView = itemView.findViewById(R.id.recyclerViewMCQ);
        }
    }
}
