package edu.orangecoastcollege.cs273.occcoursefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class CourseSearchActivity extends AppCompatActivity {

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_search);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importCoursesFromCSV("courses.csv");
        db.importInstructorsFromCSV("instructors.csv");
        db.importOfferingsFromCSV("offerings.csv");
        //TODO: Create the method importOfferingsFromCSV, then use it in this activity.

        ArrayList<Course> allCourses = db.getAllCourses();
        Log.i("OCC Course Selector", allCourses.toString());

        ArrayList<Instructor> allInstructors = db.getAllInstructors();
        Log.i("OCC Course Selector", allInstructors.toString());

        ArrayList<Offering> allOfferings = db.getOfferings();
        Log.i("OCC Course Selector", allOfferings.toString());

        //TODO: Get all the offerings from the database, then print them out to the Log


    }
}
