package cecs491a.slider_example;

import android.content.SharedPreferences;
import android.content.Context;
import android.util.Log;

public class UserLocalStore {
/*
    public  static final String SP_NAME = "userDetails";
    private static final String TAG = "SignupActivity";

    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) { //save sliders
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("name", user.name);
        userLocalDatabaseEditor.putString("username", user.username);
        userLocalDatabaseEditor.putString("password", user.password);
        userLocalDatabaseEditor.putString("birthdate", user.birthdate);
        userLocalDatabaseEditor.putInt("personalSlider1", user.personalSex.min);
        userLocalDatabaseEditor.putInt("personalSlider2", user.personalOri.min);
        userLocalDatabaseEditor.putInt("personalSlider3", user.personalGender.min);
        userLocalDatabaseEditor.putInt("preferedSlider1a", user.preferedSex.min);
        userLocalDatabaseEditor.putInt("preferedSlider1b", user.preferedSex.max);
        userLocalDatabaseEditor.putInt("preferedSlider2a", user.preferedOri.min);
        userLocalDatabaseEditor.putInt("preferedSlider2b", user.preferedOri.max);
        userLocalDatabaseEditor.putInt("preferedSlider3a", user.preferedGender.min);
        userLocalDatabaseEditor.putInt("preferedSlider3b", user.preferedGender.max);
        Log.d(TAG, "Signup2");
        userLocalDatabaseEditor.commit(); //save changes
        Log.d(TAG, "Signup2");
    }

    //User(String name, int age, String username, String password)
    public User getUserData(){
        User retVal = new User(
                userLocalDatabase.getString("name", " "),
                userLocalDatabase.getString("birthdate", ""), //-1 is value to return if it does not exist.
                userLocalDatabase.getString("username", " "),
                userLocalDatabase.getString("password", " ")); //returns blank if does not exist

        //setPersonal(Slider sex, Slider orientation, Slider gender)
        //SliderValue(int min, int max);
        retVal.setPersonal(
                new SliderValue(userLocalDatabase.getInt("personalSlider1", -1)),
                new SliderValue(userLocalDatabase.getInt("personalSlider2", -1)),
                new SliderValue(userLocalDatabase.getInt("personalSlider3", -1)));

        //setPrefered(Slider sex, Slider orientation, Slider gender)
        retVal.setPrefered(
                new SliderValue(userLocalDatabase.getInt("preferedSlider1a", -1), userLocalDatabase.getInt("preferedSlider1b", -1)),
                new SliderValue(userLocalDatabase.getInt("preferedSlider2a", -1), userLocalDatabase.getInt("preferedSlider2b", -1)),
                new SliderValue(userLocalDatabase.getInt("preferedSlider3a", -1), userLocalDatabase.getInt("preferedSlider3b", -1)));
        return retVal; //have check if retVal name is " " then error or noone logged on.
    }
  */

    /*
    public void setPersonal(Slider gender, Slider expression, Slider orientation){

    }

    SliderValue(min, max){

    }
    * */
}