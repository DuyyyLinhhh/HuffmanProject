package Hw6_22001603_NguyenDangKhoa.combo3.ex1;

public interface PriorityQueueInterface<K, E> {
    int size();

    boolean isEmpty();

    void insert(Entry<K, E> entry); // thêm entry vào queue

    void insert(K k, E e); // thêm phần tử khóa k, giá trị e vào queue

    Entry<K, E> removeMin(); // xóa phần tử nhỏ nhất

    Entry<K, E> min(); // trả về phần tử nhỏ nhất
}
