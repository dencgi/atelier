package dad.atelier1.constructeur;

import org.springframework.stereotype.Service;

@Service
public class ConstructeurCle {

	private int sequenceCle = 0;

	public String getCle() {
		return String.valueOf(++sequenceCle);
	}

}
