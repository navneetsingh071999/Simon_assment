package Services;

import java.util.List;

import Models.LogFile;

public interface IFileOperations {
    public void displayMachineNames(List<LogFile> LogFile);
    public void generateMachineReport(String machineName, List<LogFile> logFiles);
    public void displayUpdateError(List<LogFile> logFiles);
}
