
public class Kutu {

	private char harf;
	private Kutu ustKomsu;
	private Kutu altKomsu;
	private Kutu solKomsu;
	private Kutu ustSagKomsu;
	private Kutu altSagKomsu;
	private Kutu ustSolKomsu;
	private Kutu altSolKomsu;
	public Kutu getUstSagKomsu() {
		return ustSagKomsu;
	}

	public void setUstSagKomsu(Kutu ustSagKomsu) {
		this.ustSagKomsu = ustSagKomsu;
	}

	public Kutu getAltSagKomsu() {
		return altSagKomsu;
	}

	public void setAltSagKomsu(Kutu altSagKomsu) {
		this.altSagKomsu = altSagKomsu;
	}

	public Kutu getUstSolKomsu() {
		return ustSolKomsu;
	}

	public void setUstSolKomsu(Kutu ustSolKomsu) {
		this.ustSolKomsu = ustSolKomsu;
	}

	public Kutu getAltSolKomsu() {
		return altSolKomsu;
	}

	public void setAltSolKomsu(Kutu altSolKomsu) {
		this.altSolKomsu = altSolKomsu;
	}

	public char getHarf() {
		return harf;
	}

	public void setHarf(char harf) {
		this.harf = harf;
	}

	public Kutu getUstKomsu() {
		return ustKomsu;
	}

	public void setUstKomsu(Kutu ustKomsu) {
		this.ustKomsu = ustKomsu;
	}

	public Kutu getAltKomsu() {
		return altKomsu;
	}

	public void setAltKomsu(Kutu altKomsu) {
		this.altKomsu = altKomsu;
	}

	public Kutu getSolKomsu() {
		return solKomsu;
	}

	public void setSolKomsu(Kutu solKomsu) {
		this.solKomsu = solKomsu;
	}

	public Kutu getSagKomsu() {
		return sagKomsu;
	}

	public void setSagKomsu(Kutu sagKomsu) {
		this.sagKomsu = sagKomsu;
	}

	private Kutu sagKomsu;
	
	public Kutu(char harf)
	{
		this.harf = harf;
	}
	
}
