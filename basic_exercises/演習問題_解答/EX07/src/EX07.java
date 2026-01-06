import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class EX07 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		System.out.print("半径を入力してください：");

        int radius = Integer.parseInt(br.readLine());

        double a, b, c, d;

        a = circle_area(radius);
        b = circumference(radius);
        c = sphere(radius);
        d = surface(radius);

        System.out.println("円の面積　：" + a);
        System.out.println("円周　　　：" + b);
        System.out.println("球の体積　：" + c);
        System.out.println("球の表面積：" + d);
    }

    static double circle_area(int radius)
    {
        return radius * radius * 3.14;
    }

    static double circumference(int radius)
    {
        return 2 * radius * 3.14;
    }

    static double sphere(int radius)
    {
    	BigDecimal bd = new BigDecimal(radius * radius * radius * 3.14 * 4 / 3);
    	BigDecimal bd1 = bd.setScale(2, BigDecimal.ROUND_FLOOR);
    	return bd1.doubleValue();
    }

    static double surface(int radius)
    {
        return 4 * 3.14 * radius * radius;
    }

}
