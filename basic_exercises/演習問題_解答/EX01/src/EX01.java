import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EX01 {

	public static void main(String[] args) throws IOException {
		//入力受け取り用BufferedReaderのインスタンス生成
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("数値を入力してください：");

		// 入力された文を受け取り、int型へと変換を行い、int型変数inへ代入。
		int in = Integer.parseInt(br.readLine());

		// 2で割り切れれば、
		if(in%2==0){
			//偶数である。
			System.out.println("偶数です");
		}else{
			//奇数である。
			System.out.println("奇数です");
		}

	}

}
