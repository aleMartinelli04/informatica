package primo_quadrimestre.hashmaps;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Classes {
    private final int classGrade;
    private final String className;

    public final static List<Classes> classes = ClassNamesFileReader.getClassNames();

    public Classes(int classGrade, String className) {
        this.classGrade = classGrade;
        this.className = className;
    }

    public int getClassGrade() {
        return classGrade;
    }

    public String getClassName() {
        return className;
    }

    public static Classes randomClass() {
        return classes.get(ThreadLocalRandom.current().nextInt(0, classes.size()));
    }

    @Override
    public String toString() {
        return classGrade + className;
    }
}
