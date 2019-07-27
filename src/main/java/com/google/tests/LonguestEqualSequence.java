package com.google.tests;

import java.util.HashMap;
import java.util.Map;

public class LonguestEqualSequence {

//	Apres avoir trouvé la periode idéale, Papa Superpi à effectué ses reservations. Lors de cette etape, il a gagné
//	à la place, des vacances illimités sur la periode de son choix pendant la saison.
//	Toujours dans un soucis d'egalité, il cherche à faire en sorte que ses enfants pratiquent de maniere egale le Ski et le Snowboard.
//	Ecrire la fonction suivante:
//	int question2(int[] Sk, int[] Sn, int length);
//
//	Cette fonction retourne la duree de la plus grande periode consecutive telle que les deux activités sont pratiquées à parts égales, ou -1 sinon.
//
//	length(Sk)==length(Sn)
//
//	Contraintes:
//
//	0<= Sk[i] <= 480
//	0<= Sn[i] <= 480
//	0<= Sk[i]+Sn[i] <= 480
//	0 <= length <=10000000;
	
	int question2(int[] a, int[] b) {

		Map<Integer, Integer> indexes = new HashMap<>();
		int sum = 0;
		int longest = -1;

		for(int i = 0; i < a.length ; i++) {
			int diff = b[i] - a[i];
			sum += diff;
			Integer index = indexes.get(sum);
			
			if (index != null && i - index > longest)  {
				longest = i - index;	
			}
			if (index == null) {
				indexes.put(sum, i);
			}

//			Equivalent to : 
			
//			if(indexes.containsKey(sum)){
//				longest = Math.max(longest, i-indexes.get(sum));
//			} else {
//				indexes.put(sum, i);
//			}

		}

		return longest;
	}


}
