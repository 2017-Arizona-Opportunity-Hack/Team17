package com.jaaz.android;

import java.util.ArrayList;

/**
 * Created by matth on 10/22/2017.
 */
//class to intake position data
public class Position {
    String address = null; //street address of school
    String city = null; //city of school
    String county = null; //county of school
    Long fr_15_16; //federal register (under 50% is underfunded)
    Long fr_16_17; //federal register (under 50% is underfunded)
    Long fr_17; //federal register (under 50% is underfunded)
    boolean district_saz = false; //
    boolean title_1 = false; //does schoool fall under title 1?
    boolean district_caz = false;
    String name = null; //name of school
    String district = null; //district of school (plus private vs. public)
    Long zip; //zip code of school
    ArrayList<Boolean> type; //array of 3 booleans: are there volunteer positions in: [elementary school, middle school, high school]
    String model = null; //educational model for the school
    String dateTime = null; //date/time of volunteer position (currently not implemented)
}
