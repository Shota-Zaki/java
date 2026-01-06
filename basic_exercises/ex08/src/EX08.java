import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX08 {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		//入力の準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//個人情報入力画面
		System.out.println("健康管理アプリケーションへようこそ。");
		System.out.print("名前を入力してください：");
		String name = br.readLine();
		System.out.print("身長(m)を入力してください：");
		double height = Double.parseDouble(br.readLine());
		System.out.print("体重(kg)を入力してください：");
		double weight = Double.parseDouble(br.readLine());

		//患者オブジェクト生成
		while(true){
			//メニューを表示
			System.out.println("**********メニュー**********");
			System.out.print("1)BMI指数計算\t2)標準体重計算\t3)肥満度計算\t9)終了:");
			int menu = Integer.parseInt(br.readLine());

			switch(menu){
			case 1:
				//BMI指数計算
				double bmi = calcBmi(weight, height);

				//BMI指数に応じてメッセージを表示
				if(bmi < 18.5){
					System.out.println(name + "さんはやせています。");
				}else if(bmi < 25){
					System.out.println(name + "さんはふつうです。");
				}else{
					System.out.println(name + "さんはふとっています。");
				}
				break;

			case 2:
				//標準体重計算
				double stdweight = standardWeight(height);

				//メッセージを表示
				System.out.println(name + "さんの標準体重は"+ stdweight + "です。");
				break;

			case 3:
				//肥満度計算
				double obesity = checkObesity(weight, height);

				//肥満度の割合に応じてメッセージを表示
				if(obesity >= 10 && obesity < 20 ){
					System.out.println(name + "さんは肥満気味です。");
				}else if(obesity >= 20){
					System.out.println(name + "さんは肥満です。");
				}else{
					System.out.println(name + "さんは肥満ではありません。");
				}
				break;

			case 9:
				//メッセージを表示して終了
				System.out.println("ありがとうございました。");
				System.exit(0);
			}

			//改行
			System.out.println();
		}
	}

	//メソッド
			//BMI指数
			public static double calcBmi(double weight, double height){
				//BMI指数を求める
				double bmi = weight / height / height;

				//BMI指数を返す
				return bmi;
			}

			//標準体重
			public static double standardWeight(double height){
				//標準体重を求める
				double weight = height * height * 22;

				//標準体重を返す
				return weight;
			}

			//肥満度
			public static double checkObesity(double weight, double height){
				//肥満度を求める
				double obesity = (weight - standardWeight(height))/standardWeight(height) * 100;

				//肥満度を返す
				return obesity;
			}

}
