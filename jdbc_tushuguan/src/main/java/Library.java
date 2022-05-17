import java.util.List;
import java.util.Scanner;

public class Library {
    public void menu(){
        while (true){
            System.out.println("------云大图书管理系统------");
            System.out.println("*****  1.查看所有的图书  *****");
            System.out.println("*****  2.添加图书相关信息  *****");
            System.out.println("*****  3.删除图书的信息  *****");
            System.out.println("*****  4.修改图书的信息  *****");
            System.out.println("*****  5.退出系统         *****");
            Scanner sc =new Scanner(System.in);
            System.out.println("*****  请输入你要进行的操作：*****");

            String bookfunction = sc.nextLine();
            switch (bookfunction){
                case "1":
                    findbook();
                    break;
                case "2":
                    addbook();
                    break;
                case "3":
                    deletebook();
                    break;
                case "4":
                    updatebook();
                    break;
                case "5":
                    System.out.println("成功退出图书管理系统！");
                    System.exit(0);
                    break;
            }

        }
    }




    //查看图书
    public static void findbook(){
        BookDao dao=new BookDao();
        List<Book> list= dao.list();
        System.out.println("编号\t书名\t作者\t数量");
        for (Book bookList:list){
            System.out.println(" "+bookList.getBookId()+"       "+bookList.getBookName()+"        "+bookList.getBookAut()+"        "+bookList.getBookNum());
        }
    }


    //添加图书
    public static void addbook(){
        Scanner sc=new Scanner(System.in);
        String name,aut,num;
        int id;
        System.out.println("请输入编号");
        id=sc.nextInt();
        System.out.println("请输入书名");
        Scanner sc1=new Scanner(System.in);
        name=sc1.nextLine();
        System.out.println("请输入作者");
        aut=sc1.nextLine();
        System.out.println("请输入数量");
        num=sc1.nextLine();
        Book book= new Book(name, id, aut, num);
        BookDao dao=new BookDao();
        boolean flag=dao.addbook(book);
        if (flag){
            System.out.println("保存成功！");
        }else {
            System.out.println("保存失败！");
        }
    }


    //删除图书
    public static void deletebook(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入删除图书的编号：");
        int delID =sc.nextInt();
        BookDao dao=new BookDao();
        boolean flag=dao.delbook(delID);
        if (flag){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }
    }


    //修改图书
    public static void updatebook(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入修改图书的编号：");
        int updID=sc.nextInt();
        System.out.println("请输入书名");
        Scanner sc1=new Scanner(System.in);
        String name=sc1.nextLine();
        System.out.println("请输入作者");
        String aut=sc1.nextLine();
        System.out.println("请输入数量");
        String num=sc1.nextLine();
        Book book=new Book(name,updID,aut,num);
        BookDao dao=new BookDao();
        boolean flag=dao.updatebook(book);
        if (flag){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
    }
}