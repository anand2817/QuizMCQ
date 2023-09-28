package com.example.quizmcq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizmcq.adapter.AdapterQuestion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<DataModelQuestion> dataModelQuestionList;
    List<DataModelMCQ> dataModelMCQList;
    RecyclerView recyclerViewQuestion;
    AdapterQuestion adapterQuestion;
    Button btnNext,btnSkip,btnBack;
    int countQuestion = 0;
    Boolean checkFirstQuestion = false;
    Boolean checkSelectOption = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewQuestion = findViewById(R.id.recyclerView);
        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setVisibility(View.GONE);
        dataModelQuestionList = new ArrayList<>();
        dataModelMCQList = new ArrayList<>();
        dataModelMCQList.add(new DataModelMCQ("First",false));
        dataModelMCQList.add(new DataModelMCQ("second",false));
        dataModelMCQList.add(new DataModelMCQ("third",false));
        dataModelMCQList.add(new DataModelMCQ("fourth",false));
        dataModelQuestionList.add(new DataModelQuestion("my question",dataModelMCQList,"First"));
        dataModelMCQList = new ArrayList<>();
        dataModelMCQList.add(new DataModelMCQ("First1",false));
        dataModelMCQList.add(new DataModelMCQ("second2",false));
        dataModelMCQList.add(new DataModelMCQ("third3",false));
        dataModelMCQList.add(new DataModelMCQ("fourth4",false));
        dataModelQuestionList.add(new DataModelQuestion("my question 2",dataModelMCQList,"First1"));
        dataModelMCQList = new ArrayList<>();
        dataModelMCQList.add(new DataModelMCQ("First5",false));
        dataModelMCQList.add(new DataModelMCQ("second6",false));
        dataModelMCQList.add(new DataModelMCQ("third7",false));
        dataModelMCQList.add(new DataModelMCQ("fourth8",false));
        dataModelQuestionList.add(new DataModelQuestion("my question 3",dataModelMCQList,"First5"));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelectOption == true){
                    if (countQuestion<dataModelQuestionList.size()-1){
                        setList(1);
                    }
                    if(countQuestion == dataModelQuestionList.size()-2){
                        for (int i=0; i<dataModelQuestionList.size();i++){
                            String rightAnswer = dataModelQuestionList.get(i).rightAnswer;
                            for (int j=0; j<dataModelQuestionList.get(i).getDataModelMCQList().size();j++){
                                if ()
                                if (rightAnswer.equals())
                                    dataModelQuestionList.get(i).getDataModelMCQList().get(j).getIsSelected();
                                }
                            }
                        }
                    }
                    else {

                    }
                    checkSelectOption = false;
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countQuestion == 1){
                    btnBack.setVisibility(View.GONE);
                    setList(-1);
                }
                else {
                    setList(-1);
                }
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countQuestion != dataModelQuestionList.size()-1){
                    setList(1);
                }
            }
        });
        if (checkFirstQuestion == false){
            btnNext.setVisibility(View.VISIBLE);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false) {
                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            List<DataModelQuestion> tempDataModelQuestionList;
            tempDataModelQuestionList = new ArrayList<>();
            tempDataModelQuestionList.add(dataModelQuestionList.get(0));
            recyclerViewQuestion.setLayoutManager(layoutManager);
            adapterQuestion = new AdapterQuestion(MainActivity.this,tempDataModelQuestionList,dataModelQuestionList,0);
            recyclerViewQuestion.setAdapter(adapterQuestion);
            optionClick();
        }
    }
    void setList(int plusOrMinus){
        if (countQuestion<dataModelQuestionList.size()){
            if (plusOrMinus == 1){
                countQuestion++;
                btnBack.setVisibility(View.VISIBLE);
            }
            else {
                countQuestion--;
            }
            checkFirstQuestion = true;
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false) {
                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            List<DataModelQuestion> tempDataModelQuestionList;
            tempDataModelQuestionList = new ArrayList<>();
            tempDataModelQuestionList.add(dataModelQuestionList.get(countQuestion));
            recyclerViewQuestion.setLayoutManager(layoutManager);
            adapterQuestion = new AdapterQuestion(MainActivity.this,tempDataModelQuestionList,dataModelQuestionList,countQuestion);
            recyclerViewQuestion.setAdapter(adapterQuestion);
            optionClick();
        }
    }
    void optionClick(){
        adapterQuestion.setOnInterfaceOption(new AdapterQuestion.OptionSelect() {
            @Override
            public void optionSelect(int selectQuestion, int selectOption) {
                checkSelectOption = true;
//                Toast.makeText(MainActivity.this, String.valueOf(selectQuestion), Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, String.valueOf(selectOption), Toast.LENGTH_SHORT).show();
            }
        });
    }
}