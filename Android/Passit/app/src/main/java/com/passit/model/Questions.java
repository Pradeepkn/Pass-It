package com.passit.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by muthukrishnan on 23/05/15.
 */
public class Questions implements Serializable{

    public int id;

    public String question;

    public ArrayList<String> choice;

    public int selectedChoice = -1;

    public String selectedValue;
}
