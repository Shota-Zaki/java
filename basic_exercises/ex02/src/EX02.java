import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EX02 {

	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String s; // 入力受け取り用変数
		int count = 0; // 実行回数保存用変数
		int sum = 0; //合計記録用変数

		// 無限ループ
		while(true){
			System.out.print("入力してください:");
			s = br.readLine();	//ユーザーが入力

			if(s.equals("End")){ // Endならループ終了
				break;
			}else{ // Endでなければ合計にプラス
				sum += Integer.parseInt(s);
			}
			count++;

		}


		System.out.println(count + "回入力しました。");
		System.out.println("合計は" + sum + "です。");

	}

}
