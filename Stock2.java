package エンジニアでも恋がしたい;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stock2 {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String line = br.readLine();     //商品の数を入力
		int num = Integer.parseInt(line);     //int化

		int[][] muststock_nowstoc_price = new int[num][3];     //必要な在庫数と現在の在庫数と商品の価格を格納する配列

		for(int i = 0; i < num; i++) {
			String line2 = br.readLine();
			String[] numdelimiter = line2.split(" ", 3);
			for(int j = 0; j < numdelimiter.length; j++) {
				muststock_nowstoc_price[i][j] = Integer.parseInt(numdelimiter[j]);
			}
		}

		int sum = 0;     //すべての商品を補充するために必要な金額
		int nowstocxprice = 0;     //1つの商品につきどれだけ補充しなければいけないか

		for(int a = 0; a <muststock_nowstoc_price.length; a++) {
			if(muststock_nowstoc_price[a][0] > muststock_nowstoc_price[a][1]) {     //在庫が足りない場合
				nowstocxprice = (muststock_nowstoc_price[a][0] - muststock_nowstoc_price[a][1]) * muststock_nowstoc_price[a][2];
				sum = sum + nowstocxprice;
			}
		}

		System.out.println(sum);
	}
}
