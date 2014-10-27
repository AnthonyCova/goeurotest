package com.acova.goeurotest;

import au.com.bytecode.opencsv.CSVWriter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Anthony
 */
public class JsonToCsv {

    public static final String API = "http://api.goeuro.com/api/v2/position/suggest/en/";

    /**
     * Create a CSV file given the endpoint
     * <p>
     * This method create a .csv in the folder where is the jar executed. In
     * case of error the .csv wont be created
     *
     * @param endpoint an absolute URL giving the base location of the API
     */
    public static void getCsv(String endpoint) {
        String json = "";
        try {
            json = readUrl(API + endpoint);
            writeCsv(getData(json));
        } catch (Exception ex) {
            System.out.println("Can't connect to API http://api.goeuro.com/api/v2/position/suggest/en/");
        }

    }

    /**
     * Get json from the URL API
     * <p>
     * This method return content in json from the API
     *
     * @param urlString an absolute URL giving the base location of the API
     */
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Get Data of the json API
     * <p>
     * This method return a ArrayList of the content in json
     *
     * @param json json with a format of data.class
     */
    private static ArrayList<Data> getData(String json) {
        ArrayList<Data> data = new ArrayList<>();
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();
        for (JsonElement obj : jArray) {
            Data cse = gson.fromJson(obj, Data.class);
            data.add(cse);
        }
        return data;

    }

    /**
     * Write into a .csv with the format _id,name,type,latitude,longitude
     * <p>
     *
     * @param data a Array of the parse data to be write in the csv
     */
    private static void writeCsv(ArrayList<Data> data) {
        String outputFile = "goeurotest.csv";
        if (data.size() > 0) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile), ',')) {
                for (int i = 0; i < data.size(); i++) {
                    String[] geo = {data.get(i).getId().toString(), data.get(i).getName(), data.get(i).getType(), data.get(i).getGeo_position().getLatitude(), data.get(i).getGeo_position().getLongitude()};
                    writer.writeNext(geo);
                }
            } catch (IOException e) {
                System.out.println("Error: Can't create csv file. Please check all the permition " + e.getMessage());
            }
        }
    }

}
