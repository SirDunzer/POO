import java.util.Random;

public class Dados{
    private Random Dado = new Random();

	public int rolarD100(){
		return Dado.nextInt(100)+1;
	}

	public int rolarD20(){
		return Dado.nextInt(20)+1;
	}

	public int rolarD12(){
		return Dado.nextInt(12)+1;
	}

	public int rolarD10(){
		return Dado.nextInt(10)+1;
	}

	public int rolarD8(){
		return Dado.nextInt(8)+1;
	}

	public int rolarD6(){
		return Dado.nextInt(6)+1;
	}

	public int rolarD4(){
		return Dado.nextInt(4)+1;
	}

    public int rolarValores(){
        return rolarD6() + rolarD6() + rolarD6();
    }
}
