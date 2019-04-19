
package Process;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadWrite {
    
    private BufferedWriter writeOut;
    
    public void writeFile(double[][] value, int rows, int cols){
        String txt = "";
        String index = rows + "|" + cols;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                txt += value[i][j];
                if(j<cols-1)
                    txt+=",";
            }
            txt += "\n";
        }
        
        try {
            writeOut = new BufferedWriter(new FileWriter("log\\save.txt"));
            writeOut.write(txt);
            writeOut.close();
            
            writeOut = new BufferedWriter(new FileWriter("log\\index.txt"));
            writeOut.write(index);
            writeOut.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    public void writeFile1(double[][] value, int rows, int cols) throws IOException{
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < rows; i++){
           for(int j = 0; j < cols; j++){
              builder.append(value[i][j]+"");//append to the output string
              if(j < cols - 1)//if this is not the last row element
                 builder.append(",");//then add comma (if you don't like commas you can use spaces)
           }
           builder.append("\n");//append new line at the end of the row
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("log\\save.txt"));
        writer.write(builder.toString());//save the string representation of the board
        writer.close();
    }
    
    public Point readIndex(){
        Point point = new Point();
        LinkedList<String> list = new LinkedList<String>();
        StringTokenizer stringToken;
        Scanner sc = null;
        String input = "";
        try {
            sc = new Scanner(new File("log\\index.txt"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        sc.useDelimiter("");
        while (sc.hasNext()) {
            input += sc.next();
            if (input.trim().isEmpty()) {
                continue;
            }
        }
        sc.close();
        
        stringToken = new StringTokenizer(input,"|");
        while (stringToken.hasMoreElements()){
            String token = stringToken.nextToken();
            list.add(token);
        }
        
        point.x = Integer.parseInt(list.get(0));
        point.y = Integer.parseInt(list.get(1));
        return point;
    }
    
    public double[][] getArray() throws FileNotFoundException, IOException{
        Point point = readIndex();
        int rows = point.x;
        int cols = point.y;
        
        double[][] data = new double[rows][cols];
        BufferedReader reader = new BufferedReader(new FileReader("log\\save.txt"));
        String line = "";
        int row = 0;
        while((line = reader.readLine()) != null){
           String[] colss = line.split(",");
           int col = 0;
           for(String  c : colss)
           {
              data[row][col] = Float.parseFloat(c);
              col++;
           }
           row++;
        }
        reader.close();
        
        return data;
    }
    
    public void writeList(LinkedList<Object> listFiles, String name) {
        String pathOutput = "log\\";
        File dir = new File(pathOutput);
        
        try {
            String file = "";
            for (Object i : listFiles) {
                file += (String)i + "|";
            }
            writeOut = new BufferedWriter(new FileWriter(pathOutput + name));
            writeOut.write(file);
            writeOut.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    public LinkedList<Object> readList(String name){
        LinkedList<Object> list = new LinkedList<>();
        StringTokenizer stringToken;
        Scanner sc = null;
        String input = "";
        try {
            sc = new Scanner(new File("log\\"+name+".txt"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        sc.useDelimiter("");
        while (sc.hasNext()) {
            input += sc.next();
            if (input.trim().isEmpty()) {
                continue;
            }
        }
        sc.close();
        
        stringToken = new StringTokenizer(input,"|");
        while (stringToken.hasMoreElements()){
            String token = stringToken.nextToken();
            list.add((Object)token);
        }
        
        return list;
    }
}
