public class Student {

    private String name;
    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("张三",50));
        arr.addLast(new Student("李四",60));
        arr.addLast(new Student("王五",90));
        System.out.println(arr);
    }
}
