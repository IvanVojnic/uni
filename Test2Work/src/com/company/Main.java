package com.company;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Collections;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static class Hotel implements Comparable<Hotel>{
        String CityName;
        String HotelName;
        int StarsCount;
        String GetCityName(){
            return this.CityName;
        }
        int GetStarsCount(){
            return this.StarsCount;
        }
        void GetHotelInfo(){
            System.out.println("in " + this.CityName + ", Hotel name - " + this.HotelName + ". stars count - " + this.StarsCount);
        }
        Hotel(String CityName, String HotelName, int StarsCount){
            this.CityName = CityName;
            this.HotelName = HotelName;
            this.StarsCount = StarsCount;
        }
        void print(){
            System.out.println("City name - " + this.CityName + ". Hotel name - " + this.HotelName + ". stars count - " + this.StarsCount);
        }

        @Override
        public int compareTo(Hotel o) {
            if(this.CityName.compareTo(o.GetCityName()) == 0){
                if(this.StarsCount < o.GetStarsCount()){
                    return -1;
                }
                else {
                    return 1;
                }
            }
            else {
                return this.CityName.compareTo(o.GetCityName());
            }
        }
    }
    public static void main(String[] args) {
        try {
            File myObj = new File("hotel.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                System.out.println(myReader.next());
            }
            myReader.close();
            System.out.println("-----------------------------------------------------------------");
            myReader = new Scanner(myObj);
            ArrayList<Hotel> hotelCity = new ArrayList<>();
            while (myReader.hasNext()) {
                String city = myReader.next();
                String hotel = myReader.next();
                int stars = Integer.parseInt(myReader.next());
                Hotel obj = new Hotel(city, hotel, stars);
                hotelCity.add(obj);
            }
            myReader.close();
            sortMyList(hotelCity);
            Scanner in = new Scanner(System.in);
            System.out.print("Input city name: ");
            String str = in.nextLine();
            System.out.println("------------------------------------------");
            getInfoCitiesHotels(str, hotelCity);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void sortMyList(ArrayList<Hotel> hotelCity) {
        Collections.sort(hotelCity);
        for(int i = 0 ; i < hotelCity.size(); i++){
            hotelCity.get(i).print();
        }
    }
    private static void getInfoCitiesHotels(String str, ArrayList<Hotel> hotelCity){
        int index = -1;
        int low = 0;
        int high = hotelCity.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (hotelCity.get(mid).GetCityName().compareTo(str) < 0) {
                low = mid + 1;
            } else if (hotelCity.get(mid).GetCityName().compareTo(str) > 0) {
                high = mid - 1;
            } else if (hotelCity.get(mid).GetCityName().compareTo(str) == 0) {
                index = mid;
                break;
            }
        }
        int i = index+1;
        while (i < hotelCity.size() && hotelCity.get(i).GetCityName().compareTo(str) == 0){
            hotelCity.get(i).GetHotelInfo();
            i++;
        }
        while (i > hotelCity.size() && hotelCity.get(i).GetCityName().compareTo(str) == 0){
            hotelCity.get(i).GetHotelInfo();
            i--;
        }
        hotelCity.get(index).GetHotelInfo();
        if (index == -1){
            System.out.println("no info");
        }
    }
}
