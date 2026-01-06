import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		System.out.print("数値を入力してください：");

        int x = Integer.parseInt(br.readLine());
        int num = 0;
        while(num <= 300)
        {
        	System.out.println(num);
            num += x;
        }

	}

}
