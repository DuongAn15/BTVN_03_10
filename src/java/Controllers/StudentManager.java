/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MY PC
 */
public class StudentManager {

    private static ArrayList<Student> alist = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public static int enterID() {
        while (true) {
            try {
                int id = sc.nextInt();//Nhập dữ liệu
                //Kiểm tra điều kiện thuộc khoảng >= 0
                if (id >= 0) {
                    return id;//Nếu dữ liệu đúng định dạng, trả về
                } else {
                    //Nếu dữ liệu < 0, thông báo nhập lại
                    System.out.println("ID phai la so khong am, ban hay nhap lai! ");
                }
            } catch (Exception e) {
                //Trường hợp dữ liệu sai định dạng, thông báo nhập lại
                System.out.println("Du lieu sai dinh dang, ban hay nhap lai! ");
                sc.nextLine();//Xóa dữ liệu đã nhập sai ở bước trên
            }
        }
    }

    public static int enterAge() {
        while (true) {
            try {
                int age = sc.nextInt();//Nhập dữ liệu
                //Kiểm tra điều kiện thuộc khoảng >= 18
                if (age >= 18) {
                    return age;//Nếu dữ liệu đúng định dạng, trả về
                } else {
                    //Nếu dữ liệu < 18, thông báo nhập lại
                    System.out.println("Tuoi phai tu 18 tro len, ban hay nhap lai! ");
                }
            } catch (Exception e) {
                //Trường hợp dữ liệu sai định dạng, thông báo nhập lại
                System.out.println("Du lieu sai dinh dang, ban hay nhap lai! ");
                sc.nextLine();//Xóa dữ liệu đã nhập sai ở bước trên
            }
        }
    }

    public static int enterOption(int a) {
        while (true) {
            try {
                int op = sc.nextInt();//Nhập dữ liệu
                //Kiểm tra điều kiện thuộc khoảng [1; a]
                if (op >= 1 && op <= a) {
                    return op;//Nếu dữ liệu đúng định dạng, trả về
                } else {
                    //Nếu dữ liệu ngoài khoảng [1; a], thông báo nhập lại
                    System.out.println("Khong co lua chon nay, ban hay chon lai! ");
                }
            } catch (Exception e) {
                //Trường hợp dữ liệu sai định dạng, thông báo nhập lại
                System.out.println("Du lieu sai dinh dang, ban hay nhap lai! ");
                sc.nextLine();//Xóa dữ liệu đã nhập sai ở bước trên
            }
        }
    }

    public static void xemDanhSach() {
        System.out.println("Danh sach sinh vien");
        for (Student st : alist) {
            System.out.println(st.toString());
        }
    }

    public static void themSinhVien() {
        System.out.println("Hay nhap ten sinh vien:");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Hay nhap tuoi sinh vien:");
        int age = enterAge();
        System.out.print("Hay nhap chuyen nganh sinh vien theo hoc:\n");
        sc.nextLine();
        String major = sc.nextLine();
        Student element = new Student(name, age, major);
        alist.add(0, element);
    }

    public static void xoaSinhVien() {
        System.out.println("Hay nhap ID sinh vien muon xoa: ");
        int id = enterID();
        int ok = 0;

        for (int i = 0; i < alist.size(); i++) {
            if (alist.get(i).getID() == id) {
                alist.remove(i);
                ok = 1;
                break;
            }
        }
        if (ok == 0) {
            System.out.println("Khong co sinh vien nay");
        }

    }

    public static void suaSinhVien() {
        System.out.println("Hay nhap ID sinh vien muon sua: ");
        int id = enterID();
        int ok = 0;

        for (int i = 0; i < alist.size(); i++) {
            if (alist.get(i).getID() == id) {

                String name = alist.get(i).getName();
                int age = alist.get(i).getAge();
                String major = alist.get(i).getMajor();

                while (true) {
                    System.out.println("Truong thong tin:\n1. Ten\n2. Tuoi\n3. Chuyen nganh\n4. Khong sua hoac Da sua xong");
                    System.out.println("Nhap truong thong tin can sua: ");
                    int op = enterOption(4);
                    switch (op) {
                        case 1:
                            System.out.println("Hay nhap ten sinh vien:");
                            sc.nextLine();
                            name = sc.nextLine();
                            break;
                        case 2:
                            System.out.println("Hay nhap tuoi sinh vien:");
                            age = enterAge();
                            break;
                        case 3:
                            System.out.print("Hay nhap chuyen nganh sinh vien theo hoc:\n");
                            sc.nextLine();
                            major = sc.nextLine();
                            break;
                        case 4:
                            break;
                    }

                    if (op == 4) {
                        break;
                    }
                }

                alist.get(i).setName(name);
                alist.get(i).setAge(age);
                alist.get(i).setMajor(major);

                ok = 1;
                break;
            }
        }

        if (ok == 0) {
            System.out.println("Khong co sinh vien nay");
        }

    }

    public static void timKiemTheoTen() {
        System.out.println("Hay nhap ten sinh vien muon tim kiem");
        sc.nextLine();
        String name = sc.nextLine();
        int ok = 0;
        for (Student st : alist) {
            if (st.getName().equals(name)) {
                System.out.println("Thong tin sinh vien\n" + st.toString());
                ok = 1;
            }
        }
        if (ok == 0) {
            System.out.println("Khong co sinh vien nay");
        }
    }

    //Thoát chương trình
    public static void exitProgram() {
        System.exit(0);
    }

    public static void printMenu() {
        System.out.println("1. Xem danh sach");
        System.out.println("2. Them sinh vien");
        System.out.println("3. Xoa sinh vien");
        System.out.println("4. Sua sinh vien");
        System.out.println("5. Tim kiem theo ten");
        System.out.println("6. Thoat chuong trinh");

    }

    //Thực hiện chương trình
    public static void progam() {
        printMenu();
        while (true) {
            System.out.print("Nhap thao tac: ");
            int option = enterOption(6);
            switch (option) {
                case 1:
                    xemDanhSach();
                    break;
                case 2:
                    themSinhVien();
                    break;
                case 3:
                    xoaSinhVien();
                    break;
                case 4:
                    suaSinhVien();
                    break;
                case 5:
                    timKiemTheoTen();
                    break;
                case 6:
                    exitProgram();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        progam();
    }
}
