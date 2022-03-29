package tasks.lesson1;


import java.util.*;

/**
 * Скобки в коде
 * Проверить, правильно ли расставлены скобки в данном коде.
 * Вход. Исходный код программы.
 * Выход. Проверить, верно ли расставлены скобки. Если нет,
 * выдать индекс первой ошибки.
 * Вы разрабатываете текстовый редактор для
 * программистов и хотите реализовать проверку
 * корректности расстановки скобок.
 * В коде могут встречаться скобки []{}(). Из них скобки [,{
 * и ( считаются открывающими, а соответствующими им
 * закрывающими скобками являются
 * ],} и ).
 * В случае, если скобки расставлены неправильно, редактор должен
 * также сообщить пользователю первое место, где обнаружена ошибка.
 * В первую очередь необходимо найти закрывающую скобку,
 * для которой либо нет соответствующей открывающей
 * (например, скобка ] в
 * строке “]()”), либо же она закрывает не соответствующую ей
 * открывающую скобку (пример: “()[}”). Если таких ошибок нет,
 * необходимо найти первую открывающую скобку, для которой нет
 * соответствующей закрывающей (пример: скобка ( в строке “{}([]”).
 * Помимо скобок, исходный код может содержать символы
 * латинского алфавита, цифры и знаки препинания.
 * Формат входа. Строка s[1 . . . n], состоящая из заглавных
 * и прописных букв латинского алфавита, цифр, знаков препинания и скобок из множества []{}().
 * Формат выхода. Если скобки в s расставлены правильно,
 * выведите строку “Success". В противном случае выведите
 * индекс (используя индексацию с единицы) первой закрывающей
 * скобки, для которой нет соответствующей открывающей.
 * Если такой нет, выведите индекс первой открывающей скобки,
 * для которой нет соответствующей закрывающей.
 *
 * */
public class Validate {

    public static void main(final String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] symbols = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        int counter = 0;
        List<Integer> opened = new LinkedList<>();
        List<Integer> closed = new LinkedList<>();

        for(char c : symbols) {
            counter++;

            if(c == '(' || c == '{' || c == '[') {
                //System.out.println("РАССМАТРИВАЕТСЯ открывающая, индекс " + counter);
                stack.push(c);
                //System.out.println("На стек помещена открывающая");
                opened.add(counter);
            }

            if (c == ')' || c == '}' || c == ']') {
                //System.out.println("РАССМАТРИВАЕТСЯ закрывающая, индекс " + counter);

                if(!stack.isEmpty()) {
                    //System.out.println("Стек непустой");
                    char fromStack = stack.peek();
                    if((c == ')' && fromStack == '(') ||
                            (c == '}' && fromStack == '{') ||
                            (c == ']' && fromStack == '[')) {
                        stack.pop();
                        //System.out.println("Со стека снята открывающая");
                        ((LinkedList<Integer>) opened).removeLast();
                    } else {
                        //System.out.println("Несоответствие последней открывающей на стеке, прерывание");
                        closed.add(counter);
                        break;
                    }
                } else {
                    //System.out.println("Стек пустой, прерывание. Будет выведет индекс текущего элемента");
                    stack.add(c);
                    closed.add(counter);
                    break;
                }
            }

        }

        //System.out.println("Is stack empty? " + stack.isEmpty());
        //System.out.println("Opened " + opened.toString());
        //System.out.println("Closed " + closed.toString());

        if(!stack.isEmpty()) {
            if(!closed.isEmpty()) {
                System.out.println(((LinkedList<Integer>) closed).getFirst());
            } else {
                if(!opened.isEmpty()) {
                    System.out.println(((LinkedList<Integer>) opened).getFirst());
                }
            }
        } else {
            System.out.println("Success");
        }
    }
}









































