package com.example.quizmcq;

public class DataModelMCQ {
    String answerOption;
    Boolean isSelected;

    public DataModelMCQ(String answerOption, Boolean isSelected) {
        this.answerOption = answerOption;
        this.isSelected = isSelected;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }
}

