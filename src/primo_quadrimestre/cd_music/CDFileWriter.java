package primo_quadrimestre.cd_music;

import java.io.FileWriter;
import java.io.IOException;

public class CDFileWriter {
    private final String fileName;

    public CDFileWriter() {
        this.fileName = "cds.txt";
    }

    public void writeCdsOnFile(Cd... cds) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

        for (Cd cd : cds) {
            fileWriter.write(cd.toStringFile() + "\n");
        }

        fileWriter.close();
    }
}
