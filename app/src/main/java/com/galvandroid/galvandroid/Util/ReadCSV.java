package com.galvandroid.galvandroid.Util;

import android.content.Context;

import com.galvandroid.galvandroid.Chemistry.Atom;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadCSV {
    public static HashMap<String, Atom> getArray(Context context) {
        //return read(valueOf(context.getAssets().open("product_price_guide.csv")), "*");
        return read("element_list", ",", context);
    }

    public static HashMap<String, Atom> read(String fileName, String csvSplitBy, Context context) {
        HashMap<String, Atom> list = new HashMap<>();

        InputStream ins = context.getResources().openRawResource(
                context.getResources().getIdentifier(fileName,
                        "raw", context.getPackageName()));
        String file = readTextFile(ins);
        BufferedReader rdr = new BufferedReader(new StringReader(file));
        List<String> lines = new ArrayList<>();
        try {
            for (String line = rdr.readLine(); line != null; line = rdr.readLine()) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rdr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            String[] values = line.split(csvSplitBy);
            Atom t = new Atom(Integer.parseInt(values[0]), values[1], values[2]);
            list.put(values[1], t);
        }

        return list;
    }

    public static String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toString();
    }
}
