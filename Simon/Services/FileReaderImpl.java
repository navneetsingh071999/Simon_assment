package Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import Models.LogFile;

public class FileReaderImpl implements IFileReader{

    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public List<LogFile> readFile(String fileName) {

        List<LogFile> logFileList = new ArrayList<>();

        File file = new File("Data/"+fileName);
        Scanner sc;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
               LogFile logFile = extractData(sc.nextLine());
               logFileList.add(logFile);
            }
        } catch (FileNotFoundException e) {
            logger.info("Error Reading File");
        }
        
        return logFileList;
    }

    @Override
    public LogFile extractData(String line) {
        LogFile logData = new LogFile();
        String [] lineArray = line.split(" ");
        logData.setTime(lineArray[0]);
        logData.setMachineName(lineArray[1]);
        logData.setEvent(lineArray[2]);
        logData.setEventNumber(lineArray[3]);
        logData.setStatus(lineArray[4]);
        
        System.out.println(logData.getMachineName());

        return logData;
    }
    
}
