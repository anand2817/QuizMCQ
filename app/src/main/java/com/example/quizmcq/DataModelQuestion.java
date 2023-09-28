package com.example.quizmcq;

import java.util.List;

public class DataModelQuestion {
    String question;
    List<DataModelMCQ> dataModelMCQList;
    String rightAnswer;

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public DataModelQuestion(String question, List<DataModelMCQ> dataModelMCQList, String rightAnswer) {
        this.question = question;
        this.dataModelMCQList = dataModelMCQList;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<DataModelMCQ> getDataModelMCQList() {
        return dataModelMCQList;
    }

    public void setDataModelMCQList(List<DataModelMCQ> dataModelMCQList) {
        this.dataModelMCQList = dataModelMCQList;
    }
}
