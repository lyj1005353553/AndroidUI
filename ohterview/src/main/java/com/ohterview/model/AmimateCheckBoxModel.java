package com.ohterview.model;

public class AmimateCheckBoxModel {
    private String content;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AmimateCheckBoxModel() {
    }

    public AmimateCheckBoxModel(String content, boolean isChecked) {
        this.content = content;
        this.isChecked = isChecked;
    }
}
