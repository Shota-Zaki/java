import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("タテ：");
		int y = Integer.parseInt(br.readLine());
		System.out.print("ヨコ：");
		int x = Integer.parseInt(br.readLine());

		for(int i = 0; i < y; i++){
			for(int j = 0; j < x; j++){
				if((i % 2 + j) % 2 == 0){
					System.out.print("#");
				}
				else{
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

}
