package com.example.forumjavatrue.Repository;

import com.example.forumjavatrue.Models.Message;
import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Models.Thread;

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
import java.util.Date;
import java.util.List;

@Repository
public class MessageRepository implements IMessageRepository {
    private String FILE_PATH = "./src/main/resources/files/Messages.csv"; //C:\Users\Geome\IdeaProjects\ForumJavaTrue\src\main\resources\files\Messages.csv
    private IUserRepository userRepository;
    private IThreadRepository threadRepository;
    public MessageRepository(IUserRepository userRepository, IThreadRepository threadRepository){
        this.userRepository = userRepository;
        this.threadRepository = threadRepository;
    }

    @Override
    public void Add(Message message) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, true));
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;
            long lastId = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                lastId = Long.parseLong(nextRecord[0]);
            }
            message.setID(lastId + 1);
            csvReader.close();
            String[] record = { // порядок записи: Id, SenderID, SendDate, ThreadID, Content
                    String.valueOf(message.getID()),
                    String.valueOf(message.getSender().getID()),
                    DateHelper.DoFormat(message.getSendDate()),
                    String.valueOf(message.getThread().getID()),
                    message.getContent()
            };
            writer.writeNext(record);
            writer.close();
            message.getSender().setMessageCounter(message.getSender().getMessageCounter()+1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void DeleteByID(long id){
        List<Message> messages = GetAll();
        Message messageToRemove = null;
        for (Message message : messages) {
            if (message.getID() == id) {
                messageToRemove = message;
                break;
            }
            System.out.println("log// Не найдено Message: ID="+ id);
        }
        if (messageToRemove != null) {
            messages.remove(messageToRemove);
            try {
                // Открываем файл на запись
                CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, false));
                writer.writeNext(new String[]{"Id", "SenderID", "SendDate", "ThreadID", "Content"});
                // Записываем данные всех сообщений, кроме удаленного
                for (Message message : messages) {
                    String[] record = {
                            String.valueOf(message.getID()),
                            String.valueOf(message.getSender().getID()),
                            DateHelper.DoFormat(message.getSendDate()),
                            String.valueOf(message.getThread().getID()),
                            message.getContent()
                    };
                    writer.writeNext(record);
                }

                // Закрываем файл
                writer.close();
                System.out.println("log// Успешно удалено Message: ID=" + messageToRemove.getID());
            } catch (IOException e) {
                System.err.println("Ошибка сохранения файла: " + e.getMessage());
            }
        }
    }
    @Override
    public Message GetByID(long id) {
        try {
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                long currentId = Long.parseLong(record[0]);
                if (currentId == id) { // порядок записи: Id, SenderID, SendDate, ThreadID, Content
                    long ID = Long.parseLong(record[0]);
                    int senderID = Integer.parseInt(record[1]);
                    String stringSendDate = record[2];
                    int threadID = Integer.parseInt(record[3]);
                    String content = record[4];
                    User sender = new User(-1,"<deleted>","<deleted>",new Date(),-1,"<deleted>");
                    if(userRepository.GetByID(senderID)!=null){
                        sender=userRepository.GetByID(senderID);
                    }
                    else System.out.println("log//<MessageRepos> Не найден sender: ID="+ record[1]);
                    Thread thread = new Thread(-1,"<deleted>","<deleted>");
                    if(threadRepository.GetByID(threadID)!=null){
                        thread = threadRepository.GetByID(threadID);
                    }
                    else System.out.println("log//<MessageRepos> Не найден thread: ID="+ record[3]);
                    Message message = new Message(ID, content, sender, thread, DateHelper.UnFormat(stringSendDate));
                    message.setID(currentId);
                    csvReader.close();
                    return message;
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
    public List<Message> GetAll() {
        List<Message> messages = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(FILE_PATH);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) { // порядок записи: Id, SenderID, SendDate, ThreadID, Content
                long currentId = Long.parseLong(record[0]);
                int senderID = Integer.parseInt(record[1]);
                String stringSendDate = record[2];
                int threadID = Integer.parseInt(record[3]);
                String content = record[4];
                User sender = new User(-1,"<deleted>","<deleted>",new Date(),-1,"<deleted>");
                if(userRepository.GetByID(senderID)!=null){
                    sender=userRepository.GetByID(senderID);
                }
                else System.out.println("log//<MessageRepos> Не найден sender: ID="+ record[1]);
                Thread thread = new Thread(-1,"<deleted>","<deleted>");
                if(threadRepository.GetByID(threadID)!=null){
                    thread = threadRepository.GetByID(threadID);
                }
                else System.out.println("log//<MessageRepos> Не найден thread: ID="+ record[3]);
                Message message = new Message(content, sender, thread, DateHelper.UnFormat(stringSendDate));
                message.setID(currentId);
                messages.add(message);
            }

            csvReader.close();
        } catch (IOException | CsvValidationException | ParseException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

}

