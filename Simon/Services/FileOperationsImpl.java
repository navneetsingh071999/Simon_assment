package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import Models.Events;
import Models.LogFile;

public class FileOperationsImpl implements IFileOperations{

    public static final String FAILED = "Failed";
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void displayMachineNames(List<LogFile> logFile) {
        System.out.println("\n**** List of Machines ****\n");
        logFile.stream().forEach(logs->{System.out.println(logs.getMachineName());});
        System.out.println("\n");
    }

    @Override
    public void generateMachineReport(String machineName, List<LogFile> logFiles) {
        
        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter("Reports/"+machineName+".txt", true));
            String data = "Events for Machine: "+machineName+"\n";
            fWriter.write(data);
            fWriter.close();
        } catch (IOException e) {
            logger.warning("Error Writing in File.");
        }

        logFiles.forEach(log->{
            if(log.getMachineName().equalsIgnoreCase(machineName)){
                try {
                    BufferedWriter fWriter = new BufferedWriter(new FileWriter("Reports/"+machineName+".txt", true));
                    String data = log.getTime()+" "+log.getMachineName()+" "+log.getEvent()+" "+log.getEventNumber()+" "+log.getStatus();
                    fWriter.write(data+"\n");
                    fWriter.close();
                } catch (IOException e) {
                    logger.warning("Error Writing in File.");
                }

            }
        });

        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter("Reports/"+machineName+".txt", true));
            String data = "End of Events";
            fWriter.write(data);
            fWriter.close();
        } catch (IOException e) {
            logger.warning("Error Writing in File.");
        }

        
    }

    @Override
    public void displayUpdateError(List<LogFile> logFiles) {
        System.out.println("\nSoftware Update That Failed: ");
        logFiles.forEach(log->{
            if(log.getEvent().equalsIgnoreCase(Events.SOFTWARE_UPDATES)){
                if(log.getStatus().equalsIgnoreCase(FAILED)){
                    System.out.println(log.getMachineName()+": update "+log.getEventNumber());
                }
            }
        });

        System.out.println("\nInventory Actions That Failed: ");
        logFiles.forEach(log->{
            if(log.getEvent().equalsIgnoreCase(Events.INVENTORY)){
                if(log.getStatus().equalsIgnoreCase(FAILED)){
                    System.out.println(log.getMachineName()+log.getEventNumber()+" inventory");
                }
            }
        });

        System.out.println("\n");

    }
    
}
