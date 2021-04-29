package com.company;

import com.google.gson.*;

import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        FileReader reader=null;
        try {
            reader=new FileReader("src/com/company/benebes.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson=new Gson();

        TaskList person2=gson.fromJson(reader, TaskList.class);
        System.out.println(person2.getClass());
        System.out.println(person2);

        try {
            FileWriter writer= new FileWriter("src/com/company/bonobos.json");
            gson.toJson(person2, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
class Task{
    String body;
    boolean done;
    int id;
    int priority;
    String title;

    @Override
    public String toString() {
        return "Task{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}
class TaskList{
    Task[] todos;

    @Override
    public String toString() {
        return "TaskList{" +
                "todos=" + Arrays.toString(todos) +
                '}';
    }
}
