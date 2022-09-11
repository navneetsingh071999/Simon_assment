package Services;

import java.util.List;

import Models.LogFile;

public interface IFileReader {
    public List<LogFile> readFile(String fileName);
    public LogFile extractData(String line);
}
