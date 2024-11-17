package buoi5.btvn;

import java.util.ArrayList;
import java.util.Comparator;

public class ClassRoom {
    private static ArrayList<Student> li = new ArrayList<>();

    public void sortByGpa() {
        li.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGpa() < o2.getGpa()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

    public void inputList() {
        int idCheck = 0;
        do {
            Student student = new Student();
            student.input();
            li.add(student);
            idCheck = student.getId();
        } while (idCheck != 555);
    }

    public void output() {
        for (Student student : li) {
            student.output();
        }
    }

    public boolean removeById(int id) {
        for (Student student : li) {
            if (student.getId() == id) {
                li.remove(student);
                System.out.println("Xoa thanh cong");
                return true;
            }
        }
        return false;
    }

    public boolean findFail(int id) {
        for (Student student : li) {
            if (student.getId() == id) {
                return student.checkFail();
            }
        }
        return false;
    }
}
