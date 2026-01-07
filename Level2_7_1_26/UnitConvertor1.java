package Level2_07_01_26;

public class UnitConvertor1 {

    // Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Convert miles to kilometers
    public static double convertMilesToKilometers(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
}

//Problem 4

//Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods. E.g.
//public static double convertKmToMiles(double km) =>
//Method To convert kilometers to miles and return the value. Use the following code  double km2miles = 0.621371;
//Method to convert miles to kilometers and return the value. Use the following code  double miles2km = 1.60934;
//Method to convert meters to feet and return the value. Use the following code to convert  double meters2feet = 3.28084;
//Method to convert feet to meters and return the value. Use the following code to convert  double feet2meters = 0.3048;