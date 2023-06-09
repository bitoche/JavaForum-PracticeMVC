package com.example.forumjavatrue.Repository;

import com.example.forumjavatrue.Models.Message;
import com.example.forumjavatrue.Models.Thread;
import com.example.forumjavatrue.Models.User;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ThreadRepository implements IThreadRepository{
    private String FILE_PATH = "./src/main/resources/files/Threads.csv"; //C:\Users\Geome\IdeaProjects\ForumJavaTrue\src\main\resources\files\Threads.csv
    @Override
    public void Add(Thread thread) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, true));
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;
            long lastId = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                lastId = Long.parseLong(nextRecord[0]);
            }
            thread.setID(lastId + 1);
            csvReader.close();
            String[] record = { // порядок записи ID,Title,Desc
                    String.valueOf(thread.getID()),
                    thread.getTitle(),
                    thread.getDescription()
            };
            writer.writeNext(record);
            System.out.println("log// Успешно сохранен в файл Thread[id = " + thread.getID() + ", Title = " + thread.getTitle() + ", Desc = " + thread.getDescription() + "]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void DeleteByID(long id){
        List<Thread> threads = GetAll();
        Thread threadToRemove = null;
        for (Thread thread : threads) {
            if (thread.getID() == id) {
                threadToRemove = thread;
                break;
            }
        }
        if (threadToRemove != null) {
            threads.remove(threadToRemove);
            try {
                // Открываем файл на запись
                CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, false));
                writer.writeNext(new String[]{"ID","Title","Desc"});
                // Записываем данные все треды, кроме удаленного
                for (Thread thread : threads) {
                    String[] record = {
                            String.valueOf(thread.getID()),
                            thread.getTitle(),
                            thread.getDescription(),
                    };
                    writer.writeNext(record);
                }

                // Закрываем файл
                writer.close();
                System.out.println("log//<ThreadRepos> Успешно удален Thread: ID=" + id);
            } catch (IOException e) {
                System.err.println("Ошибка сохранения файла: " + e.getMessage());
            }
        }
        else System.out.println("log//<ThreadRepos> Не найден Thread: ID=" + id);
    }

    @Override
    public Thread GetByID(long id) {
        try {
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                long currentId = Long.parseLong(record[0]);
                if (currentId == id) { // порядок записи: Id,Title,Desc
                    int ID = Integer.parseInt(record[0]);
                    String title = record[1];
                    String desc = record[2];
                    Thread thread = new Thread(ID, title, desc);
                    thread.setID(currentId);
                    csvReader.close();
                    System.out.println("log//<ThreadRepos> Успешно получен из файла Thread[id = " + ID + ", Title = " + title + ", Desc = " + desc + "]");
                    return thread;
                }
            }

            csvReader.close();
            return null;
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return null;
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Thread> GetAll() {
        List<Thread> threads = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) { // порядок записи: Id, Title, Desc
                long currentId = Long.parseLong(record[0]);
                String title = record[1];
                String description = record[2];
                Thread thread = new Thread(currentId, title, description);
                threads.add(thread);
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return threads;
    }

}
