package com.passit.util;

import android.content.res.AssetManager;
import android.util.Log;

import com.passit.PassitApplication;
import com.passit.model.Questions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by muthukrishnan on 23/05/15.
 */
public class TempQuestionUtil {

    public static ArrayList<Questions> getQuestions() {
        ArrayList<Questions> questionses = new ArrayList<Questions>();

        String value = readFileFromAssert("snippet.rtf");

        try {
            JSONObject jsonObject = new JSONObject(value);

            JSONObject questionResponse = jsonObject.optJSONObject("question_response");

            JSONArray question = questionResponse.optJSONArray("qustions");

            if(question != null) {
                for (int i = 0; i < question.length(); i++) {
                    JSONObject object = question.optJSONObject(i);

                    if (object == null) {
                        continue;
                    }

                    Questions questions = new Questions();

                    questions.id = i;

                    questions.question = object.optString("question");

                    JSONObject answer = object.optJSONObject("answers");

                    ArrayList<String> choices = new ArrayList<String>();
                    choices.add(answer.optString("1"));
                    choices.add(answer.optString("2"));
                    choices.add(answer.optString("3"));
                    choices.add(answer.optString("4"));
                    questions.choice = choices;

                    questionses.add(questions);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return questionses;
    }

    public static String readFileFromAssert(String filename) {

        StringBuilder text = new StringBuilder();

        try {
            AssetManager am = PassitApplication.getApplication().getAssets();
            InputStream is = am.open(filename);

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text.toString();
    }
}
