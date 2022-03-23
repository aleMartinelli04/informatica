package primo_quadrimestre.cd_music;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CdFileReader {
    private final String fileName;

    public CdFileReader() {
        this.fileName = "cds.txt";
    }

    public Cd[] readCds() throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));

        List<Cd> cds = new ArrayList<>();

        while (scanner.hasNextLine()) {
            cds.add(Cd.fromFile(scanner.nextLine()));
        }

        Cd[] toReturn = new Cd[cds.size()];

        for (int i = 0; i < toReturn.length; i++) {
            toReturn[i] = cds.get(i);
        }

        return toReturn;
    }
}
