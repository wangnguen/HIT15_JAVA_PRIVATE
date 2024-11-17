package buoi5.btvn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClassRoom classRoom = new ClassRoom();
        boolean check = true;
        do {
            System.out.println("1. Nhap thong tin");
            System.out.println("2. In ra thong tin");
            System.out.println("3. Sap xep theo gpa");
            System.out.println("4. Xoa theo id");
            System.out.println("5. Kiem tra do/truot");
            System.out.println("6. Thoat");
            System.out.println("Nhap lua chon");
            int select = sc.nextInt();
            sc.nextLine();
            try {
                switch (select) {
                    case 1:
                        classRoom.inputList();
                        break;
                    case 2:
                        classRoom.output();
                        break;
                    case 3:
                        classRoom.sortByGpa();
                        break;
                    case 4:
                        System.out.println("Nhap id can tim");
                        int idIndex = sc.nextInt();
                        sc.nextLine();
                        classRoom.removeById(idIndex);
                        break;
                    case 5:
                        System.out.println("Nhap id can kiem tra");
                        int idIndex2 = sc.nextInt();
                        sc.nextLine();
                        if (classRoom.findFail(idIndex2)) {
                            System.out.println("Sinh vien nay do");
                        } else {
                            System.out.println("Sinh vien nay truot");
                        }
                        break;
                    case 6:
                        check = false;
                        break;
                    default:
                        System.out.println("Nhap khong hop le");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
            }
        } while (check != false);
    }
}
