package com.example.forumjavatrue.Repository;

import com.example.forumjavatrue.Models.User;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    private String FILE_PATH = "C:\\Users\\Geome\\IdeaProjects\\ForumJavaTrue\\src\\main\\resources\\files\\Users.csv";

    /*public long getNextUserId() {
        long lastUserId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            // Пропускаем первую строку, содержащую заголовки столбцов
            String headerLine = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                long userId = Long.parseLong(values[0]);
                if (userId > lastUserId) {
                    lastUserId = userId;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastUserId + 1;
    }*/
    @Override
    public void AddUser(User user) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, true));
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;
            long lastId = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                lastId = Long.parseLong(nextRecord[0]);
            }
            user.setID(lastId + 1);
            csvReader.close();
            String[] record = {
                    String.valueOf(user.getID()),
                    user.getUsername(),
                    user.getLogin(),
                    DateHelper.DoFormat(user.getRegisterDate()), // в datehelper предусмотрен null
                    String.valueOf(user.getMessageCounter()),
                    user.getPassword()
            };
            writer.writeNext(record);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User GetByID(long id) {
        try {
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                long currentId = Long.parseLong(record[0]);
                if (currentId == id) {
                    String username = record[1];
                    String login = record[2];
                    Date registerDate = DateHelper.UnFormat(record[3]);
                    int messageCounter = Integer.parseInt(record[4]);
                    String password = record[5];
                    User user = new User(currentId, username, login, registerDate, messageCounter, password);
                    csvReader.close();
                    return user;
                }
            }

            csvReader.close();
            return null;
        } catch (IOException | CsvValidationException | ParseException e) {
            e.printStackTrace();
            return null;
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User GetByUsername(String username) {
        try {
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                String currentUsername = record[1];
                if (currentUsername == username) {
                    long id = Long.parseLong(record[1]);
                    String login = record[2];
                    Date registerDate = DateHelper.UnFormat(record[3]);
                    int messageCounter = Integer.parseInt(record[4]);
                    String password = record[5];
                    User user = new User(id, username, login, registerDate, messageCounter, password);
                    csvReader.close();
                    return user;
                }
            }

            csvReader.close();
            return null;
        } catch (IOException | CsvValidationException | ParseException e) {
            e.printStackTrace();
            return null;
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> GetAll() {
        List<User> users = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                long currentId = Long.parseLong(record[0]);
                String Username = record[1];
                String Login = record[2];
                Date RegisterDate = null;
                if (!record[3].isEmpty()) {
                    RegisterDate = DateHelper.UnFormat(record[3]);
                }
                int MessageCounter = Integer.parseInt(record[4]);
                String password = record[5];
                User user = new User(currentId, Username, Login, RegisterDate, MessageCounter, password);
                user.setID(currentId);
                users.add(user);
            }

            csvReader.close();
        } catch (IOException | CsvValidationException | ParseException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
