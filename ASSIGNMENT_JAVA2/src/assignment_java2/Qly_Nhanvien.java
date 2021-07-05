package assignment_java2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Qly_Nhanvien implements Interface_Nhanvien  {
    
    private List<Nhanvien> dsnv;
    
    public Qly_Nhanvien() {
        this.dsnv = new ArrayList();
    }
    
    @Override
    public void insert(Nhanvien nv) {
        this.dsnv.add(nv);
    }
    
    @Override
    public void delete(int viTri) {
        this.dsnv.remove(viTri);
    }
    
    @Override
    public Nhanvien select(int viTri) {
        return this.dsnv.get(viTri);
    }
    
    @Override
    public List display() {
        return this.dsnv;
    }
    
    @Override
    public void virtualObject() {
        Nhanvien nv = new Nhanvien("ph17001", "Nam", 24, "namnk@gmail.com", 10000000);
        Nhanvien nv1 = new Nhanvien("ph17002", "Duy", 30, "duy002@gmail.com", 30000000);
        Nhanvien nv2 = new Nhanvien("ph17003", "Quy", 28, "quylq12@gmail.com", 7000000);
        insert(nv);
        insert(nv1);
        insert(nv2);
    }
    
}
