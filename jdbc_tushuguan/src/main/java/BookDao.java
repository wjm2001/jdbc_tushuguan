import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet res;

    //添加图书
    public boolean addbook(Book book){
        String sql="insert into library(id,name,aut,num) values(?,?,?,?)";
        try {
            conn=DBUtils.getConn();
            pst=conn.prepareStatement(sql);
            pst.setInt(1,book.getBookId());
            pst.setString(2,book.getBookName());
            pst.setString(3,book.getBookAut());
            pst.setString(4,book.getBookNum());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pst,conn,res);
        }
        return true;
    }

    //查看图书
    public List<Book> list(){
        List<Book> list=new ArrayList<Book>();
        String sql="select * from library";
        try {
            conn=DBUtils.getConn();
            pst=conn.prepareStatement(sql);
            res=pst.executeQuery();
            while (res.next()){
                Book book=new Book();
                book.setBookId(res.getInt("id"));
                book.setBookName(res.getString("name"));
                book.setBookAut(res.getString("aut"));
                book.setBookNum(res.getString("num"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pst,conn,res);
        }
        return list;
    }


    //修改图书
    public boolean updatebook(Book book){
        String sql="update library set id=?,name=?,aut=?,num=?";
        try {
            conn=DBUtils.getConn();
            pst=conn.prepareStatement(sql);
            pst.setInt(1,book.getBookId());
            pst.setString(2,book.getBookName());
            pst.setString(3,book.getBookAut());
            pst.setString(4,book.getBookNum());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pst,conn,res);
        }
        return true;
    }


    //删除图书
    public boolean delbook(int id){
        String sql="delete from library where id=?";
        try {
            conn=DBUtils.getConn();
            pst=conn.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(pst,conn,res);
        }
        return true;
    }
}