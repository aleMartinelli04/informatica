package primo_quadrimestre.university;

public class Professor {
    private static int code = 0;
    private String name;
    private String surname;
    private int age;
    private String personalCode;


    private Professor() {
        code++;
    }

    public Professor(String name, String surname, int age) {
        this();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.personalCode = String.valueOf(code);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", personalCode='" + personalCode + '\'' +
                '}';
    }
}
