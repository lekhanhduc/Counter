/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author lekha
 */
public class Counter {

    // Đếm số kí tự 
    // Khởi tạo charCounter lưu số lần xuất hiện của một kí tự
    private Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
    // Khởi tạo wordCounter đếm số lần xuất hiện của mỗi từ
    private Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public static void main(String[] args) {
        //Nhập Input từ bàn phím
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = sc.nextLine();
        
        Counter counter = new Counter();
        counter.check(content);
        counter.display();
    }

    public void display() {
        // In ra màn hình các kết quả đã đếm, bao gồm: wordCounter + charCounter
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    public void check(String content) {
        // Duyệt từng kí tự trong nội dung content chuyển thành mảng để duyệt qua kí tự 
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;  //Kiểm tra khoảng trắng, nếu có thì tiếp tục
            }
            /* Kiểm tra kí tự ch có tồn tại trong Character hay không ?
       Nếu có thì thêm vào charConter với giá trị là 1 hay value là 1
             */
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                // Ngược lại nó nó đã tồn tại thì giá trị hay value hiện tại sẽ cộng thêm 1 để đếm số lần xuất hiện của nó
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            }
        }
        // Sử dụng StringTokenier để đếm số từ trong văn bản mà không đếm khoảng trắng
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken(); //Kiểm tra token tiếp theo và kiểm tra có còn token nào để duyệt hay không
            if (!wordCounter.containsKey(token)) { //Kiểm tra token đã xuất hiện trong wordCounter chưa ?
                wordCounter.put(token, 1);    // Nếu chưa có thì giá trị là 1
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }
}
