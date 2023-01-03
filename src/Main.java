public class Main {
    public static void main(String[] args) {
        var textBox1 = new TextBox();
        textBox1.setText("this is some text");
        System.out.println(textBox1.text.toUpperCase());
        var textBox2 = new TextBox();
        textBox2.setText("another text");
        System.out.println(textBox2.text.toLowerCase());

    }
}