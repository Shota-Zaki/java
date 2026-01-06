import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX13 {

	public static void main(String[] args) throws IOException{

		int n, d, x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("n=");
		n = Integer.parseInt(br.readLine());
		System.out.print("d=");
		d = Integer.parseInt(br.readLine());
		System.out.print("x=");
		x = Integer.parseInt(br.readLine());

		int[] num = new int[d];

		f(num, 1, n, 1, x);
	}

	// f(引継ぎ合計, 始めの値, 終わりの値, 何個目の数か, 求める合計)
	public static void f(int[] num, int s, int n, int c, int x){
		for(int i = s; i <= n; i++){
			// 計算用配列に値を設定
			num[c - 1] = i;

			// 指定個数の数に達すれば、合計を求めて、求める合計と比較
			if(c == num.length){
				// 合計を求め、比較
				if(sum(num) == x){
					show(num);
				}
			}
			else{
				// 再起呼出
				f(num, i + 1, n, c + 1, x);
			}
		}
	}

	// 合計を計算するための関数
	public static int sum(int[] num){
		int s = 0;
		for(int i = 0; i < num.length; i++){
			s += num[i];
		}
		return s;
	}

	// 表示処理
	public static void show(int[] num){
		String str = "";
		for(int i = 0; i < num.length; i++){
			str += num[i] + " + ";
		}
		str += " = " + sum(num);
		System.out.println(str);
	}
}
