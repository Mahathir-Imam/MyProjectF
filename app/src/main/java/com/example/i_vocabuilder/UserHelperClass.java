package com.example.i_vocabuilder;

import android.widget.EditText;

public class UserHelperClass {

    String word,meaning,explanation;

    public UserHelperClass() {

    }

    public UserHelperClass(String word, String meaning, String explanation) {
        this.word = word;
        this.meaning = meaning;
        this.explanation = explanation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
