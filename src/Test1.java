import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
        //new几个Books对象
        Books books1 = new Books(1001, "Java", 888.0, "Sun出版社");
        Books books2 = new Books(1002, "Python", 257.0, "Python出版社");
        Books books3 = new Books(1003, "C++", 155.0, "C++出版社");

        //然后放进HashMap中,Key是图书的编号,value是图书对象
        HashMap<Integer, Books> booksHashMap = new HashMap<>();
        booksHashMap.put(books1.getNum(), books1);
        booksHashMap.put(books2.getNum(), books2);
        booksHashMap.put(books3.getNum(), books3);

        /**
         * 也可以不用创建Books类,直接用HashMap集合存储图书的属性
         * 然后放进list集合中,这里是为了让 图书编号作为key
         */
        List<HashMap<Integer, Books>> booksList = new ArrayList<>();
        booksList.add(booksHashMap);
        
        System.out.println("编号\t名称\t单价\t出版社");
        for (HashMap<Integer, Books> h : booksList) {
            //获取key
            Set<Integer> key = h.keySet();
            for (Integer i : key) {
                //再通过key找value
                System.out.println(i
                        + "\t" + h.get(i).getName()
                        + "\t" + h.get(i).getPrice()
                        + "\t" + h.get(i).getPress());
            }
        }
    }
}

/**
 * Books(图书类)
 * 用于存放图书的属性
 */
class Books {
    /**
     * num 编号
     * name 名称
     * price 价格
     * press 出版社
     */
    private int num;
    private String name;
    private double price;
    private String press;

    public Books() {

    }

    Books(int num, String name, double price, String press) {
        super();
        this.num = num;
        this.name = name;
        this.price = price;
        this.press = press;
    }

    int getNum() {
        return num;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    String getPress() {
        return press;
    }


}