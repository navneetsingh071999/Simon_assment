package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.LogFile;

public class Start implements StartInter{

    private Scanner in = new Scanner(System.in);
    FileReaderImpl fileReaderImpl = new FileReaderImpl();
    FileOperationsImpl fileOperationsImpl = new FileOperationsImpl();
    public static String FILE_ONE = "sample-logfile1.log";
    public static String FILE_TWO = "sample-logfile2.log";
    List<LogFile> logFileList = new ArrayList<>();

    @Override
    public void start() {
        String fileResult = "";

        while(true){
            fileResult = getFile();
            if(fileResult.equals(FILE_ONE) || fileResult.equals(FILE_TWO)){
                break;
            }
        }
        logFileList = fileReaderImpl.readFile(fileResult);     
        int ch;
        boolean conti = true;

        while(conti){
            showMenu();   
            System.out.println("Enter numer from 1-4 to select menu function.");
            ch = in.nextInt();
    
            switch(ch){
                case 1:
                    fileOperationsImpl.displayMachineNames(logFileList);
                    break;
                case 2:
                    System.out.println("Enter Machinre Name: ");
                    String machineName = in.next();
                    fileOperationsImpl.generateMachineReport(machineName, logFileList);
                    break;
                case 3:
                    fileOperationsImpl.displayUpdateError(logFileList);
                    break;
                case 4:
                    conti = false;
                    break;
                default:
                    System.out.println("Please Select Correct Menu Number.");
            }
        }
    }

    public String getFile(){
        System.out.println("Please Enter name of the sample file with it's extensions to begin menu operatons.");
        String fileName = in.nextLine();

        if(fileName.equals(FILE_ONE)){
            return FILE_ONE;
        } else if(fileName.equals(FILE_TWO)){
            return FILE_TWO;
        }
        else{
            System.out.println("File could not be found, Please enter a valid file name");
        }
        return "";
    }

    @Override
    public void showMenu() {
        
        System.out.println("\nMENU Options\n");
        System.out.println("********************\n");
        System.out.println("1. List All Machine Names \n2. Create Text based report file for Event");
        System.out.println("3. Display all failed events accross all machies \n4. Exit the program");
        System.out.println("\n******************\n");
    }
}
