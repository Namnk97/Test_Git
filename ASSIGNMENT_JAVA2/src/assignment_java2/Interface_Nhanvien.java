package assignment_java2;

import java.util.ArrayList;
import java.util.List;

public interface Interface_Nhanvien {

    public void insert(Nhanvien nv);

    public void delete(int viTri);

    public Nhanvien select(int viTri);

    public List display();

    public void virtualObject();
}
