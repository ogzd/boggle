import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hile {

	/**
	 * @param args
	 * @throws IOException
	 */

	private static Kutu[][] kutular;
	private static Set<String> dictionary[];
	private static boolean b[][] = new boolean[4][4];
	private static List<String> cevaplar = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		readFromFile("dic.txt");
		while (true) {
			clearB();
			cevaplar.clear();
			createGraph();
			findWords();
			for (String kelime : cevaplar)
				System.out.println(kelime);
			System.out.println();
		}
	}

	private static void readFromFile(String filename) throws IOException {
		FileInputStream fstream = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-16"));
		String word = null;
		dictionary = new HashSet[20];
		for(int i=0;i<20;i++)
			dictionary[i] = new HashSet<String>();
		while ((word = br.readLine()) != null) {
			word = word.trim();
			word = word.toLowerCase();
			if (word.contains(" ") || word.contains("[") || word.contains("]"))
				continue;
			if (word.length() > 2 && word.length() < 11)
			{
				dictionary[word.length()].add(word);
			}
		}

	}

	private static void createGraph() throws IOException {
		String harfler = readHarfler();
		kutular = new Kutu[4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				kutular[i][j] = new Kutu(harfler.charAt(i * 4 + j));
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (i > 0)
					kutular[i][j].setUstKomsu(kutular[i - 1][j]);
				if (i < 3)
					kutular[i][j].setAltKomsu(kutular[i + 1][j]);
				if (j < 3)
					kutular[i][j].setSagKomsu(kutular[i][j + 1]);
				if (j > 0)
					kutular[i][j].setSolKomsu(kutular[i][j - 1]);
				if (i > 0 && j < 3)
					kutular[i][j].setUstSagKomsu(kutular[i - 1][j + 1]);
				if (i > 0 && j > 0)
					kutular[i][j].setUstSolKomsu(kutular[i - 1][j - 1]);
				if (i < 3 && j < 3)
					kutular[i][j].setAltSagKomsu(kutular[i + 1][j + 1]);
				if (i < 3 && j > 0)
					kutular[i][j].setAltSolKomsu(kutular[i + 1][j - 1]);
			}
	}

	private static String readHarfler() throws IOException {
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		String c = in.readLine();

		return c;
	}

	private static void findWords() {
		for (int u = 10; u > 2; u--)
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					clearB();
					dfs(i, j, "", u);
				}
	}

	private static void clearB() {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				b[i][j] = false;
	}

	

	private static void dfs(int i, int j, String kelime, int maxLength) {
		if (b[i][j])
			return;
		if (kelime.length() == maxLength) {
			if (dictionary[maxLength].contains(kelime))
				if (!cevaplar.contains(kelime))
					cevaplar.add(kelime);
			return;
		}
		else if(kelime.length() > maxLength)
			return;
		b[i][j] = true;
		Kutu kutu = kutular[i][j];
		if (kutu.getAltKomsu() != null)
			dfs(i + 1, j, kelime + String.valueOf(kutu.getHarf()), maxLength);
		if (kutu.getUstKomsu() != null)
			dfs(i - 1, j, kelime + String.valueOf(kutu.getHarf()), maxLength);
		if (kutu.getSagKomsu() != null)
			dfs(i, j + 1, kelime + String.valueOf(kutu.getHarf()), maxLength);
		if (kutu.getSolKomsu() != null)
			dfs(i, j - 1, kelime + String.valueOf(kutu.getHarf()), maxLength);
		if (kutu.getAltSagKomsu() != null)
			dfs(i + 1, j + 1, kelime + String.valueOf(kutu.getHarf()),
					maxLength);
		if (kutu.getAltSolKomsu() != null)
			dfs(i + 1, j - 1, kelime + String.valueOf(kutu.getHarf()),
					maxLength);
		if (kutu.getUstSagKomsu() != null)
			dfs(i - 1, j + 1, kelime + String.valueOf(kutu.getHarf()),
					maxLength);
		if (kutu.getUstSolKomsu() != null)
			dfs(i - 1, j - 1, kelime + String.valueOf(kutu.getHarf()),
					maxLength);
		b[i][j] = false;
	}
}
