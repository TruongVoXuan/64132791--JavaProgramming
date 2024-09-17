package app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook implements Phone {
    private ArrayList<PhoneEntry> PhoneList;
    
    
    public PhoneBook() {
        PhoneList = new ArrayList<>();
    }

    @Override
    public void insertPhone(String name, String phone) {
    	
        for (PhoneEntry entry : PhoneList) {//Duyệt qua từng phần tử trong danh sách PhoneList
            if (entry.getName().equals(name)) {//Kiểm tra xem tên của mục nhập hiện tại (entry.getName()) có bằng với tên (name) được truyền vào hay không.
                if (!entry.getPhone().contains(phone)) {//SĐT nhập vào không nằm trong danh sách của mục nhập hiện tại
                    entry.setPhone(entry.getPhone() + " : " + phone); //Thêm SĐT mới vào danh sách
                }
                return;
                //Kết thúc phương thức insertPhone nếu đã tìm thấy và cập nhật mục nhập hiện tại.
            }
        }
        PhoneList.add(new PhoneEntry(name, phone));
        //Nếu vòng lặp for kết thúc mà không tìm thấy tên nào trùng khớp, thêm một mục nhập mới (PhoneEntry) 
        //với tên và số điện thoại vào danh sách PhoneList
    }

    @Override
    public void removePhone(String name) {
        PhoneList.removeIf(entry -> entry.getName().equals(name));
    }

    @Override
    public void updatePhone(String name, String newphone) {
        for (PhoneEntry entry : PhoneList) {
            if (entry.getName().equals(name)) {
                entry.setPhone(newphone);
                return;
            }
        }
    }

    @Override
    public void searchPhone(String name) {
        for (PhoneEntry entry : PhoneList) {
            if (entry.getName().equals(name)) {
                System.out.println("Name: " + entry.getName() + ", Phone: " + entry.getPhone());
                return;
            }
        }
        System.out.println("Name not found.");
    }

    @Override
    public void sort() {
        Collections.sort(PhoneList, Comparator.comparing(PhoneEntry::getName));
    }

    private static class PhoneEntry {
        private String name;
        private String phone;

        public PhoneEntry(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}

